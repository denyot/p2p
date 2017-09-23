package com.hxf.p2p.base.domain;

import com.hxf.p2p.base.util.BidConst;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SystemAccount {
    private Long id;

    private Integer version;//版本号

    private Date beginDate;//该系统账户区间开始时间

    private Date endDate;//该系统账户区间结束时间

    private Date createDate;//创建时间

    private BigDecimal totalBalance = BidConst.ZERO;

    private BigDecimal freezedAmount = BidConst.ZERO;

}