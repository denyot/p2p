package com.hxf.p2p.base.service;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.query.LoginlogQueryObject;
import org.springframework.stereotype.Service;

@Service
public interface ILoginLogService {

    PageResult loginlog_list(LoginlogQueryObject qo);
}
