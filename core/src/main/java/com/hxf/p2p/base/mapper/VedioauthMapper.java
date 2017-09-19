package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.Vedioauth;
import java.util.List;

public interface VedioauthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Vedioauth record);

    Vedioauth selectByPrimaryKey(Long id);

    List<Vedioauth> selectAll();

    int updateByPrimaryKey(Vedioauth record);
}