package com.hxf.p2p.mgrsite.base.controller;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.query.RechargeOfflineQueryObject;
import com.hxf.p2p.base.service.IPlatformBankInfoService;
import com.hxf.p2p.base.service.IRechargeOfflineService;
import com.hxf.p2p.base.util.JsonResult;
import com.hxf.p2p.base.util.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RechargeOfflineController {
    @Autowired
    private IRechargeOfflineService rechargeOfflineService;
    @Autowired
    private IPlatformBankInfoService platformBankInfoService;

    @RequestMapping("/rechargeOffline_list")
    public String rechargeOffline_list(@ModelAttribute("qo") RechargeOfflineQueryObject qo, Model model) {
        PageResult pageResult = rechargeOfflineService.rechargeOffline_list(qo);
        model.addAttribute("pageResult", pageResult);
        model.addAttribute("banks", platformBankInfoService.selectAll());
        return "rechargeOffline/list";
    }

    @RequestMapping("rechargeOffline_audit")
    @ResponseBody
    public JsonResult rechargeOffline_audit(Long id, String remark, byte state) {
        rechargeOfflineService.audit(id, remark, state);
        return new JsonResult();
    }


}
