package com.hxf.p2p.base.service;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.Systemdictionary;
import com.hxf.p2p.base.domain.Systemdictionaryitem;
import com.hxf.p2p.base.query.SystemDictionaryQueryObject;

import java.util.List;

public interface ISyetemDictionaryService {
    PageResult systemDictionary_list(SystemDictionaryQueryObject qo);

    void systemDictionary_saveOrUpdate(Systemdictionary systemdictionary);

    PageResult systemDictionaryItem_list(SystemDictionaryQueryObject qo);

    List<Systemdictionary> selectAll();

    void systemDictionaryItem_saveOrUpdate(Systemdictionaryitem systemdictionaryitem);

    List<Systemdictionaryitem> selectItemBySn(String sn);
}
