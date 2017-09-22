package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 基础认证对象
 */
@Getter
@Setter
public class BaseAuth {
    public static final Byte STATE_NORMAL = 0;//正常
    public static final Byte STATE_AUDIT = 1;//审核通过
    public static final Byte STATE_REJECT = 2;//拒绝
    protected Long id;
    protected Byte state;//状态

    protected String remark;//审核备注

    protected Date auditTime;//审核时间

    protected Date applyTime;//申请时间

    protected Logininfo auditor;//审核人

    protected Logininfo applier;//申请人

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
}
