package com.hxf.p2p.base.service;

import com.hxf.p2p.base.domain.Userinfo;

public interface IUserinfoService {
    void update(Userinfo userinfo);


    void insert(Userinfo userinfo);

    Userinfo get(Long id);

}
