package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.Userfile;
import java.util.List;

public interface UserfileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Userfile record);

    Userfile selectByPrimaryKey(Long id);

    List<Userfile> selectAll();

    int updateByPrimaryKey(Userfile record);

    List<Userfile> listUnTypeFiles(Long logininfoId);
}