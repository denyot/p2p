package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.MailVerify;
import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.mapper.MailVerifyMapper;
import com.hxf.p2p.base.mapper.UserinfoMapper;
import com.hxf.p2p.base.service.IMailService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.service.IVerifyCodeService;
import com.hxf.p2p.base.util.BidConst;
import com.hxf.p2p.base.util.BitStatesUtils;
import com.hxf.p2p.base.util.DateUtil;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserinfoServiceImpl implements IUserinfoService {
    @Value("${email.url}")
    private String url;
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private IVerifyCodeService verifyCodeService;
    @Autowired
    private MailVerifyMapper mailVerifyMapper;
    @Autowired
    private IMailService mailService;

    @Override
    public void update(Userinfo userinfo) {
        int i = userinfoMapper.updateByPrimaryKey(userinfo);
        if (i == 0) {
            throw new RuntimeException("乐观锁失败,Logininfo:" + userinfo.getId());
        }
    }

    @Override
    public void insert(Userinfo userinfo) {
        userinfoMapper.insert(userinfo);
    }

    @Override
    public Userinfo get(Long id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取当前登陆用户的个人资料
     *
     * @return
     */
    @Override
    public Userinfo getCurrent() {
        return this.get(UserContext.getCurrent().getId());
    }

    @Override
    public void bindPhone(String phoneNumber, String verifyCode) {
        Userinfo current = getCurrent();
        if (!current.getIsBindPhone()) {
            boolean ret = verifyCodeService.verify(phoneNumber, verifyCode);
            if (ret) {
                current.setBitState(BitStatesUtils.addState(current.getBitState(), BitStatesUtils.OP_BIND_PHONE));
                current.setPhoneNumber(phoneNumber);
                this.update(current);
            } else {
                throw new RuntimeException("绑定手机失败");
            }
        }
    }


    @Override
    public void sendVerifyEmail(String email) {
        Userinfo current = getCurrent();
        //判断用户是否绑定邮箱
        if (!current.getIsBindEmail()) {
            String uuid = UUID.randomUUID().toString();
            //创建邮件
            StringBuilder content = new StringBuilder(100);
            content.append("点击<a href='").append(this.url).append("bindEmail?key=").append(uuid)
                    .append("'>这里</a>完成邮箱绑定,有效期为").append(BidConst.VERIFYEMAIL_VALIDATE_DAY).append("天");
            //存储邮件信息
            try {
                System.out.println(content);
                MailVerify mailVerify = new MailVerify(current.getId(), new Date(), uuid, email);
                mailVerifyMapper.insert(mailVerify);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("邮箱发送失败");
            }
            //发送邮件
            mailService.sendMail(email,"邮箱绑定验证连接",content.toString());

        }
    }

    @Override
    public void bindEmail(String key) {
        //根据uuid查询对应验证邮件
        MailVerify mailVerify = mailVerifyMapper.selectByUUID(key);
        if (mailVerify != null) {
            //查询对应要绑定邮箱的用户资料
            Userinfo userinfo = this.get(mailVerify.getUserinfoId());
            //用户没有绑定邮箱且验证邮件在有效期内
            if (!userinfo.getIsBindEmail() && (DateUtil.secondsDelay(mailVerify.getDeadline(), new Date()) / (60 * 60 * 24)) <= BidConst.VERIFYEMAIL_VALIDATE_DAY) {
                //绑定邮箱
                userinfo.setBitState(BitStatesUtils.addState(userinfo.getBitState(), BitStatesUtils.OP_BIND_EMAIL));
                userinfo.setEmail(mailVerify.getEmail());
                this.update(userinfo);
                return;
            }
        }
        throw new RuntimeException("绑定邮箱失败");
    }
}
