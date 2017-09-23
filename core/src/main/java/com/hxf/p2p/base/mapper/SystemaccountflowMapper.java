package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.Systemaccountflow;
import java.util.List;

public interface SystemaccountflowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Systemaccountflow record);

    Systemaccountflow selectByPrimaryKey(Long id);

    List<Systemaccountflow> selectAll();

    int updateByPrimaryKey(Systemaccountflow record);
}