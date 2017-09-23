package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.SystemAccount;
import java.util.List;

public interface SystemAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemAccount record);

    SystemAccount selectByPrimaryKey(Long id);

    List<SystemAccount> selectAll();

    int updateByPrimaryKey(SystemAccount record);
}