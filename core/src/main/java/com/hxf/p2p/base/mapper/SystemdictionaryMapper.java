package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.Systemdictionary;
import com.hxf.p2p.base.query.SystemDictionaryQueryObject;

import java.util.List;

public interface SystemdictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Systemdictionary record);

    Systemdictionary selectByPrimaryKey(Long id);

    List<Systemdictionary> selectAll();

    int updateByPrimaryKey(Systemdictionary record);
    Long queryCountForPage(SystemDictionaryQueryObject qo);

    List<Systemdictionary> queryForPage(SystemDictionaryQueryObject qo);
}