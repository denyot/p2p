package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.service.IVerifyCodeService;
import com.hxf.p2p.base.util.BidConst;
import com.hxf.p2p.base.util.DateUtil;
import com.hxf.p2p.base.util.UserContext;
import com.hxf.p2p.base.vo.VerifyCodeVo;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.UUID;

@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService {
    @Value("${sms.url}")
    private String url;
    @Value("${sms.secret_key}")
    private String apikey;
    @Value("${sms.appKey}")
    private String key;

    private String getHeader() {
        String auth = key + ":" + apikey;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
        String authHeader = "Basic " + new String(encodedAuth);
        return authHeader;
    }


    @Override
    public void sendVerifyCode(String phoneNumber) {
        //从session中获取验证对象
        VerifyCodeVo verifyCode = UserContext.getCurrentVerifyCode();
        //判断是否发送短信
        if (verifyCode == null || DateUtil.secondsDelay(new Date(), verifyCode.getLastSendTime()) > 20) {
            //发送短信
            //随机生成6位验证码
            String code = UUID.randomUUID().toString().substring(0, 6);
            try {
                URL url = new URL(this.url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //拼接请求地址
                StringBuilder content = new StringBuilder(100);
                content.append("mobile=").append(phoneNumber)
                        .append("&message=").append("系统验证码是:").append(code).append(",520秒内有效").append(",系统运行测试,无需回复!").append("【心烽科技】");
                connection.setRequestProperty("Authorization", this.getHeader());
                //设置请求方式
                connection.setRequestMethod("POST");
                //有请求体
                connection.setDoOutput(true);
                //获取输出流,写入数据
                connection.getOutputStream().write(content.toString().getBytes("UTF-8"));
                //获取响应
                String response = StreamUtils.copyToString(connection.getInputStream(), Charset.forName("UTF-8"));
                if (response.contains("ok")) {
                    verifyCode = new VerifyCodeVo();
                    verifyCode.setPhoneNumber(phoneNumber);
                    verifyCode.setVerifyCode(code);
                    verifyCode.setLastSendTime(new Date());
                    UserContext.putCurrentVerifyCode(verifyCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("短信发送失败");
            }
        } else {
            throw new RuntimeException("发送过于频繁,稍后再试");
        }
    }


    @Override
    public boolean verify(String phoneNumber, String verifyCode) {
        VerifyCodeVo codeVo = UserContext.getCurrentVerifyCode();
        if (codeVo != null
                && codeVo.getPhoneNumber().equals(phoneNumber)
                && codeVo.getVerifyCode().equalsIgnoreCase(verifyCode)
                && DateUtil.secondsDelay(new Date(), codeVo.getLastSendTime()) <= BidConst.VERIFYCODE_VALIDATE_SECONDS) {
            return true;
        }
        return false;
    }
}
