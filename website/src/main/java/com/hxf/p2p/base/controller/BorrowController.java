package com.hxf.p2p.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BorrowController {
    @RequestMapping("borrow")
    public String borrow(Model model) {
        return "borrow";
    }
}
