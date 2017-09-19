<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- html <head>标签部分  -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>蓝源Eloan-P2P平台(系统管理平台)</title>
<#include "../common/header.ftl"/>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery-validation/jquery.validate.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#pagination").twbsPagination({
                totalPages:${pageResult.totalPage},
                visiblePages: 5,
                startPage:${qo.currentPage},
                first: "首页",
                prev: "上一页",
                next: "下一页",
                last: "尾页",
                onPageClick: function (event, page) {
                    $("#currentPage").val(page);
                    $("#searchForm").submit();
                }
            });
            $(".group_item").click(function () {
                $(this).addClass("active");
                $("#parentId").val($(this).data("dataid"));
                $("#searchForm").submit();
            });
            var parentIdValue = $("#parentId").val();
            if (parentIdValue) {
                $("[data-dataid=" + parentIdValue + "]").closest("li").addClass("active");
            }
            $("#addSystemDictionaryItemBtn").click(function () {
                if (parentIdValue) {
                    $("#systemDictionaryItemModal").modal("show")
                } else {
                    $.messager.popup("请选择目录!");
                }
            })
            $("#saveBtn").click(function () {
                $("#editForm").ajaxSubmit(function (data) {
                    if (data.success) {
                        window.location.reload();
                    } else {
                        $.messager.popup(data.msg)
                    }

                })
            })
            $(".edit_Btn").click(function () {
                var json = $(this).data("jsonstr");
                $("#systemDictionaryId").val(json.id);
                $("#title").val(json.title);
                $("#sequence").val(json.sequence);
                $("#editFormParentId").val(json.parentId);
                $("#systemDictionaryItemModal").modal("show");
            })

        });
    </script>
</head>
<body>
<div class="container">
<#include "../common/top.ftl"/>
    <div class="row">
        <div class="col-sm-3">
        <#assign currentMenu="systemDictionaryItem" />
				<#include "../common/menu.ftl" />
        </div>
        <div class="col-sm-9">
            <div class="page-header">
                <h3>数据字典明细管理</h3>
            </div>
            <div class="col-sm-12">
                <!-- 提交分页的表单 -->
                <form id="searchForm" class="form-inline" method="post" action="systemDictionaryItem_list">

                    <input type="hidden" id="currentPage" name="currentPage" value="${(qo.currentPage)!''}"/>
                    <input type="hidden" id="parentId" name="parentId" value='${(qo.parentId)!""}'/>
                    <div class="form-group">
                        <label>关键字</label>
                        <input class="form-control" type="text" name="keyword" value="${(qo.keyword!'')}">
                    </div>
                    <div class="form-group">
                        <button id="query" class="btn btn-success"><i class="icon-search"></i> 查询</button>
                        <a href="javascript:void(-1);" class="btn btn-success"
                           id="addSystemDictionaryItemBtn">添加数据字典明细</a>
                    </div>
                </form>
                <div class="row" style="margin-top:20px;">
                    <div class="col-sm-3">
                        <ul id="menu" class="list-group">
                            <li class="list-group-item">
                                <a href="#" data-toggle="collapse" data-target="#systemDictionary_group_detail"><span>数据字典分组</span></a>
                                <ul class="in" id="systemDictionary_group_detail">
                                <#list systemDictionaryGroups as vo>
                                    <li><a class="group_item" data-dataid="${vo.id}"
                                           href="javascript:;"><span>${vo.title}</span></a></li>
                                </#list>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-9">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>名称</th>
                                <th>序列</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list pageResult.result as vo>
                            <tr>
                                <td>${vo.title}</td>
                                <td>${vo.sequence!""}</td>
                                <td>
                                    <a href="javascript:;" class="edit_Btn" data-jsonstr='${vo.jsonString}'>修改</a>
                                </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>

                        <div style="text-align: center;">
                            <ul id="pagination" class="pagination"></ul>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="systemDictionaryItemModal" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">编辑/增加</h4>
            </div>
            <div class="modal-body">
                <form id="editForm" class="form-horizontal" method="post" action="systemDictionaryItem_saveOrUpdate"
                      style="margin: -3px 118px">
                    <input id="systemDictionaryId" type="hidden" name="id" value=""/>
                    <input type="hidden" name="parentId" id="editFormParentId" value='${(qo.parentId)!""}'/>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">名称</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="title" id="title" placeholder="字典值名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">顺序</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="sequence" id="sequence" placeholder="字典值显示顺序">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a href="javascript:void(0);" class="btn btn-success" id="saveBtn" aria-hidden="true">保存</a>
                <a href="javascript:void(0);" class="btn" data-dismiss="modal" aria-hidden="true">关闭</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>