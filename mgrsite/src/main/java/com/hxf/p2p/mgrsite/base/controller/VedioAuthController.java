package com.hxf.p2p.mgrsite.base.controller;

import com.hxf.p2p.base.PageResult.PageResult;
import com.hxf.p2p.base.query.VedioAuthQueryObject;
import com.hxf.p2p.base.service.IVedioAuthService;
import com.hxf.p2p.base.util.JsonResult;
import com.hxf.p2p.base.util.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VedioAuthController {
    @Autowired
    private IVedioAuthService vedioAuthService;

    @RequireLogin
    @RequestMapping("vedioAuth")
    public String vedioAuth(@ModelAttribute("qo") VedioAuthQueryObject qo, Model model) {
        PageResult pageResult = vedioAuthService.vedioAuth_list(qo);
        model.addAttribute("pageResult", pageResult);
        return "vedioAuth/list";
    }

    /**
     * 完成视频审核
     * @param loginInfoValue
     * @param remark
     * @param state
     * @return
     */
    @RequireLogin
    @RequestMapping("vedioAuth_audit")
    @ResponseBody
    public JsonResult vedioAuth_audit(Long loginInfoValue, String remark, Byte state) {
        vedioAuthService.audit(loginInfoValue, remark, state);
        return new JsonResult();
    }
}
