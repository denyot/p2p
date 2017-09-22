package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.Account;
import com.hxf.p2p.base.domain.BidRequest;
import com.hxf.p2p.base.domain.BidRequestAuditHistory;
import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.mapper.BidRequestAuditHistoryMapper;
import com.hxf.p2p.base.mapper.BidRequestMapper;
import com.hxf.p2p.base.query.BidRequestQueryObject;
import com.hxf.p2p.base.service.IAccountService;
import com.hxf.p2p.base.service.IBidRequestService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.util.BidConst;
import com.hxf.p2p.base.util.BitStatesUtils;
import com.hxf.p2p.base.util.CalculatetUtil;
import com.hxf.p2p.base.util.UserContext;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class BidRequestServiceImpl implements IBidRequestService {
    @Autowired
    private BidRequestMapper bidRequestMapper;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private BidRequestAuditHistoryMapper bidRequestAuditHistoryMapper;

    @Override
    public void update(BidRequest bidRequest) {
        int i = bidRequestMapper.updateByPrimaryKey(bidRequest);
        if (i == 0) {
            throw new RuntimeException("乐观锁失败 bidRequest:" + bidRequest.getId());
        }
    }

    @Override
    public boolean canApplyBidRequeset(Long loginInfoId) {
        Userinfo userinfo = userinfoService.get(loginInfoId);
        return userinfo != null && userinfo.getIsVedioAuth() && userinfo.getIsRealAuth() && userinfo.getIsBaseInfo() && !userinfo.getHasBidrequstProcess();
    }

    @Override
    public void apply(BidRequest bidRequest) {
        Long id = UserContext.getCurrent().getId();
        Account account = accountService.get(id);
        if (this.canApplyBidRequeset(id)
                && bidRequest.getBidRequestAmount().compareTo(BidConst.SMALLEST_BIDREQUEST_AMOUNT) >= 0//借款金额不小于最少借款金额
                && bidRequest.getBidRequestAmount().compareTo(account.getRemainBorrowLimit()) <= 0//借款金额不大于剩余信用额度
                && bidRequest.getCurrentRate().compareTo(BidConst.SMALLEST_CURRENT_RATE) >= 0//借款利率的范围
                && bidRequest.getCurrentRate().compareTo(BidConst.MAX_CURRENT_RATE) <= 0//借款利率的范围
                && bidRequest.getMinBidAmount().compareTo(BidConst.SMALLEST_BID_AMOUNT) >= 0//最小投标不小于系统最小投标金额
                ) {
            BidRequest br = new BidRequest();
            br.setBidRequestAmount(bidRequest.getBidRequestAmount());
            br.setCurrentRate(bidRequest.getCurrentRate());
            br.setDescription(bidRequest.getDescription());
            br.setDisableDays(bidRequest.getDisableDays());
            br.setMinBidAmount(bidRequest.getMinBidAmount());
            br.setReturnType(bidRequest.getReturnType());
            br.setTitle(bidRequest.getTitle());
            br.setMonthes2Return(bidRequest.getMonthes2Return());
            br.setApplyTime(new Date());
            br.setBidRequestState(BidConst.BIDREQUEST_STATE_PUBLISH_PENDING);
            br.setCreateUser(UserContext.getCurrent());
            br.setTotalRewardAmount(CalculatetUtil.calTotalInterest(br.getReturnType(), br.getBidRequestAmount(), br.getCurrentRate(), br.getMonthes2Return()));
            this.bidRequestMapper.insert(br);
            Userinfo userinfo = userinfoService.getCurrent();
            userinfo.setBitState(BitStatesUtils.addState(userinfo.getBitState(), BitStatesUtils.OP_HAS_BIDREQUST_IN_PROCESS));
            userinfoService.update(userinfo);
        }


    }

    @Override
    public PageResult bidRequest_list(BidRequestQueryObject qo) {
        Integer count = bidRequestMapper.queryCountForPage(qo).intValue();
        if (count > 0) {
            List<BidRequest> bidRequests = bidRequestMapper.queryForPage(qo);
            return new PageResult(count, bidRequests, qo.getCurrentPage(), qo.getPageSize());
        }
        return new PageResult(count, Collections.EMPTY_LIST, qo.getCurrentPage(), qo.getPageSize());
    }

    @Override
    public void publishAudit(Long id, String remark, Byte state) {
        BidRequest bidRequest = bidRequestMapper.selectByPrimaryKey(id);
        if (bidRequest != null && bidRequest.getBidRequestState() == BidConst.BIDREQUEST_STATE_PUBLISH_PENDING) {
            BidRequestAuditHistory history = new BidRequestAuditHistory();
            history.setRemark(remark);
            history.setApplyTime(bidRequest.getApplyTime());
            history.setAuditTime(new Date());
            history.setApplier(bidRequest.getCreateUser());
            history.setAuditor(UserContext.getCurrent());
            history.setBidRequestId(bidRequest.getId());
            history.setAuditType(BidRequestAuditHistory.publish_audit);
            history.setState(state);
            bidRequestAuditHistoryMapper.insert(history);
            if (state == BidRequestAuditHistory.STATE_AUDIT) {
                bidRequest.setBidRequestState(BidConst.BIDREQUEST_STATE_BIDDING);
                bidRequest.setDisableDate(DateUtils.addDays(new Date(), bidRequest.getDisableDays()));
                bidRequest.setPublishTime(new Date());
            } else {
                bidRequest.setBidRequestState(BidConst.BIDREQUEST_STATE_PUBLISH_REFUSE);
                Userinfo appler = userinfoService.get(bidRequest.getCreateUser().getId());
                appler.removeState(BitStatesUtils.OP_HAS_BIDREQUST_IN_PROCESS);
                userinfoService.update(appler);
            }
            bidRequest.setNote(remark);
            this.update(bidRequest);
        }
    }

    @Override
    public BidRequest get(Long id) {
        return bidRequestMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BidRequest> listIndex(int size) {
        BidRequestQueryObject qo = new BidRequestQueryObject();
        qo.setBidRequestStates(new byte[]{BidConst.BIDREQUEST_STATE_BIDDING, BidConst.BIDREQUEST_STATE_PAYING_BACK, BidConst.BIDREQUEST_STATE_COMPLETE_PAY_BACK});
        qo.setPageSize(size);
        qo.setCurrentPage(1);
        qo.setOrderBy("bidRequestState");
        qo.setOrderType("ASC");
        return bidRequestMapper.queryForPage(qo);
    }
}
