package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.Systemdictionary;
import com.hxf.p2p.base.domain.Systemdictionaryitem;
import com.hxf.p2p.base.mapper.SystemdictionaryMapper;
import com.hxf.p2p.base.mapper.SystemdictionaryitemMapper;
import com.hxf.p2p.base.query.SystemDictionaryQueryObject;
import com.hxf.p2p.base.service.ISyetemDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SyetemDictionaryServiceImpl implements ISyetemDictionaryService {
    @Autowired
    private SystemdictionaryMapper systemdictionaryMapper;
    @Autowired
    private SystemdictionaryitemMapper systemdictionaryitemMapper;

    @Override
    public PageResult systemDictionary_list(SystemDictionaryQueryObject qo) {
        Integer count = systemdictionaryMapper.queryCountForPage(qo).intValue();
        if (count > 0) {
            List<Systemdictionary> systemdictionaries = systemdictionaryMapper.queryForPage(qo);
            return new PageResult(count, systemdictionaries, qo.getCurrentPage(), qo.getPageSize());
        }
        return new PageResult(count, Collections.EMPTY_LIST, qo.getCurrentPage(), qo.getPageSize());
    }

    @Override
    public void systemDictionary_saveOrUpdate(Systemdictionary systemdictionary) {
        if (systemdictionary.getId() == null) {
            systemdictionaryMapper.insert(systemdictionary);
        } else {
            systemdictionaryMapper.updateByPrimaryKey(systemdictionary);
        }
    }

    @Override
    public PageResult systemDictionaryItem_list(SystemDictionaryQueryObject qo) {
        Integer count = systemdictionaryitemMapper.queryCountForPage(qo).intValue();
        if (count > 0) {
            List<Systemdictionaryitem> systemdictionaryitems = systemdictionaryitemMapper.queryForPage(qo);
            return new PageResult(count, systemdictionaryitems, qo.getCurrentPage(), qo.getPageSize());
        }
        return new PageResult(count, Collections.EMPTY_LIST, qo.getCurrentPage(), qo.getPageSize());
    }

    @Override
    public List<Systemdictionary> selectAll() {
        return systemdictionaryMapper.selectAll();
    }

    @Override
    public void systemDictionaryItem_saveOrUpdate(Systemdictionaryitem systemdictionaryitem) {
        if (systemdictionaryitem.getId() == null) {
            systemdictionaryitemMapper.insert(systemdictionaryitem);
        } else {
            systemdictionaryitemMapper.updateByPrimaryKey(systemdictionaryitem);
        }
    }

    @Override
    public List<Systemdictionaryitem> selectItemBySn(String sn) {
        return systemdictionaryitemMapper.selectItemBySn(sn);
    }

}
