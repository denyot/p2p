package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.service.IVerifyCodeService;
import com.hxf.p2p.base.util.BidConst;
import com.hxf.p2p.base.util.DateUtil;
import com.hxf.p2p.base.util.UserContext;
import com.hxf.p2p.base.vo.VerifyCodeVo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService {
    @Override
    public void sendVerifyCode(String phoneNumber) {
        VerifyCodeVo verifyCode = UserContext.getCurrentVerifyCode();
        if (verifyCode == null || DateUtil.secondsDelay(new Date(), verifyCode.getLastSendTime()) > 20) {
            String code = UUID.randomUUID().toString().substring(0, 4);
            verifyCode = new VerifyCodeVo();
            verifyCode.setPhoneNumber(phoneNumber);
            verifyCode.setVerifyCode(code);
            verifyCode.setLastSendTime(new Date());
            UserContext.putCurrentVerifyCode(verifyCode);
            System.out.println("电话号码:" + phoneNumber + "验证码:" + code);
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
