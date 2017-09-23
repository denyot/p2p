package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.BidRequest;
import com.hxf.p2p.base.domain.BidRequestAuditHistory;
import com.hxf.p2p.base.mapper.BidRequestAuditHistoryMapper;
import com.hxf.p2p.base.service.IBidRequestAuditHistoryService;
import com.hxf.p2p.base.util.BidConst;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BidRequestAuditHistoryServiceImpl implements IBidRequestAuditHistoryService {
    @Autowired
    private BidRequestAuditHistoryMapper bidRequestAuditHistoryMapper;

    @Override
    public List<BidRequestAuditHistory> listByBidRequestId(Long bidRequestId) {
        return bidRequestAuditHistoryMapper.listByBidRequestId(bidRequestId);
    }

    @Override
    public void insertHistory(BidRequest bidRequest, Long id, byte state, String remark, byte auditType) {
        BidRequestAuditHistory history = new BidRequestAuditHistory();
        history.setApplier(bidRequest.getCreateUser());
        history.setApplyTime(bidRequest.getApplyTime());
        history.setAuditor(UserContext.getCurrent());
        history.setAuditTime(new Date());
        history.setBidRequestId(id);
        history.setState(state);
        history.setRemark(remark);
        history.setAuditType(BidConst.BIDREQUEST_STATE_APPROVE_PENDING_2);
        this.bidRequestAuditHistoryMapper.insert(history);
    }
}
