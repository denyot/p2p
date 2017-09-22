package com.hxf.p2p.base.query;

import com.hxf.p2p.base.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class AuthQueryObject extends QueryObject {
    private int state = -1;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getEndTime() {
        return endTime == null ? null : DateUtil.getEndDate(endTime);
    }
}
