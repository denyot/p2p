package com.hxf.p2p.base.service;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.VedioAuth;
import com.hxf.p2p.base.query.VedioAuthQueryObject;

public interface IVedioAuthService {
    VedioAuth selectByPrimaryKey(Long id);

    /**
     *
     * @param vedioAuth
     */
    void apply(VedioAuth vedioAuth);

    PageResult vedioAuth_list(VedioAuthQueryObject qo);

    void audit(Long id, String remark, Byte state);

}
