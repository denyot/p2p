package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.MailVerify;
import java.util.List;

public interface MailVerifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MailVerify record);

    MailVerify selectByUUID(String key);

    List<MailVerify> selectAll();

}