package com.hxf.p2p.base.domain;

import com.alibaba.fastjson.JSONObject;
import com.hxf.p2p.base.util.BidConst;
import com.hxf.p2p.base.util.DecimalFormatUtil;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static com.hxf.p2p.base.util.BidConst.*;

/**
 * 借款对象
 */
@Getter
@Setter
public class BidRequest {
    private Long id;

    private Integer version;//对象版本信息（用作乐观锁）

    private Integer returnType;//还款方式

    private Byte bidRequestType;//借款类型

    private Byte bidRequestState;//借款状态

    private BigDecimal bidRequestAmount;//借款金额

    private BigDecimal currentRate;//借款利率

    private Byte monthes2Return;//借款期限

    private Integer bidCount = 0;//本借款已有投标数量

    private BigDecimal totalRewardAmount;//总利息

    private BigDecimal currentSum = BidConst.ZERO;//当前投标金额之和

    private String title;//借款标题

    private String description;//借款描述

    private String note;//风控评审意见

    private Date disableDate;//招标到期时间

    private Byte disableDays;//招标天数

    private BigDecimal minBidAmount;//最小投标金额

    private Date applyTime;//申请时间

    private Date publishTime;//发布时间

    private Logininfo createUser;//借款人
    private List<Bid> bidList = new ArrayList<>();//针对借款对应的投标

    /**
     * 计算投标进度
     */
    public BigDecimal getPersent() {
        return currentSum.divide(bidRequestAmount, BidConst.DISPLAY_SCALE, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
    }

    /**
     * 计算还需金额
     *
     * @return
     */
    public BigDecimal getRemainAmount() {
        return DecimalFormatUtil.formatBigDecimal(bidRequestAmount.subtract(currentSum), BidConst.DISPLAY_SCALE);
    }

    public String getJsonString() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("username", createUser.getUsername());
        map.put("title", title);
        map.put("bidRequestAmount", bidRequestAmount);
        map.put("currentRate", currentRate);
        map.put("monthes2Return", monthes2Return);
        map.put("returnType", getReturnTypeDisplay());
        map.put("totalRewardAmount", totalRewardAmount);
        return JSONObject.toJSONString(map);
    }

    public String getReturnTypeDisplay() {
        return returnType == BidConst.RETURN_TYPE_MONTH_INTEREST ? "按月到期" : "等额本息";
    }

    public String getbidRequestStateDisplay() {
        switch (bidRequestState) {
            case BIDREQUEST_STATE_PUBLISH_PENDING:
                return "待发布";
            case BIDREQUEST_STATE_BIDDING:
                return "招标中";
            case BIDREQUEST_STATE_UNDO:
                return "已撤销";
            case BIDREQUEST_STATE_BIDDING_OVERDUE:
                return "流标";
            case BIDREQUEST_STATE_APPROVE_PENDING_1:
                return "满标一审";
            case BIDREQUEST_STATE_APPROVE_PENDING_2:
                return "满标二审";
            case BIDREQUEST_STATE_REJECTED:
                return "满标审核被拒";
            case BIDREQUEST_STATE_PAYING_BACK:
                return "还款中";
            case BIDREQUEST_STATE_COMPLETE_PAY_BACK:
                return "完成";
            case BIDREQUEST_STATE_PAY_BACK_OVERDUE:
                return "逾期";
            case BIDREQUEST_STATE_PUBLISH_REFUSE:
                return "发标拒绝";
            default:
                return "";
        }
    }
}