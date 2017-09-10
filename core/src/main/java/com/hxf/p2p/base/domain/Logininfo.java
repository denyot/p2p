package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户登陆信息
 */
@Getter
@Setter
public class Logininfo extends BaseDomain {
    public static final int STATE_NORMAL = 0;//正常
    public static final int STATE_LOCK = 1;//锁定

    private String username;
    private String password;
    private int state;
}
