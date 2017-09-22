package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.PlatformBankInfo;
import com.hxf.p2p.base.query.QueryObject;

import java.util.List;

public interface PlatformBankInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformBankInfo record);

    PlatformBankInfo selectByPrimaryKey(Long id);

    List<PlatformBankInfo> selectAll();

    int updateByPrimaryKey(PlatformBankInfo record);

    Long queryCountForPage(QueryObject qo);

    List<PlatformBankInfo> queryForPage(QueryObject qo);
}