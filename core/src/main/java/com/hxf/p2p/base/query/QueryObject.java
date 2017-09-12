package com.hxf.p2p.base.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryObject {
    protected Integer pageSize = 10;
    protected Integer currentPage = 1;

    public Integer getStart() {
        return (this.currentPage - 1) * pageSize;
    }
}
