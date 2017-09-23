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

    /**
     * 发标前审核列表
     *
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("bidrequest_publishaudit_list")
    public String bidRequest_list(@ModelAttribute("qo") BidRequestQueryObject qo, Model model) {
        qo.setBidRequestState(BidConst.BIDREQUEST_STATE_PUBLISH_PENDING);
        model.addAttribute("pageResult", bidRequestService.bidRequest_list(qo));
        return "bidrequest/publish_audit";
    }

    /**
     * 发标前审核
     *
     * @param id
     * @param remark
     * @param state
     * @return
     */
    @RequestMapping("bidrequest_publishaudit")
    @ResponseBody
    public JsonResult bidRequest_publishAudit(Long id, String remark, Byte state) {
        bidRequestService.publishAudit(id, remark, state);
        return new JsonResult();
    }

    /**
     * 借款信息
     *
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

    /**
     * 满标一审列表
     *
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("bidrequest_audit1_list")
    public String bidrequest_audit1_list(@ModelAttribute("qo") BidRequestQueryObject qo, Model model) {
        qo.setBidRequestState(BidConst.BIDREQUEST_STATE_APPROVE_PENDING_1);
        model.addAttribute("pageResult", bidRequestService.bidRequest_list(qo));
        return "bidrequest/audit1";
    }

    /**
     * 满标一审
     */
    @RequestMapping("bidrequest_audit1")
    @ResponseBody
    public JsonResult bidrequest_audit1(Long id, String remark, Byte state) {
        bidRequestService.bidRequestFullAudit1(id, remark, state);
        return new JsonResult();
    }

    /**
     * 满标二审列表
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("bidrequest_audit2_list")
    public String bidrequest_audit2_list(@ModelAttribute("qo") BidRequestQueryObject qo, Model model) {
        qo.setBidRequestState(BidConst.BIDREQUEST_STATE_APPROVE_PENDING_2);
        model.addAttribute("pageResult", bidRequestService.bidRequest_list(qo));
        return "bidrequest/audit2";
    }
    /**
     * 满标二审
     */
    @RequestMapping("bidrequest_audit2")
    @ResponseBody
    public JsonResult bidrequest_audit2(Long id, String remark, Byte state) {
        bidRequestService.bidRequestFullAudit2(id, remark, state);
        return new JsonResult();
    }
}
