package com.hxf.p2p.base.query;

import com.hxf.p2p.base.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class LoginlogQueryObject extends QueryObject {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    private int state = -1;
    private String username;

    public String getUsername() {
        return username == "" ? null : username;
    }

    private int userType = -1;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getEndTime() {
        return endTime == null ? null : DateUtil.getEndDate(endTime);
    }

}
