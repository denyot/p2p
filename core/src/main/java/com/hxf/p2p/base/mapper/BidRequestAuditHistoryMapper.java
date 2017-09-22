package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.BidRequestAuditHistory;
import java.util.List;

public interface BidRequestAuditHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BidRequestAuditHistory record);

    BidRequestAuditHistory selectByPrimaryKey(Long id);

    List<BidRequestAuditHistory> selectAll();

    int updateByPrimaryKey(BidRequestAuditHistory record);

    List<BidRequestAuditHistory> listByBidRequestId(Long bidRequestId);

}