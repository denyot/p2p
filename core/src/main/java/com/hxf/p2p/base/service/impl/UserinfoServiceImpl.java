package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.mapper.UserinfoMapper;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.service.IVerifyCodeService;
import com.hxf.p2p.base.util.BitStatesUtils;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements IUserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private IVerifyCodeService verifyCodeService;

    @Override
    public void update(Userinfo userinfo) {
        int i = userinfoMapper.updateByPrimaryKey(userinfo);
        if (i == 0) {
            throw new RuntimeException("乐观锁失败,Logininfo:" + userinfo.getId());
        }
    }

    @Override
    public void insert(Userinfo userinfo) {
        userinfoMapper.insert(userinfo);
    }

    @Override
    public Userinfo get(Long id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void bindPhone(String phoneNumber, String verifyCode) {
        Userinfo current = this.get(UserContext.getCurrent().getId());
        if (!current.getIsBindPhone()) {
            boolean ret = verifyCodeService.verify(phoneNumber, verifyCode);
            if (ret) {
                current.setBitState(BitStatesUtils.addState(current.getBitState(), BitStatesUtils.OP_BIND_PHONE));
                this.update(current);
            }else {
                throw new RuntimeException("绑定手机失败");
            }
        }
    }

}
