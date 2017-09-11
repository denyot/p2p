package com.hxf.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Systemdictionaryitem {
    private Long id;

    private Long parentId;

    private String title;

    private String tvalue;

    private Byte sequence;

    private String intro;

}