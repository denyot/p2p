package com.hxf.p2p.base.domain;

import com.hxf.p2p.base.util.BidConst;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 账户信息
 */
@Getter
@Setter
public class Account {
    private Long id;

    private Integer version;//版本信息
    private String tradePassword;//交易密码

    private BigDecimal usableAmount = BidConst.ZERO;//可用余额

    private BigDecimal freezedAmount = BidConst.ZERO;//冻结金额

    private BigDecimal unReceivePrincipal = BidConst.ZERO;//待收本金

    private BigDecimal unReceiveInterest = BidConst.ZERO;//待收利息


    private BigDecimal unReturnAmount = BidConst.ZERO;//待还本息

    private BigDecimal remainBorrowLimit = BidConst.INIT_BORROW_LIMIT;//账户剩余授信额度

    private BigDecimal borrowLimitAmount = BidConst.INIT_BORROW_LIMIT;//账户授信额度

    /**
     * 可用余额增加
     *
     * @param amount
     */
    public void addUsableAmount(BigDecimal amount) {
        this.setUsableAmount(this.usableAmount.add(amount));
    }

    /**
     * 待还本息增加
     * @param amount
     */
    public void addUnReturnAmount(BigDecimal amount) {
        this.setUnReturnAmount(this.unReturnAmount.add(amount));
    }

    /**
     * 总金额
     *
     * @return
     */
    public BigDecimal getTotalAmount() {
        return usableAmount.add(freezedAmount).add(unReceivePrincipal);
    }
}