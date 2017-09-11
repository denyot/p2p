package com.hxf.p2p.base.util;

import com.hxf.p2p.base.domain.Logininfo;

/**
 * 用户上下文
 */
public class UserContext {
    public final static String USERINSESSION = "logininfo";

    public final void putCurrent(Logininfo logininfo) {

    }
    public final Logininfo getCurrent(){

        return null;
    }
}

