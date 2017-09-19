package com.hxf.p2p.base.query;

import com.hxf.p2p.base.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.util.Date;

@Getter
@Setter
public class LoginlogQueryObject extends QueryObject {
    private int state = -1;
    private String username;
    private int userType = -1;

    public String getUsername() {
        return StringUtils.hasLength(username) ? username : null;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getEndTime() {
        return endTime == null ? null : DateUtil.getEndDate(endTime);
    }

}
