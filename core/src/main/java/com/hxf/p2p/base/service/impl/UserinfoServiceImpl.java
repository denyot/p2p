package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.mapper.UserinfoMapper;
import com.hxf.p2p.base.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements IUserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;

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

}
