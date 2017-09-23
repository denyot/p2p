package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.BidRequest;
import com.hxf.p2p.base.domain.SystemAccount;
import com.hxf.p2p.base.mapper.SystemAccountMapper;
import com.hxf.p2p.base.service.ISystemAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SystemAccountServiceImpl implements ISystemAccountService {
    @Autowired
    private SystemAccountMapper systemAccountMapper;

    @Override
    public void update(SystemAccount systemAccount) {
        int i = systemAccountMapper.updateByPrimaryKey(systemAccount);
        if (i == 0) {
            throw new RuntimeException("系统账户对象乐观锁失败");
        }
    }

    @Override
    public void initAccount() {
    }

    @Override
    public void chargeBorrowFee(BidRequest br, BigDecimal managementCharge) {
        //得到当前系统账户
        //修改账户余额
        //生成收款流水

    }
}
