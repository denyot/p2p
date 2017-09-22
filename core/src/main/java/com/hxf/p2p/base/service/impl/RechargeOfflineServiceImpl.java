package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.Account;
import com.hxf.p2p.base.domain.RechargeOffline;
import com.hxf.p2p.base.mapper.RechargeOfflineMapper;
import com.hxf.p2p.base.query.RechargeOfflineQueryObject;
import com.hxf.p2p.base.service.IAccountFlowService;
import com.hxf.p2p.base.service.IAccountService;
import com.hxf.p2p.base.service.IRechargeOfflineService;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class RechargeOfflineServiceImpl implements IRechargeOfflineService {
    @Autowired
    private RechargeOfflineMapper rechargeOfflineMapper;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IAccountFlowService accountFlowService;

    @Override
    public PageResult rechargeOffline_list(RechargeOfflineQueryObject qo) {
        Integer count = rechargeOfflineMapper.queryCountForPage(qo).intValue();
        if (count > 0) {
            List<RechargeOffline> rechargeOfflineList = rechargeOfflineMapper.queryForPage(qo);
            return new PageResult(count, rechargeOfflineList, qo.getCurrentPage(), qo.getPageSize());
        }
        return new PageResult(count, Collections.EMPTY_LIST, qo.getCurrentPage(), qo.getPageSize());
    }

    @Override
    public void save(RechargeOffline rechargeOffline) {
        rechargeOffline.setApplier(UserContext.getCurrent());
        rechargeOffline.setApplyTime(new Date());
        rechargeOffline.setState(RechargeOffline.STATE_NORMAL);
        rechargeOfflineMapper.insert(rechargeOffline);
    }

    @Override
    public void audit(Long id, String remark, byte state) {
        //获取对应用户的线下充值对象
        RechargeOffline r = rechargeOfflineMapper.selectByPrimaryKey(id);
        if (r != null && r.getState() == RechargeOffline.STATE_NORMAL) {
            r.setAuditor(UserContext.getCurrent());
            r.setAuditTime(new Date());
            r.setState(state);
            r.setRemark(remark);
            //审核通过
            if(state==RechargeOffline.STATE_AUDIT){
                Account applierAccount = accountService.get(r.getApplier().getId());
                //增加用户账户可用余额
                applierAccount.setUsableAmount(applierAccount.getUsableAmount().add(r.getAmount()));
                //生成一条充值流水
                accountFlowService.rechargeFlow(r,applierAccount);
                accountService.update(applierAccount);
            }
            rechargeOfflineMapper.updateByPrimaryKey(r);
        }
    }
}
