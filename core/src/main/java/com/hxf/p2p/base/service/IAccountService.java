package com.hxf.p2p.base.service;

import com.hxf.p2p.base.domain.Account;

/**
 * 账户信息服务
 */
public interface IAccountService {
    void update(Account account);

    void insert(Account account);

    Account get(Long id);

    Account getCurrent();


}
