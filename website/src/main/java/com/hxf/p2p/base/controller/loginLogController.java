package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.query.LoginlogQueryObject;
import com.hxf.p2p.base.service.ILoginLogService;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginLogController {
    @Autowired
    private ILoginLogService loginLogService;

    @RequestMapping("loginlog_list")
    public String loginlog_list(@ModelAttribute("qo") LoginlogQueryObject qo, Model model) {
        qo.setUsername(UserContext.getCurrent().getUsername());
        PageResult pageResult = loginLogService.loginlog_list(qo);
        model.addAttribute("pageResult", pageResult);
        return "loginlog_list";
    }
}
