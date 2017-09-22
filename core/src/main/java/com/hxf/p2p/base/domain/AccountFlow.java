package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
public class AccountFlow {
    private Long id;

    private Byte accountActionType;//资金变化类型

    private BigDecimal amount;//变化金额

    private String note;//说明

    private BigDecimal balance;//余额

    private BigDecimal freezed;//冻结金额

    private Date actionTime;//流水时间

    private Long accountId;//流水对应的账户id


}