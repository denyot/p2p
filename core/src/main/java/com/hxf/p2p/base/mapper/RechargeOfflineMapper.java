package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.RechargeOffline;
import com.hxf.p2p.base.query.RechargeOfflineQueryObject;

import java.util.List;

public interface RechargeOfflineMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RechargeOffline record);

    RechargeOffline selectByPrimaryKey(Long id);

    List<RechargeOffline> selectAll();

    int updateByPrimaryKey(RechargeOffline record);

    Long queryCountForPage(RechargeOfflineQueryObject qo);

    List<RechargeOffline> queryForPage(RechargeOfflineQueryObject qo);
}