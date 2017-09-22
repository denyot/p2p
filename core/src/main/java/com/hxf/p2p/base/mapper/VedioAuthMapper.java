package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.VedioAuth;
import com.hxf.p2p.base.domain.VedioAuth;
import com.hxf.p2p.base.query.VedioAuthQueryObject;

import java.util.List;

public interface VedioAuthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VedioAuth record);

    VedioAuth selectByPrimaryKey(Long id);

    List<VedioAuth> selectAll();

    int updateByPrimaryKey(VedioAuth record);

    Long queryCountForPage(VedioAuthQueryObject qo);

    List<VedioAuth> queryForPage(VedioAuthQueryObject qo);
}