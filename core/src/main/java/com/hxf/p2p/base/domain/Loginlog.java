package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Loginlog {
    private Long id;

    private String username;//用户名

    private Date loginTime;//登陆时间

    private String ip;

    private Boolean state;

}