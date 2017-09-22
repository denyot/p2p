package com.hxf.p2p.base.service;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.PlatformBankInfo;
import com.hxf.p2p.base.domain.RechargeOffline;
import com.hxf.p2p.base.query.QueryObject;
import com.hxf.p2p.base.query.RechargeOfflineQueryObject;

public interface IRechargeOfflineService {

    PageResult rechargeOffline_list(RechargeOfflineQueryObject qo);

    void save(RechargeOffline rechargeOffline);

    /**
     * 充值审核
     * @param id
     * @param remark
     * @param state
     */
    void audit(Long id, String remark, byte state);

}
