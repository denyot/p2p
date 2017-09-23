package com.hxf.p2p.base.service;

import com.hxf.p2p.base.domain.BidRequest;
import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.util.BitStatesUtils;

public interface IUserinfoService {
    void update(Userinfo userinfo);


    void insert(Userinfo userinfo);

    /**
     * 以主键的方式获取个人资料
     *
     * @param id
     * @return
     */
    Userinfo get(Long id);

    /**
     * 绑定手机
     *
     * @param phoneNumber 手机号
     * @param verifyCode  验证码
     */
    void bindPhone(String phoneNumber, String verifyCode);

    /**
     * 绑定邮箱
     *
     * @param key
     */
    void bindEmail(String key);

    Userinfo getCurrent();

    /**
     * 发送验证邮件
     *
     * @param email
     */
    void sendVerifyEmail(String email);

    /**
     * 更新用户基本信息
     * @param userinfo
     */
    void updateBasicInfo(Userinfo userinfo);

    /**
     *
     */
    void removeRequestState(BidRequest bidRequest);
}
