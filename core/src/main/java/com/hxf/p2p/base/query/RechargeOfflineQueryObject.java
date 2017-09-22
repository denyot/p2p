package com.hxf.p2p.base.query;

import com.hxf.p2p.base.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.util.Date;

@Getter
@Setter
public class RechargeOfflineQueryObject extends AuthQueryObject {
    private Long applierId;//充值申请人id
    private Long bankInfoId;//银行id
    private String tradeCode;//交易号

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tradeBeginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tradeEndTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getEndTime() {
        return tradeEndTime == null ? null : DateUtil.getEndDate(tradeEndTime);
    }

    public String getTradeCode() {
        return StringUtils.hasLength(tradeCode) ? tradeCode : null;
    }
}
