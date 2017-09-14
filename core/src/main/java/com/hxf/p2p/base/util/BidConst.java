package com.hxf.p2p.base.util;

import java.math.BigDecimal;

/**
 * 投标常量
 */
public class BidConst {
    /**
     * 定义存储精度
     */
    public static final int STORE_SCALE = 4;
    /**
     * 定义运算精度
     */
    public static final int CAL_SCALE = 8;
    /**
     * 定义显示精度
     */
    public static final int DISPLAY_SCALE = 2;
    /**
     * 定义系统级别的0
     */
    public static final BigDecimal ZERO = new BigDecimal("0.0000");
    /**
     * 初始授信额度
     */
    public static final BigDecimal INIT_BORROW_LIMIT = new BigDecimal("5000.0000");

    /**
     * 系统初始化管理员账号
     */
    public static final String INIT_ADMIN_NAME = "huxinfeng";
    /**
     * 系统初始化管理员密码
     */
    public static final String INIT_ADMIN_PASSWORD = "1111";
    /**
     * 手机验证码有效时间(单位/s)
     */
    public static final int VERIFYCODE_VALIDATE_SECONDS = 300;

}
