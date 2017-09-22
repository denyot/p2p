package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BidRequestAuditHistory extends BaseAuth {
    public final static byte publish_audit = 0;//发标前审核
    public final static byte full_audit_1 = 1;//满标一审
    public final static byte full_audit_2 = 2;//满标二审
    private Long bidRequestId;
    private Byte auditType;

    public String getAuditTypeDisplay() {
        switch (this.auditType) {
            case publish_audit:
                return "发标前审核";
            case full_audit_1:
                return "满标一审";
            case full_audit_2:
                return "满标二审";
            default:
                return "";
        }
    }
}