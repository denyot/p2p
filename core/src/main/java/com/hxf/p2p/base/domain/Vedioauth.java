package com.hxf.p2p.base.domain;

import java.util.Date;

public class Vedioauth {
    private Long id;

    private Byte state;

    private String remark;

    private Date auditTime;

    private Date applyTime;

    private Long auditor_id;

    private Long applier_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Long getAuditor_id() {
        return auditor_id;
    }

    public void setAuditor_id(Long auditor_id) {
        this.auditor_id = auditor_id;
    }

    public Long getApplier_id() {
        return applier_id;
    }

    public void setApplier_id(Long applier_id) {
        this.applier_id = applier_id;
    }
}