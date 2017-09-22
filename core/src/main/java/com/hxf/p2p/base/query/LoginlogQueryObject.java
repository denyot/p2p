package com.hxf.p2p.base.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Getter
@Setter
public class LoginlogQueryObject extends AuthQueryObject {
    private String username;
    private int userType = -1;

    public String getUsername() {
        return StringUtils.hasLength(username) ? username : null;
    }
}
