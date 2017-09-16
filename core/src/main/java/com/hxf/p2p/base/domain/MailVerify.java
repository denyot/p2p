package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
/**
 * 邮箱校验
 */
public class MailVerify {
    private Long id;

    private Long userinfoId;

    private Date deadline;

    private String uuid;

    private String email;

    public MailVerify(Long userinfoId, Date deadline, String uuid, String email) {
        this.userinfoId = userinfoId;
        this.deadline = deadline;
        this.uuid = uuid;
        this.email = email;
    }

    public MailVerify() {
    }
}