package com.hxf.p2p.base.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

/**
 * 数据字典查询对象
 */
@Getter
@Setter
public class SystemDictionaryQueryObject extends QueryObject {
    private String keyword;//关键字
    private Long parentId;

    public String getKeyword() {
        return StringUtils.hasLength(keyword) ? keyword : null;
    }

}
