package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.Logininfo;
import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.domain.VedioAuth;
import com.hxf.p2p.base.mapper.VedioAuthMapper;
import com.hxf.p2p.base.query.VedioAuthQueryObject;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.service.IVedioAuthService;
import com.hxf.p2p.base.util.BitStatesUtils;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class VedioAuthServiceImpl implements IVedioAuthService {
    @Autowired
    private VedioAuthMapper vedioAuthMapper;
    @Autowired
    private IUserinfoService userinfoService;

    @Override
    public VedioAuth selectByPrimaryKey(Long id) {
        return vedioAuthMapper.selectByPrimaryKey(id);
    }

    @Override
    public void apply(VedioAuth vedioAuth) {
//        Userinfo current = userinfoService.getCurrent();
//        if (!current.getIsVedioAuth() && current.getVedioAuthId() == null) {
//            vedioAuth.setState(VedioAuth.STATE_NORMAL);
//            vedioAuth.setApplier(UserContext.getCurrent());
//            vedioAuth.setApplyTime(new Date());
//            vedioAuthMapper.insert(vedioAuth);
//            current.setVedioAuthId(vedioAuth.getId());
//            userinfoService.update(current);
//        }

    }

    @Override
    public PageResult vedioAuth_list(VedioAuthQueryObject qo) {
        Integer count = vedioAuthMapper.queryCountForPage(qo).intValue();
        if (count > 0) {
            List<VedioAuth> vedioAuths = vedioAuthMapper.queryForPage(qo);
            return new PageResult(count, vedioAuths, qo.getCurrentPage(), qo.getPageSize());
        }
        return new PageResult(count, Collections.EMPTY_LIST, qo.getCurrentPage(), qo.getPageSize());
    }

    @Override
    public void audit(Long id, String remark, Byte state) {
        Userinfo userinfo = userinfoService.get(id);
        if (userinfo != null && userinfo.getIsVedioAuth()) {
            VedioAuth vedioAuth = new VedioAuth();
            Logininfo applier = new Logininfo();
            applier.setId(id);
            vedioAuth.setApplier(applier);
            vedioAuth.setApplyTime(new Date());
            vedioAuth.setAuditor(UserContext.getCurrent());
            vedioAuth.setAuditTime(new Date());
            vedioAuth.setRemark(remark);
            vedioAuth.setState(state);
            vedioAuthMapper.insert(vedioAuth);
            if (state == VedioAuth.STATE_AUDIT) {
                userinfo.setBitState(BitStatesUtils.addState(userinfo.getBitState(), BitStatesUtils.OP_VEDIO_AUTH));
                userinfoService.update(userinfo);
            }
        }

    }
}
