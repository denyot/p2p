package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.domain.Userfile;
import com.hxf.p2p.base.mapper.UserfileMapper;
import com.hxf.p2p.base.service.IUserFileService;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserFileServiceImpl implements IUserFileService {
    @Autowired
    private UserfileMapper userfileMapper;

    @Override
    public void apply(String fileName) {
        Userfile userfile= new Userfile();
        userfile.setApplier(UserContext.getCurrent());
        userfile.setApplyTime(new Date());
        userfile.setImage(fileName);
        userfile.setState(Userfile.STATE_NORMAL);
        userfileMapper.insert(userfile);
    }

    @Override
    public List<Userfile> listUnTypeFiles(Long logininfoId) {
        return userfileMapper.listUnTypeFiles(logininfoId);
    }
}
