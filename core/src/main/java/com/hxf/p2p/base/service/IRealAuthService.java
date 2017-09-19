package com.hxf.p2p.base.service;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.RealAuth;
import com.hxf.p2p.base.query.RealAuthQueryObject;

public interface IRealAuthService {
    RealAuth selectByPrimaryKey(Long id);

    /**
     *
     * @param realAuth
     */
    void apply(RealAuth realAuth);

    PageResult realAuth_list(RealAuthQueryObject qo);

    void audit(Long id, String remark, Byte state);

}
