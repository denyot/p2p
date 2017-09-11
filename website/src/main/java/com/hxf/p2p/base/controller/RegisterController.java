package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.service.ILogininfoService;
import com.hxf.p2p.base.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户注册/登陆相关
 */
@Controller
public class RegisterController {
    @Autowired
    private ILogininfoService logininfoService;

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

    @RequestMapping("checkUsername")
    @ResponseBody
    public boolean checkUsername(String username) {
        return !logininfoService.checkUsername(username);
    }
    @RequestMapping("login")
    @ResponseBody
    public JsonResult login(String username, String password) {
        JsonResult json = new JsonResult();
        try {
            logininfoService.login(username, password);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return json;
    }

}
