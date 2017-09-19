package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.domain.Account;
import com.hxf.p2p.base.domain.Logininfo;
import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.service.IAccountService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.util.BidConst;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BorrowController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserinfoService userinfoService;

    @RequestMapping("borrow")
    public String borrow(Model model) {
        Logininfo current = UserContext.getCurrent();
        if (current == null) {
            return "redirect:borrow.jsp";
        } else {
            Userinfo userinfo = userinfoService.getCurrent();
            Account account = accountService.get(current.getId());
            model.addAttribute("account", account);
            model.addAttribute("userinfo", userinfo);
            model.addAttribute("creditBorrowScore", BidConst.CREDIT_BORROW_SCORE);
            return "borrow";
        }
    }
}
