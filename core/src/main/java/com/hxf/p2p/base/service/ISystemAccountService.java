package com.hxf.p2p.base.service;

import com.hxf.p2p.base.domain.BidRequest;
import com.hxf.p2p.base.domain.SystemAccount;

import java.math.BigDecimal;

/**
 * 系统账户
 */
public interface ISystemAccountService {
    void update(SystemAccount systemAccount);

    /**
     * 检查并初始化系统账户
     */
    void initAccount();

    /**
     * 系统账户收到借款管理费
     * @param br
     * @param managementCharge
     */
    void chargeBorrowFee(BidRequest br, BigDecimal managementCharge);

}
