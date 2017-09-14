package com.hxf.p2p.base.service;

import com.hxf.p2p.base.domain.Userinfo;

public interface IUserinfoService {
    void update(Userinfo userinfo);


    void insert(Userinfo userinfo);

    Userinfo get(Long id);

    /**
     * 绑定手机
     *
     * @param phoneNumber 手机号
     * @param verifyCode  验证码
     */
    void bindPhone(String phoneNumber, String verifyCode);

}
