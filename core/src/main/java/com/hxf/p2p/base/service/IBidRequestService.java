package com.hxf.p2p.base.service;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.BidRequest;
import com.hxf.p2p.base.query.BidRequestQueryObject;

import java.math.BigDecimal;
import java.util.List;

public interface IBidRequestService {
    void update(BidRequest bidRequest);

    /**
     * 判断用户是否满足申请借款条件
     * @return
     */
    boolean canApplyBidRequeset(Long loginInfoId);

    /**
     * 申请借款
     * @param bidRequest
     */
    void apply(BidRequest bidRequest);

    PageResult bidRequest_list(BidRequestQueryObject qo);

    /**
     * 发标前审核
     * @param id
     * @param remark
     * @param state
     */
    void publishAudit(Long id, String remark, Byte state);

    BidRequest get(Long id);

    List<BidRequest> listIndex(int size);

    /**
     * 投标
     * @param bidRequestId
     * @param amount
     */
    void bid(Long bidRequestId, BigDecimal amount);

    /**
     * 满标一审
     * @param id
     * @param remark
     * @param state
     */
    void bidRequestFullAudit1(Long id, String remark, Byte state);

}
