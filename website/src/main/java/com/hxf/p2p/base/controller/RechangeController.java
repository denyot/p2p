package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.domain.RechargeOffline;
import com.hxf.p2p.base.query.RechargeOfflineQueryObject;
import com.hxf.p2p.base.service.IPlatformBankInfoService;
import com.hxf.p2p.base.service.IRechargeOfflineService;
import com.hxf.p2p.base.util.JsonResult;
import com.hxf.p2p.base.util.RequireLogin;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RechangeController {
    @Autowired
    private IPlatformBankInfoService platformBankInfoService;
    @Autowired
    private IRechargeOfflineService rechargeOfflineService;

    @RequireLogin
    @RequestMapping("recharge")
    public String rechange(Model model) {
        model.addAttribute("banks", platformBankInfoService.selectAll());
        return "recharge";
    }

    @RequireLogin
    @RequestMapping("recharge_save")
    @ResponseBody
    public JsonResult recharge_save(RechargeOffline rechargeOffline) {
        rechargeOfflineService.save(rechargeOffline);
        return new JsonResult();
    }

    @RequireLogin
    @RequestMapping("recharge_list")
    public String recharge_list(@ModelAttribute("qo") RechargeOfflineQueryObject qo, Model model) {
        qo.setApplierId(UserContext.getCurrent().getId());
        model.addAttribute("pageResult", rechargeOfflineService.rechargeOffline_list(qo));
        return "recharge_list";
    }

}
