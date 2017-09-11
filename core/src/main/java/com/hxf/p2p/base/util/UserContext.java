package com.hxf.p2p.base.util;

import com.hxf.p2p.base.domain.Logininfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * 用户上下文
 */
public class UserContext {
    public final static String USERINSESSION = "logininfo";

    /**
     * 把当前用户存储到session中
     * @param current
     */
    public final static void putCurrent(Logininfo current) {
        getSession().setAttribute(USERINSESSION, current);
    }

    /**
     * 从session中获取用户
     * @return
     */
    public final static Logininfo getCurrent() {
        return (Logininfo) getSession().getAttribute(USERINSESSION);
    }

    /**
     * 获取httpSession
     * @return
     */
    private static HttpSession getSession() {
        HttpSession httpSession = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        return httpSession;
    }
}

