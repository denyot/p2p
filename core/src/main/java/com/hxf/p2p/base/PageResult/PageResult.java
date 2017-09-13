package com.hxf.p2p.base.PageResult;

import lombok.Getter;

import java.util.List;

//封装分页查询结果
@Getter
public class PageResult {
    private Integer totalCount;// 结果总数
    private List result;// 结果集
    private Integer currentPage = 1; // 当前页面
    private Integer pageSize = 10; // 每页数据
    private Integer totalPage; // 总页数
    private Integer prevPage; // 上一页
    private Integer nextPage; // 下一页

    public Integer getTotalPage() {
        return totalPage == 0 ? 1 : totalPage;
    }

    public PageResult(Integer totalCount, List result, Integer currentPage, Integer pageSize) {
        super();
        this.totalCount = totalCount;
        this.result = result;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        this.prevPage = currentPage - 1 > 0 ? currentPage - 1 : currentPage;
        this.nextPage = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;
    }
}
