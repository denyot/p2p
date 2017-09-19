package com.hxf.p2p.base.domain;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 实名认证对象
 */
@Getter
@Setter
public class RealAuth {
    public static final Byte SEX_MALE = 0;//性别-男
    public static final Byte SEX_FEMALE = 1;//性别-女
    public static final Byte STATE_NORMAL = 0;//正常
    public static final Byte STATE_AUDIT = 1;//审核通过
    public static final Byte STATE_REJECT = 2;//拒绝
    private Long id;

    private String realname;//真实姓名

    private Byte sex;//性别

    private String birthDate;//出生日期

    private String idNumber;//身份证号码

    private String address;//证件地址

    private Byte state;//状态

    private String image1;//身份证正面图片地址

    private String image2;//身份证反而图片地址

    private String remark;//审核备注

    private Date auditTime;//审核时间

    private Date applyTime;//申请时间

    private Logininfo auditor;//审核人

    private Logininfo applier;//申请人

    public String getSexDisplay() {
        return sex == SEX_MALE ? "男" : "女";
    }

    public String getStateDisplay() {
        if (state == STATE_NORMAL) {
            return "申请中";
        } else if (state == STATE_AUDIT) {
            return "审核通过";
        } else if (state == STATE_REJECT) {
            return "审核拒绝";
        }
        return state + "";
    }

    public String getJsonString() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("realname", this.realname);
        map.put("applier",applier.getUsername());
        map.put("sex", getSexDisplay());
        map.put("birthDate", this.birthDate);
        map.put("idNumber", this.idNumber);
        map.put("image1", this.image1);
        map.put("image2", this.image2);
        map.put("remark", this.remark);
        map.put("address", this.address);
        map.put("auditTime", this.auditTime);
        map.put("applyTime", this.applyTime);
        return JSONObject.toJSONString(map);
    }
}