package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.Account;
import com.hxf.p2p.base.mapper.AccountMapper;
import com.hxf.p2p.base.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void update(Account account) {
        int i = accountMapper.updateByPrimaryKey(account);
        if (i == 0) {
            throw new RuntimeException("乐观锁失败,Account:" + account.getId());
        }

    }

    @Override
    public void insert(Account account) {
        accountMapper.insert(account);
    }

    @Override
    public Account get(Long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

}
