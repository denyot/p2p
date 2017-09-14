package com.hxf.p2p.base.util;

import com.hxf.p2p.base.domain.Logininfo;
import com.hxf.p2p.base.vo.VerifyCodeVo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * 用户上下文
 */
public class UserContext {
    public final static String USER_IN_SESSION = "logininfo";
    public final static String VERIFYCODE_IN_SESSION = "verifyCode";

    /**
     * 把当前用户存储到session中
     *
     * @param current
     */
    public final static void putCurrent(Logininfo current) {
        getSession().setAttribute(USER_IN_SESSION, current);
    }

    /**
     * 把验证码信息存放到session中
     *
     * @param verifyCodeVo
     */
    public final static void putCurrentVerifyCode(VerifyCodeVo verifyCodeVo) {
        getSession().setAttribute(VERIFYCODE_IN_SESSION, verifyCodeVo);
    }

    /**
     * 从session中获取用户
     *
     * @return
     */
    public final static Logininfo getCurrent() {
        return (Logininfo) getSession().getAttribute(USER_IN_SESSION);
    }

    /**
     * 从session中获取验证码信息
     * @return
     */
    public final static VerifyCodeVo getCurrentVerifyCode() {
        return (VerifyCodeVo) getSession().getAttribute(VERIFYCODE_IN_SESSION);
    }


    /**
     * 获取httpSession
     *
     * @return
     */
    private static HttpSession getSession() {
        HttpSession httpSession = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        return httpSession;
    }
}

