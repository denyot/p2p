package com.hxf.p2p.base.service;

import com.hxf.p2p.base.domain.BidRequest;
import com.hxf.p2p.base.domain.BidRequestAuditHistory;

import java.util.List;

public interface IBidRequestAuditHistoryService {
    List<BidRequestAuditHistory> listByBidRequestId(Long id);

    void insertHistory(BidRequest bidRequest, Long id, byte state, String remark, byte auditType);

}
