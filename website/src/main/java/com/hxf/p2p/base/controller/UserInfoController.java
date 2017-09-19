package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.service.ISyetemDictionaryService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.util.JsonResult;
import com.hxf.p2p.base.util.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserInfoController {
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private ISyetemDictionaryService syetemDictionaryService;

    @RequireLogin
    @RequestMapping("basicInfo")
    public String basicInfo(Model model) {
        Userinfo userinfo = userinfoService.getCurrent();
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("educationBackground", syetemDictionaryService.selectItemBySn("educationBackground"));
        model.addAttribute("incomeGrade", syetemDictionaryService.selectItemBySn("incomeGrade"));
        model.addAttribute("marriage", syetemDictionaryService.selectItemBySn("marriage"));
        model.addAttribute("kidCount", syetemDictionaryService.selectItemBySn("kidCount"));
        model.addAttribute("houseCondition", syetemDictionaryService.selectItemBySn("houseCondition"));
        return "userInfo";
    }

    @RequireLogin
    @RequestMapping("basicInfo_save")
    @ResponseBody
    public JsonResult basicInfo_save(Userinfo userinfo) {
        userinfoService.updateBasicInfo(userinfo);
        return new JsonResult();
    }
}
