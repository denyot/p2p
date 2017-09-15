package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.domain.Logininfo;
import com.hxf.p2p.base.service.IAccountService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.util.JsonResult;
import com.hxf.p2p.base.util.RequireLogin;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonalController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserinfoService userinfoService;

    @RequireLogin
    @RequestMapping("personal")
    public String PersonalCenter(Model model) {
        Logininfo current = UserContext.getCurrent();
        model.addAttribute("userinfo", userinfoService.get(current.getId()));
        model.addAttribute("account", accountService.get(current.getId()));
        return "personal";
    }

    @RequireLogin
    @RequestMapping("bindPhone")
    @ResponseBody
    public JsonResult bindPhone(String phoneNumber, String verifyCode) {
        JsonResult jsonResult = new JsonResult();
        try {
            userinfoService.bindPhone(phoneNumber, verifyCode);
        } catch (Exception e) {
            jsonResult.setSuccess(false);
            jsonResult.setMsg(e.getMessage());
        }
        return jsonResult;
    }
}
