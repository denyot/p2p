package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.Loginlog;
import com.hxf.p2p.base.query.LoginlogQueryObject;

import java.util.List;

public interface LoginlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Loginlog record);

    Loginlog selectByPrimaryKey(Long id);

    List<Loginlog> selectAll();

    int updateByPrimaryKey(Loginlog record);

    Long queryCountForPage(LoginlogQueryObject qo);

    List<Loginlog> queryForPage(LoginlogQueryObject qo);

}