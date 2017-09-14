package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.service.IVerifyCodeService;
import com.hxf.p2p.base.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 验证码
 */
@Controller
public class VerifyCodeController {
    @Autowired
    private IVerifyCodeService verifyCodeService;

    @RequestMapping("/sendVerifyCode")
    @ResponseBody
    public JsonResult sendVerifyCode(String phoneNumber) {
        JsonResult jsonResult = new JsonResult();
        try {
            verifyCodeService.sendVerifyCode(phoneNumber);
        } catch (Exception e) {
            jsonResult.setSuccess(false);
            jsonResult.setMsg(e.getMessage());
        }
        return jsonResult;
    }
}
