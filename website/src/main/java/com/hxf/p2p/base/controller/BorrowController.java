package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.domain.Account;
import com.hxf.p2p.base.domain.BidRequest;
import com.hxf.p2p.base.domain.Logininfo;
import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.service.IAccountService;
import com.hxf.p2p.base.service.IBidRequestService;
import com.hxf.p2p.base.service.IRealAuthService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.util.BidConst;
import com.hxf.p2p.base.util.RequireLogin;
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
    private IBidRequestService bidRequestService;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IRealAuthService realAuthService;

    /**
     * 导向到我要借款首页
     *
     * @param model
     * @return
     */
    @RequireLogin
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

    /**
     * 导向到借款申请页面
     *
     * @return
     */
    @RequestMapping("borrowInfo")
    public String borrowInfo(Model model) {
        Long id = UserContext.getCurrent().getId();
        boolean canApplyBidRequeset = bidRequestService.canApplyBidRequeset(id);
        if (canApplyBidRequeset) {
            model.addAttribute("minBidRequestAmount", BidConst.SMALLEST_BIDREQUEST_AMOUNT);
            model.addAttribute("account", accountService.get(id));
            model.addAttribute("minBidAmount", BidConst.SMALLEST_BID_AMOUNT);
            return "borrow_apply";
        }
        return "borrow_apply_result";
    }

    /**
     * 借款申请
     *
     * @param bidRequest
     * @return
     */
    @RequestMapping("borrow_apply")
    public String borrow_apply(BidRequest bidRequest) {
        bidRequestService.apply(bidRequest);
        return "redirect:/borrowInfo";
    }

    @RequestMapping("borrow_info")
    public String borrow_info(Long id, Model model) {
        BidRequest bidRequest = bidRequestService.get(id);
        Userinfo applier = userinfoService.get(bidRequest.getCreateUser().getId());
        model.addAttribute("bidRequest", bidRequest);
        model.addAttribute("userInfo", applier);
        model.addAttribute("realAuth", realAuthService.selectByPrimaryKey(applier.getRealAuthId()));
        if (UserContext.getCurrent() != null) {
            if (UserContext.getCurrent().getId() == applier.getId()) {
                model.addAttribute("self", true);
            } else {
                model.addAttribute("account", accountService.get(UserContext.getCurrent().getId()));
                model.addAttribute("self", false);
            }
        }
        return "borrow_info";
    }
}
