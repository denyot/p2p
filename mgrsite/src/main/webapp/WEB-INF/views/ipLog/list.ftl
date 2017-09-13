<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蓝源Eloan-P2P平台(系统管理平台)</title>
<#include "../common/header.ftl"/>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js" ></script>

<script type="text/javascript">
	$(function() {
//		var searchForm = $("#searchForm");
//		var gridBody = $("#tbody");
//		searchForm.ajaxForm(function(data){
//			gridBody.hide();
//			gridBody.html(data);
//			gridBody.show(500);
//		}).submit();
		
		$(".beginDate,.endDate").click(function(){
			WdatePicker();
		});
		
		$("#query").click(function(){
			$("#currentPage").val(1);
			$("#searchForm").submit();
		});
        $("#state option[value=${qo.state}]").prop("selected", true);
        $("#userType option[value=${qo.userType}]").prop("selected", true);

        $("#pagination_container").twbsPagination({
            totalPages: ${pageResult.totalPage},
            visiblePages: 5,
            startPage:${pageResult.currentPage},
            onPageClick: function (event, page) {
                $("#currentPage").val(page);
                $("#searchForm").submit();
            }
        })
	});
</script>
</head>
<body>
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3">
				<#assign currentMenu="ipLog" />
				<#include "../common/menu.ftl" />
			</div>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>登录日志查询</h3>
				</div>
				<form id="searchForm" class="form-inline" method="post" action="/loginlog_list">
					<input type="hidden" id="currentPage" name="currentPage" value="${qo.currentPage}"/>
					<div class="form-group">
					    <label>状态</label>
					     <select class="form-control" name="state" id="state">
					    	<option value="-1">全部</option>
					    	<option value="0">登录失败</option>
					    	<option value="1">登录成功</option>
					    </select>
					</div>
					<div class="form-group">
					    <label>登陆时间</label>
					    <input class="form-control beginDate" type="text" name="beginTime" value='${(qo.beginTime?string("yyyy-MM-dd"))!""}'/>到
					    <input class="form-control endDate" type="text" name="endTime" value='${(qo.endTime?string("yyyy-MM-dd"))!""}'/>
					</div>
                    <label>用户类型</label>
                    <select class="form-control" name="userType" id="userType">
                        <option value="-1">全部</option>
                        <option value="0">前端用户</option>
                        <option value="1">系统管理</option>
                    </select>
					<div class="form-group">
						<label>用户名</label>
						<input class="form-control" type="text" name="username" value='${(qo.username)!""}'/>
					</div>

					<div class="form-group">
						<button id="query" type="button" class="btn btn-success"><i class="icon-search"></i> 查询</button>
					</div>
				</form>
				<div class="panel panel-default">
					<table class="table">
						<thead>
							<tr>
								<th>用户</th>
								<th>登录时间</th>
								<th>登录ip</th>
								<th>登录状态</th>
								<th>用户类型</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<#list pageResult.result as item>
							    <tr>
									<#--<td>xx</td>-->
									<td>${(item.username)!""}</td>
									<td>${item.loginTime?string("yyyy-MM-dd HH:mm:ss")}</td>
									<td>${item.ip}</td>
									<td>${item.state?string("登陆成功","登陆失败")}</td>
									<td>${item.userType?string("系统管理员","前端用户")}</td>
								</tr>
							</#list>
						</tbody>
					</table>
					<div style="text-align: center;" id="pagination_container">
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>