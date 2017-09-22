package com.hxf.p2p.base.domain;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class PlatformBankInfo {
    private Long id;

    private String bankName;

    private String accountName;

    private String bankNumber;

    private String bankForkName;
    public String getJsonString() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("bankName", this.bankName);
        map.put("accountName", this.accountName);
        map.put("bankNumber", this.bankNumber);
        map.put("bankForkName", this.bankForkName);
        return JSONObject.toJSONString(map);
    }

}