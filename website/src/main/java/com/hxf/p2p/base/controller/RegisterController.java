package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.domain.Logininfo;
import com.hxf.p2p.base.service.ILogininfoService;
import com.hxf.p2p.base.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户注册/登陆相关
 */
@Controller
public class RegisterController {
    @Autowired
    private ILogininfoService logininfoService;

    /**
     * 注册账号
     * @param username 账号
     * @param password 密码
     * @return  反馈信息
     */
    @RequestMapping("register")
    @ResponseBody
    public JsonResult register(String username, String password) {
        JsonResult json = new JsonResult();
        try {
            logininfoService.register(username, password);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 检查用户名
     * @param username 用户名
     * @return
     */
    @RequestMapping("checkUsername")
    @ResponseBody
    public boolean checkUsername(String username) {
        return !logininfoService.checkUsername(username);
    }

    /**
     * 登陆
     * @param username
     * @param password
     * @param servletRequest
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public JsonResult login(String username, String password, HttpServletRequest servletRequest) {
        JsonResult json = new JsonResult();
        Logininfo current = logininfoService.login(username, password, servletRequest.getRemoteAddr(),true);
        if (current == null) {
            json.setSuccess(false);
            json.setMsg("用户名或密码错误");
        }
        return json;
    }

}
