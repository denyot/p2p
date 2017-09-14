package com.hxf.p2p.base.service;

/**
 * 验证码
 */
public interface IVerifyCodeService {
    void sendVerifyCode(String phoneNumber);

    /**
     * 校验验证码
     * @param phoneNumber
     * @param verifyCode
     * @return
     */
    boolean verify(String phoneNumber, String verifyCode);
}
