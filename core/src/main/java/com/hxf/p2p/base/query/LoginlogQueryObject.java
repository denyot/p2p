package com.hxf.p2p.base.query;

import com.hxf.p2p.base.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class LoginlogQueryObject extends QueryObject {


    private Date beginTime;
    private Date endTime;
    private int state = -1;
    private String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getEndTime() {
        return endTime==null?null: DateUtil.getEndDate(endTime);
    }


}
