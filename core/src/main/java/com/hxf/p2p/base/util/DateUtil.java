package com.hxf.p2p.base.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public DateUtil() {
    }

    public static Date getBeginDate(Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        now = calendar.getTime();
        return now;
    }

    public static Date getEndDate(Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(5, 1);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        calendar.add(13, -1);
        now = calendar.getTime();
        return now;
    }
}