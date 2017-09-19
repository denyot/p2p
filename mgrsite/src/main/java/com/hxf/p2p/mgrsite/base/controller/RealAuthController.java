package com.hxf.p2p.mgrsite.base.controller;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.query.RealAuthQueryObject;
import com.hxf.p2p.base.service.IRealAuthService;
import com.hxf.p2p.base.util.JsonResult;
import com.hxf.p2p.base.util.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RealAuthController {
    @Autowired
    private IRealAuthService realAuthService;
    @RequireLogin
    @RequestMapping("realAuth")
    public String realAuth(@ModelAttribute("qo") RealAuthQueryObject qo, Model model) {
        PageResult pageResult = realAuthService.realAuth_list(qo);
        model.addAttribute("pageResult", pageResult);
        return "realAuth/list";
    }
    @RequireLogin
    @RequestMapping("realAuth_audit")
    @ResponseBody
    public JsonResult realAuth_audit(Long id, String remark, Byte state) {
        realAuthService.audit(id, remark, state);
        return new JsonResult();
    }


}
