package com.hxf.p2p.base.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 验证码数据对象
 */
@Getter
@Setter
public class VerifyCodeVo {
    private String phoneNumber;
    private String verifyCode;
    private Date lastSendTime;
}
