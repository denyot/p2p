package com.hxf.p2p.base.service;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.PlatformBankInfo;
import com.hxf.p2p.base.query.LoginlogQueryObject;
import com.hxf.p2p.base.query.QueryObject;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPlatformBankInfoService {

    PageResult platformBankInfo_list(QueryObject qo);

    void saveOrUpdate(PlatformBankInfo platformBankInfo);

    List<PlatformBankInfo> selectAll();
}
