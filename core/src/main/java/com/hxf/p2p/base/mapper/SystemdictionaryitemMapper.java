package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.Systemdictionaryitem;
import com.hxf.p2p.base.query.SystemDictionaryQueryObject;
import java.util.List;

public interface SystemdictionaryitemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Systemdictionaryitem record);

    Systemdictionaryitem selectByPrimaryKey(Long id);

    List<Systemdictionaryitem> selectAll();

    int updateByPrimaryKey(Systemdictionaryitem record);

    Long queryCountForPage(SystemDictionaryQueryObject qo);

    List<Systemdictionaryitem> queryForPage(SystemDictionaryQueryObject qo);

    List<Systemdictionaryitem> selectItemBySn(String sn);

}