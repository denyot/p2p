package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
public class Systemaccountflow {
    private Long id;

    private Date createdDate;//流水创建时间

    private Byte accountActionType;//系统账户流水类型

    private BigDecimal amount;//金额

    private String note;//说明

    private BigDecimal balance;//余额

    private BigDecimal freezedAmount;//冻结金额

    private Long targetUser_id;

}