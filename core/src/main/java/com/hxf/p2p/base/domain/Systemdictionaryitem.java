package com.hxf.p2p.base.domain;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Systemdictionaryitem {
    private Long id;

    private Long parentId;//分类目录id

    private String title;//数据字典明细显示名称

    private String tvalue;

    private Byte sequence;//数据字典明细在该分类中的排序

    private String intro;//数据字典使用说明

    public String getJsonString() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("parentId", this.parentId);
        map.put("title", this.title);
        map.put("tvalue", this.tvalue);
        map.put("sequence", this.sequence);
        map.put("intro", this.intro);
        return JSONObject.toJSONString(map);
    }
}