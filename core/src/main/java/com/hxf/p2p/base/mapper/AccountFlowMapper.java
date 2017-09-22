package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.AccountFlow;
import java.util.List;

public interface AccountFlowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountFlow record);

    AccountFlow selectByPrimaryKey(Long id);

    List<AccountFlow> selectAll();

    int updateByPrimaryKey(AccountFlow record);
}