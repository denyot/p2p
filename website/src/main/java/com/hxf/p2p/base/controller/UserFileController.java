package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.domain.Userfile;
import com.hxf.p2p.base.service.IUserFileService;
import com.hxf.p2p.base.util.UploadUtil;
import com.hxf.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 风控资料
 */
@Controller
public class UserFileController {
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private IUserFileService userFileService;

    @RequestMapping("userFile")
    public String userFile(Model model, HttpServletRequest request) {
        model.addAttribute("sessionid", request.getSession().getId());
        List<Userfile> userfiles = userFileService.listUnTypeFiles(UserContext.getCurrent().getId());
        model.addAttribute("userFiles", userfiles);
        return "userFiles";
    }

    @RequestMapping("userFileUpload")
    @ResponseBody
    public void userFileUpload(MultipartFile file) {
        String path = servletContext.getRealPath("/upload");
        String fileName = UploadUtil.upload(file, path);
        fileName = "/upload" + fileName;
        userFileService.apply(fileName);
    }
}
