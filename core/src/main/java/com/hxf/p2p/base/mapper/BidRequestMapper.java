package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.BidRequest;
import com.hxf.p2p.base.domain.VedioAuth;
import com.hxf.p2p.base.query.BidRequestQueryObject;
import com.hxf.p2p.base.query.VedioAuthQueryObject;

import java.util.List;

public interface BidRequestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BidRequest record);

    BidRequest selectByPrimaryKey(Long id);

    List<BidRequest> selectAll();

    int updateByPrimaryKey(BidRequest record);
    Long queryCountForPage(BidRequestQueryObject qo);

    List<BidRequest> queryForPage(BidRequestQueryObject qo);

}