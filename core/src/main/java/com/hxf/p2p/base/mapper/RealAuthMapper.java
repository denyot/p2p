package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.RealAuth;
import com.hxf.p2p.base.domain.Systemdictionaryitem;
import com.hxf.p2p.base.query.RealAuthQueryObject;
import com.hxf.p2p.base.query.SystemDictionaryQueryObject;

import java.util.List;

public interface RealAuthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RealAuth record);

    RealAuth selectByPrimaryKey(Long id);

    List<RealAuth> selectAll();

    int updateByPrimaryKey(RealAuth record);
    Long queryCountForPage(RealAuthQueryObject qo);

    List<RealAuth> queryForPage(RealAuthQueryObject qo);
}