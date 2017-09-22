package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 投标对象
 */
@Getter
@Setter
public class Bid {
    private Long id;
    private BigDecimal actualRate;//实际年利率
    private BigDecimal availableAmount;//投标有效金额
    private Date bidTime;//投标时间
    private String bidRequestTitle;//标的名称(冗余数据)
    private Long bidRequestId;//对应的借款标
    private int BidRequestState;//标的状态(和借款对象同步)
    private Logininfo bidUser;//投标人
}