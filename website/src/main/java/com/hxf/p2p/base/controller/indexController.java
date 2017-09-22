package com.hxf.p2p.base.controller;

import com.hxf.p2p.base.query.BidRequestQueryObject;
import com.hxf.p2p.base.service.IBidRequestService;
import com.hxf.p2p.base.util.BidConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @Autowired
    private IBidRequestService bidRequestService;

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("bidRequests", bidRequestService.listIndex(5));
        return "main";
    }

    /**
     * 投资列表边框
     *
     * @return
     */
    @RequestMapping("invest")
    public String invest() {
        return "invest";
    }

    /**
     * 投资列表明细
     *
     * @return
     */
    @RequestMapping("invest_list")
    public String invest_list(BidRequestQueryObject qo, Model model) {
        if (qo.getBidRequestState() == -1) {
            qo.setBidRequestStates(new byte[]{BidConst.BIDREQUEST_STATE_BIDDING, BidConst.BIDREQUEST_STATE_PAYING_BACK, BidConst.BIDREQUEST_STATE_COMPLETE_PAY_BACK});
        }
        model.addAttribute("pageResult", bidRequestService.bidRequest_list(qo));
        return "invest_list";
    }

}
