package com.hxf.p2p.base.interceptor;

import com.hxf.p2p.base.util.RequireLogin;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            RequireLogin methodAnnotation = method.getMethodAnnotation(RequireLogin.class);
            if (methodAnnotation != null && UserContext.getCurrent() == null) {
                response.sendRedirect("/login.jsp");
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }
}
