package com.hxf.p2p.base.service;

import com.hxf.p2p.base.domain.Account;
import com.hxf.p2p.base.domain.Bid;
import com.hxf.p2p.base.domain.RechargeOffline; /**
 * 账户流水
 */
public interface IAccountFlowService {
    /**
     * 账户充值流水
     * @param r  充值对象
     * @param applierAccount  充值账户
     */
    void rechargeFlow(RechargeOffline r, Account applierAccount);

    /**
     * 账户投标流水
     * @param bid 投标对象
     * @param currentAccount  投标账户
     */
    void bid(Bid bid, Account currentAccount);
}
