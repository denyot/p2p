<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蓝源Eloan-P2P平台->我要借款</title>
<link rel="stylesheet" href="js/bootstrap-3.3.2-dist/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/core.css" type="text/css" />
<script type="text/javascript" src="js/jquery/jquery-2.1.3.js"></script>
<script type="text/javascript" src="js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>
</head>
<body>
	<!-- 网页头信息 -->
	<div class="el-header" >
		<div class="container" style="position: relative;">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/">首页</a></li>
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">快速注册</a></li>
				<li><a href="#">帮助</a></li>
			</ul>
		</div>
	</div>
	
	<!-- 网页导航 -->
	<div class="navbar navbar-default el-navbar">
		<div class="container">
			<div class="navbar-header">
				<a href="/">
					<img alt="Brand" src="/images/logo.png">
				</a>
			</div>
			<ul class="nav navbar-nav">
				<li id="index"><a href="/">首页</a></li>
				<li id="invest"><a href="/invest">我要投资</a></li>
				<li id="borrow" class="active"><a href="/borrow.jsp">我要借款</a></li>
				<li id="account"><a href="/personal">个人中心</a></li>
				<li><a href="#">新手指引</a></li>
				<li><a href="#">关于我们</a></li>
			</ul>
		</div>
	</div>
	
	<!-- 网页内容 -->
	<div class="container el-borrow">
		<div class="row">
			<div class="el-borrow-item col-sm-4">
				<div class="el-borrow-item-title" style="background-color: #40d47e;">
					信用贷</div>
				<div class="el-borrow-item-content">
					<p>
						认证后可借金额 <i>¥ 2,000.00</i>
					</p>
					<a href="#" class="text-primary">申请条件</a>
					<p class="help-block">仅限广州地区</p>
					<ul>
						<li>填写基本资料</li>
						<li>身份认证</li>
						<li>材料认证分数达到30分</li>
						<li>视频认证</li>
					</ul>
					<a href="/login.jsp" class="el-borrow-apply">
						登陆后申请
					</a>
				</div>
			</div>
			<div class="el-borrow-item col-sm-4">
				<div class="el-borrow-item-title">车易贷</div>
				<div class="el-borrow-item-content">
					<p>
						认证后可借金额 <i>¥ 10,000.00</i>
					</p>
					<a href="#" class="text-primary">申请条件</a>
					<p class="help-block">仅限广州地区</p>
					<ul>
						<li>填写基本资料</li>
						<li>身份认证</li>
						<li>材料认证分数达到30分</li>
						<li>提交车辆抵押相关资料</li>
						<li>视频认证</li>
					</ul>
					<a href="#" class="el-borrow-apply">
						登陆后申请
					</a>
				</div>
			</div>
			<div class="el-borrow-item col-sm-4">
				<div class="el-borrow-item-title" style="background-color: #2ca2ee;">
					房易贷</div>
				<div class="el-borrow-item-content">
					<p>
						可借金额 <i>¥ 10,0000.00</i>
					</p>
					<a href="#" class="text-primary">申请条件</a>
					<p class="help-block">仅限广州地区</p>
					<ul>
						<li>填写基本资料</li>
						<li>身份认证</li>
						<li>材料认证分数达到50分</li>
						<li>提交房屋抵押相关资料</li>
						<li>视频认证</li>
					</ul>
					<a href="#" class="el-borrow-apply">
						登陆后申请
					</a>
				</div>
			</div>
		</div>
	</div>

	<!-- 网页版权 -->
	<div class="container-foot-2">
		<div class="context">
			<div class="left">
				<p>专注于高级Java开发工程师的培养</p>
				<p>版权所有：&emsp;2015广州小码哥教育科技有限公司</p>
				<p>地&emsp;&emsp;址：&emsp;广州市天河区棠下荷光三横路盛达商务园D座5楼</p>
				<p>电&emsp;&emsp;话： 020-29007520&emsp;&emsp;
					邮箱：&emsp;service@520it.com</p>
				<p>
					<a href="http://www.miitbeian.gov.cn" style="color: #ffffff">ICP备案
						：粤ICP备字1504547</a>
				</p>
				<p>
					<a href="http://www.gzjd.gov.cn/wlaqjc/open/validateSite" style="color: #ffffff">穗公网安备：44010650010086</a>
				</p>
			</div>
			<div class="right">
				<a target="_blank" href="http://weibo.com/ITxiaomage"><img
					src="images/sina.png"></a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</body>
</html>