package com.hxf.p2p.base.service;

/**
 * 验证码
 */
public interface IVerifyCodeService {
    /**
     * 给手机发送验证码
     * @param phoneNumber
     */
    void sendVerifyCode(String phoneNumber);

    /**
     * 校验验证码
     * @param phoneNumber
     * @param verifyCode
     * @return
     */
    boolean verify(String phoneNumber, String verifyCode);



}
