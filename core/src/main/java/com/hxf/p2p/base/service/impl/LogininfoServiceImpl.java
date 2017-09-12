package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.Account;
import com.hxf.p2p.base.domain.Logininfo;
import com.hxf.p2p.base.domain.Loginlog;
import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.mapper.LogininfoMapper;
import com.hxf.p2p.base.mapper.LoginlogMapper;
import com.hxf.p2p.base.service.IAccountService;
import com.hxf.p2p.base.service.ILogininfoService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogininfoServiceImpl implements ILogininfoService {
    @Autowired
    private LogininfoMapper logininfoMapper;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private LoginlogMapper loginlogMapper;

    @Override
    public void register(String username, String password) {
        int count = logininfoMapper.getCountByUsername(username);
        if (count <= 0) {
            Logininfo logininfo = new Logininfo();
            logininfo.setState(Logininfo.STATE_NORMAL);
            logininfo.setUsername(username);
            logininfo.setPassword(password);
            logininfoMapper.insert(logininfo);
            //初始化账户信息和个人信息
            Account account = new Account();
            account.setId(logininfo.getId());
            accountService.insert(account);
            Userinfo userinfo = new Userinfo();
            userinfo.setId(logininfo.getId());
            userinfoService.insert(userinfo);
        } else {
            throw new RuntimeException("该用户已存在");
        }
    }

    @Override
    public boolean checkUsername(String username) {
        return logininfoMapper.getCountByUsername(username) > 0;
    }

    @Override
    public Logininfo login(String username, String password, String remoteAddr) {
        Logininfo current = logininfoMapper.login(username, password);
        Loginlog loginlog = new Loginlog();
        loginlog.setIp(remoteAddr);
        loginlog.setLoginTime(new Date());
        loginlog.setUsername(username);
        if (current != null) {
            //把当前用户存放到session中
            loginlog.setState(true);
            UserContext.putCurrent(current);
        } else {
            loginlog.setState(false);
        }
        loginlogMapper.insert(loginlog);
        return current;
    }
}
