package com.hxf.p2p.base.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResult {
    private boolean success = true;
    private String msg;
    public JsonResult(){
        super();
    }

    public JsonResult(String msg) {
        super();
        this.msg = msg;
    }

    public JsonResult(boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }
}
