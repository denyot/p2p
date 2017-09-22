package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.PlatformBankInfo;
import com.hxf.p2p.base.mapper.PlatformBankInfoMapper;
import com.hxf.p2p.base.query.QueryObject;
import com.hxf.p2p.base.service.IPlatformBankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PlatformBankInfoServiceImpl implements IPlatformBankInfoService {
    @Autowired
    private PlatformBankInfoMapper platformBankInfoMapper;

    @Override
    public PageResult platformBankInfo_list(QueryObject qo) {
        Integer count = platformBankInfoMapper.queryCountForPage(qo).intValue();
        if (count > 0) {
            List<PlatformBankInfo> platformBankInfoList = platformBankInfoMapper.queryForPage(qo);
            return new PageResult(count, platformBankInfoList, qo.getCurrentPage(), qo.getPageSize());
        }
        return new PageResult(count, Collections.EMPTY_LIST, qo.getCurrentPage(), qo.getPageSize());
    }

    @Override
    public void saveOrUpdate(PlatformBankInfo platformBankInfo) {
        if (platformBankInfo.getId() != null) {
            platformBankInfoMapper.updateByPrimaryKey(platformBankInfo);
        } else {
            platformBankInfoMapper.insert(platformBankInfo);
        }
    }

    @Override
    public List<PlatformBankInfo> selectAll() {
        return platformBankInfoMapper.selectAll();
    }
}
