package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.BidRequestAuditHistory;
import com.hxf.p2p.base.mapper.BidRequestAuditHistoryMapper;
import com.hxf.p2p.base.service.IBidRequestAuditHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidRequestAuditHistoryServiceImpl implements IBidRequestAuditHistoryService {
    @Autowired
    private BidRequestAuditHistoryMapper bidRequestAuditHistoryMapper;

    @Override
    public List<BidRequestAuditHistory> listByBidRequestId(Long bidRequestId) {
        return bidRequestAuditHistoryMapper.listByBidRequestId(bidRequestId);
    }
}
