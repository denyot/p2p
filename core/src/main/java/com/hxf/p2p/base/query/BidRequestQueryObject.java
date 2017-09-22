package com.hxf.p2p.base.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BidRequestQueryObject extends QueryObject {
    private byte bidRequestState = -1;//借款状态
    private byte[] bidRequestStates;//多个借款状态
    private String orderBy;//依据什么排序
    private String orderType;//排序规则
}
