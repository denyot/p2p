package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.Logininfo;
import com.hxf.p2p.base.mapper.LogininfoMapper;
import com.hxf.p2p.base.service.ILogininfoService;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogininfoServiceImpl implements ILogininfoService {
    @Autowired
    private LogininfoMapper logininfoMapper;

    @Override
    public void register(String username, String password) {
        int count = logininfoMapper.getCountByUsername(username);
        if (count <= 0) {
            Logininfo logininfo = new Logininfo();
            logininfo.setState(Logininfo.STATE_NORMAL);
            logininfo.setUsername(username);
            logininfo.setPassword(password);
            logininfoMapper.insert(logininfo);
        } else {
            throw new RuntimeException("该用户已存在");
        }
    }

    @Override
    public boolean checkUsername(String username) {
        return logininfoMapper.getCountByUsername(username) > 0;
    }

    @Override
    public void login(String username, String password) {
        Logininfo current = logininfoMapper.login(username,password);
        if(current!=null){
            //把当前用户存放到session中
            UserContext.putCurrent(current);
        }else {
            throw new RuntimeException("用户名或密码错误");
        }
    }
}
