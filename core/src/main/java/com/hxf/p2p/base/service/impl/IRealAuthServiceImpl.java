package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.RealAuth;
import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.mapper.RealAuthMapper;
import com.hxf.p2p.base.query.RealAuthQueryObject;
import com.hxf.p2p.base.service.IRealAuthService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.util.BitStatesUtils;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class IRealAuthServiceImpl implements IRealAuthService {
    @Autowired
    private RealAuthMapper realAuthMapper;
    @Autowired
    private IUserinfoService userinfoService;

    @Override
    public RealAuth selectByPrimaryKey(Long id) {
        return realAuthMapper.selectByPrimaryKey(id);
    }

    @Override
    public void apply(RealAuth realAuth) {
        Userinfo current = userinfoService.getCurrent();
        if (!current.getIsRealAuth() && current.getRealAuthId() == null) {
            realAuth.setState(RealAuth.STATE_NORMAL);
            realAuth.setApplier(UserContext.getCurrent());
            realAuth.setApplyTime(new Date());
            realAuthMapper.insert(realAuth);
            current.setRealAuthId(realAuth.getId());
            userinfoService.update(current);
        }

    }

    @Override
    public PageResult realAuth_list(RealAuthQueryObject qo) {
        Integer count = realAuthMapper.queryCountForPage(qo).intValue();
        if (count > 0) {
            List<RealAuth> realAuths = realAuthMapper.queryForPage(qo);
            return new PageResult(count, realAuths, qo.getCurrentPage(), qo.getPageSize());
        }
        return new PageResult(count, Collections.EMPTY_LIST, qo.getCurrentPage(), qo.getPageSize());
    }

    @Override
    public void audit(Long id, String remark, Byte state) {
        RealAuth realAuth = selectByPrimaryKey(id);
        if (realAuth != null && realAuth.getState() == RealAuth.STATE_NORMAL) {
            realAuth.setAuditor((UserContext.getCurrent()));
            realAuth.setState(state);
            realAuth.setAuditTime(new Date());
            Userinfo applier = userinfoService.get(realAuth.getApplier().getId());
            if (state == RealAuth.STATE_AUDIT) {
                if (!applier.getIsRealAuth()) {
                    applier.setBitState(BitStatesUtils.addState(applier.getBitState(), BitStatesUtils.OP_REAL_AUTH));
                    applier.setRealName(realAuth.getRealname());
                    applier.setIdNumber(realAuth.getIdNumber());
                    applier.setRealAuthId(realAuth.getId());
                } else {
                    applier.setRealAuthId(null);
                }
                userinfoService.update(applier);
                realAuthMapper.updateByPrimaryKey(realAuth);
            }
        }
    }
}
