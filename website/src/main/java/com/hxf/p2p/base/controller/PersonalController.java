package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.domain.Logininfo;
import com.hxf.p2p.base.service.IAccountService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserinfoService userinfoService;

    @RequestMapping("personal")
    public String PersonalCenter(Model model) {
        Logininfo current = UserContext.getCurrent();
        model.addAttribute("userinfo", userinfoService.get(current.getId()));
        model.addAttribute("account", accountService.get(current.getId()));
        return "personal";
    }
}
