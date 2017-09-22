package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Userfile extends BaseAuth {
    private String image;//风控图片
    private Systemdictionaryitem filetype;//风控文件类型
    private Integer score;//风控材料评分
}
