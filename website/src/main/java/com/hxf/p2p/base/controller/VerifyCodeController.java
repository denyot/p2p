package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.service.IVerifyCodeService;
import com.hxf.p2p.base.util.JsonResult;
import com.hxf.p2p.base.util.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 校验
 */
@Controller
public class VerifyCodeController {
    @Autowired
    private IVerifyCodeService verifyCodeService;

    /**
     * 发送验证码
     *
     * @param email 手机号
     * @return
     */
    @RequireLogin
    @RequestMapping("/sendVerifyCode")
    @ResponseBody
    public JsonResult sendVerifyCode(String email) {
        JsonResult jsonResult = new JsonResult();
        try {
            verifyCodeService.sendVerifyCode(email);
        } catch (Exception e) {
            jsonResult.setSuccess(false);
            jsonResult.setMsg(e.getMessage());
        }
        return jsonResult;
    }

}
