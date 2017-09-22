package com.hxf.p2p.mgrsite.base.controller;

import com.hxf.p2p.base.domain.BidRequest;
import com.hxf.p2p.base.domain.Userinfo;
import com.hxf.p2p.base.query.BidRequestQueryObject;
import com.hxf.p2p.base.service.IBidRequestAuditHistoryService;
import com.hxf.p2p.base.service.IBidRequestService;
import com.hxf.p2p.base.service.IRealAuthService;
import com.hxf.p2p.base.service.IUserinfoService;
import com.hxf.p2p.base.util.BidConst;
import com.hxf.p2p.base.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BidRequestController {
    @Autowired
    private IBidRequestService bidRequestService;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IBidRequestAuditHistoryService bidRequestAuditHistoryService;
    @Autowired
    private IRealAuthService realAuthService;


    @RequestMapping("bidrequest_publishaudit_list")
    public String bidRequest_list(@ModelAttribute("qo") BidRequestQueryObject qo, Model model) {
        qo.setBidRequestState(BidConst.BIDREQUEST_STATE_PUBLISH_PENDING);
        model.addAttribute("pageResult", bidRequestService.bidRequest_list(qo));
        return "bidrequest/publish_audit";
    }

    @RequestMapping("bidrequest_publishaudit")
    @ResponseBody
    public JsonResult bidRequest_publishAudit(Long id, String remark, Byte state) {
        bidRequestService.publishAudit(id, remark, state);
        return new JsonResult();
    }

    /**
     * 借款信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("borrow_info")
    public String borrow_info(Long id, Model model) {
        BidRequest bidRequest = bidRequestService.get(id);
        Userinfo userinfo = userinfoService.get(bidRequest.getCreateUser().getId());
        model.addAttribute("bidRequest", bidRequest);
        model.addAttribute("userInfo", userinfo);
        model.addAttribute("audits", bidRequestAuditHistoryService.listByBidRequestId(id));
        model.addAttribute("realAuth", realAuthService.selectByPrimaryKey(userinfo.getRealAuthId()));
        return "bidrequest/borrow_info";
    }

}
