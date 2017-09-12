package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.Loginlog;
import com.hxf.p2p.base.mapper.LoginlogMapper;
import com.hxf.p2p.base.query.LoginlogQueryObject;
import com.hxf.p2p.base.service.ILoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LoginLogServiceImpl implements ILoginLogService {
    @Autowired
    private LoginlogMapper loginlogMapper;

    @Override
    public PageResult loginlog_list(LoginlogQueryObject qo) {
        Integer count = loginlogMapper.queryCountForPage(qo).intValue();
        if (count > 0) {
            List<Loginlog> loginlogs = loginlogMapper.queryForPage(qo);
            return new PageResult(count, loginlogs, qo.getCurrentPage(), qo.getPageSize());
        }
        return new PageResult(count, Collections.EMPTY_LIST, qo.getCurrentPage(), qo.getPageSize());
    }
}
