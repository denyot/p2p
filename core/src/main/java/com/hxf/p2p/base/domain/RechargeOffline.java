package com.hxf.p2p.base.domain;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 线下充值
 */
@Getter
@Setter
public class RechargeOffline extends BaseAuth{
    private String tradeCode;//交易号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tradeTime;//充值时间

    private BigDecimal amount;//充值金额

    private String note;//充值说明

    private PlatformBankInfo bankInfo;//平台银行账户
    public String getJsonString() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("username", this.applier.getUsername());
        map.put("tradeCode", this.tradeCode);
        map.put("amount", this.amount);
        map.put("tradeTime", this.tradeTime);
        return JSONObject.toJSONString(map);
    }
}