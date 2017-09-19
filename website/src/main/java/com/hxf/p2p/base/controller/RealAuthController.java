package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.domain.RealAuth;
import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.service.IRealAuthService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.util.JsonResult;
import com.hxf.p2p.base.util.RequireLogin;
import com.hxf.p2p.base.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

@Controller
public class RealAuthController {
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IRealAuthService realAuthService;
    @Autowired
    private ServletContext servletContext;

    @RequireLogin
    @RequestMapping("realAuth")
    public String realAuth(Model model) {
        Userinfo current = userinfoService.getCurrent();
        //判断用户是否实名,是否提交申请实名
        if (!current.getIsRealAuth()) {
            if (current.getRealAuthId() == null) {
                return "realAuth";
            } else {
                model.addAttribute("auditing", true);
                return "realAuth_result";
            }
        }
        model.addAttribute("auditing", false);
        model.addAttribute("userinfo", current);
        model.addAttribute("realAuth", realAuthService.selectByPrimaryKey(current.getRealAuthId()));
        return "realAuth_result";
    }

    @RequestMapping("realAuthUpload")
    @ResponseBody
    public String realAuthUpload(MultipartFile file) {
        String path = servletContext.getRealPath("/upload");
        String fileName = UploadUtil.upload(file, path);
        return "/upload" + fileName;
    }

    @RequireLogin
    @RequestMapping("realAuth_save")
    @ResponseBody
    public JsonResult realAuthSave(RealAuth realAuth) {
        realAuthService.apply(realAuth);
        return new JsonResult();
    }
}
