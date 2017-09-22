package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.service.IBidRequestService;
import com.hxf.p2p.base.util.JsonResult;
import com.hxf.p2p.base.util.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class BidController {
    @Autowired
    private IBidRequestService bidRequestService;
    @RequireLogin
    @RequestMapping("borrow_bid")
    @ResponseBody
    public JsonResult borrow_bid(Long bidRequestId, BigDecimal amount) {
        bidRequestService.bid(bidRequestId,amount);
        return new JsonResult();
    }
}
