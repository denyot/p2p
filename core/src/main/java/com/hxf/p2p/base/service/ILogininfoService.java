package com.hxf.p2p.base.service;

import com.hxf.p2p.base.domain.Logininfo;

/**
 * 登陆相关服务
 */
public interface ILogininfoService {
    /**
     * 用户注册
     * @param username
     * @param password
     */
    void register(String username, String password);

    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    boolean checkUsername(String username);

    Logininfo login(String username, String password, String remoteAddr);

}
