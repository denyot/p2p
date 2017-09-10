package com.hxf.p2p.base.service;

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
}
