package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.Account;
import com.hxf.p2p.base.domain.AccountFlow;
import com.hxf.p2p.base.domain.Bid;
import com.hxf.p2p.base.domain.RechargeOffline;
import com.hxf.p2p.base.mapper.AccountFlowMapper;
import com.hxf.p2p.base.service.IAccountFlowService;
import com.hxf.p2p.base.util.BidConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountFlowServiceImpl implements IAccountFlowService {
    @Autowired
    private AccountFlowMapper accountFlowMapper;

    /**
     * 创建
     *
     * @param account
     * @return
     */
    private AccountFlow createFlow(Account account) {
        AccountFlow accountFlow = new AccountFlow();
        accountFlow.setAccountId(account.getId());
        accountFlow.setActionTime(new Date());
        accountFlow.setBalance(account.getUsableAmount());
        accountFlow.setFreezed(account.getFreezedAmount());
        return accountFlow;
    }

    @Override
    public void rechargeFlow(RechargeOffline r, Account account) {
        AccountFlow accountFlow = createFlow(account);
        accountFlow.setAccountActionType(BidConst.ACCOUNT_ACTIONTYPE_DEPOSIT_OFFLINE);
        accountFlow.setAmount(r.getAmount());
        accountFlow.setNote("线下充值成功,充值金额为:" + r.getAmount());
        accountFlowMapper.insert(accountFlow);

    }

    @Override
    public void bid(Bid bid, Account account) {
        AccountFlow accountFlow = createFlow(account);
        accountFlow.setAccountActionType(BidConst.ACCOUNT_ACTIONTYPE_BID_SUCCESSFUL);
        accountFlow.setAmount(bid.getAvailableAmount());
        accountFlow.setNote("投标:" + bid.getBidRequestTitle() + "成功,冻结金额为:" + bid.getAvailableAmount());
        accountFlowMapper.insert(accountFlow);
    }
}
