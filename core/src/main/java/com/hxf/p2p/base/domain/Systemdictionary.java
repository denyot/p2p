package com.hxf.p2p.base.domain;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Systemdictionary {
    private Long id;

    private String sn;

    private String title;

    private String intro;

    public String getJsonString() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("sn", this.sn);
        map.put("title", this.title);
        return JSONObject.toJSONString(map);
    }
}