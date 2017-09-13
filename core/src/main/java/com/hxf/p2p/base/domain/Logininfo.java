package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户登陆信息
 */
@Getter
@Setter
public class Logininfo{
    private Long id;//主键
    public static final int STATE_NORMAL = 0;//正常
    public static final int STATE_LOCK = 1;//锁定
    private String username;//用户名
    private String password;//密码
    private int state;//状态
    private boolean userType;//用户类型,默认表示后台管理系统用户
}
