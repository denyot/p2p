package com.hxf.p2p.mgrsite.base.controller;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.domain.PlatformBankInfo;
import com.hxf.p2p.base.query.QueryObject;
import com.hxf.p2p.base.service.IPlatformBankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlatformBankInfoController {
    @Autowired
    private IPlatformBankInfoService platformBankInfoService;

    @RequestMapping("/platformBankInfo_list")
    public String platformBankInfo_list(@ModelAttribute("qo") QueryObject qo, Model model) {
        PageResult pageResult = platformBankInfoService.platformBankInfo_list(qo);
        model.addAttribute("pageResult", pageResult);
        return "platformbank/list";
    }

    @RequestMapping("platformBankInfo_update")
    public String platformBankInfo_saveOrUpdate(PlatformBankInfo platformBankInfo) {
        platformBankInfoService.saveOrUpdate(platformBankInfo);
        return "redirect:platformBankInfo_list";
    }
}
