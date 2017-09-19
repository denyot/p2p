package com.hxf.p2p.mgrsite.base.controller;

import com.hxf.p2p.base.domain.Systemdictionary;
import com.hxf.p2p.base.domain.Systemdictionaryitem;
import com.hxf.p2p.base.query.SystemDictionaryQueryObject;
import com.hxf.p2p.base.service.ISyetemDictionaryService;
import com.hxf.p2p.base.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SystemDictionaryController {
    @Autowired
    private ISyetemDictionaryService syetemDictionaryService;

    @RequestMapping("systemDictionary_list")
    public String systemDictionary_list(@ModelAttribute("qo") SystemDictionaryQueryObject qo, Model model) {
        model.addAttribute("pageResult", syetemDictionaryService.systemDictionary_list(qo));
        return "systemdic/systemDictionary_list";
    }

    @RequestMapping("systemDictionary_saveOrUpdate")
    @ResponseBody
    public JsonResult systemDictionary_saveOrUpdate(Systemdictionary systemdictionary) {
        syetemDictionaryService.systemDictionary_saveOrUpdate(systemdictionary);
        return new JsonResult();
    }

    @RequestMapping("systemDictionaryItem_list")
    public String systemDictionaryItem_list(@ModelAttribute("qo") SystemDictionaryQueryObject qo, Model model) {
        model.addAttribute("pageResult", syetemDictionaryService.systemDictionaryItem_list(qo));
        List<Systemdictionary> systemdictionarys = syetemDictionaryService.selectAll();
        model.addAttribute("systemDictionaryGroups", systemdictionarys);
        return "systemdic/systemDictionaryItem_list";
    }

    @RequestMapping("systemDictionaryItem_saveOrUpdate")
    @ResponseBody
    public JsonResult systemDictionaryItem_saveOrUpdate(Systemdictionaryitem systemdictionaryitem) {
        syetemDictionaryService.systemDictionaryItem_saveOrUpdate(systemdictionaryitem);
        return new JsonResult();
    }
}

