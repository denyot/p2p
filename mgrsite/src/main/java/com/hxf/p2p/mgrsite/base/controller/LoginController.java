package com.hxf.p2p.mgrsite.base.controller;

import com.hxf.p2p.base.domain.Logininfo;
import com.hxf.p2p.base.service.ILogininfoService;
import com.hxf.p2p.base.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台登陆
 */
@Controller
public class LoginController {
    @Autowired
    private ILogininfoService logininfoService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(String username, String password, HttpServletRequest servletRequest) {
        JsonResult json = new JsonResult();
        Logininfo current = logininfoService.login(username, password, servletRequest.getRemoteAddr(), false);
        if (current == null) {
            json.setSuccess(false);
            json.setMsg("用户名或密码错误");
        }
        return json;
    }

    @RequestMapping("/index")
    public String index(){
        return "main";
    }

}
