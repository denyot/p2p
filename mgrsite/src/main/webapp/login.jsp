<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>胡心烽-P2P平台(系统管理平台)</title>
<link rel="stylesheet" href="/js/bootstrap-3.3.2-dist/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="/css/core.css" type="text/css" />
<script type="text/javascript" src="/js/jquery/jquery-2.1.3.js"></script>
<script type="text/javascript" src="/js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/js/jquery.bootstrap.min.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<style type="text/css">
body{
	background-color:  #eee;
}
.cm-container{
	margin-top: 160px;
}
.login {
	width: 360px;
	height: 300px;
	margin: 0px auto;
}
</style>

<script type="text/javascript">
	$(function(){
		$("#loginForm").ajaxForm({success:function(data){
			if(data.success){
				window.location.href="/index";
			}else{
				$.messager.popup(data.msg);
			}
		}});
	});	
</script>

</head>
<body>
	<div class="container cm-container">
		<h3 class="text-center">胡心烽-P2P平台(系统管理平台)</h3>
		<hr />
		<div class="login">
			<form id="loginForm" action="/login" method="post">
				<div class="form-group form-group-lg">
					<div class="input-group">
						<div class="input-group-addon">用户名</div>
						<input class="form-control" name="username" value="huxinfeng"/>
					</div>
				</div>
				<div class="form-group form-group-lg">
					<div class="input-group">
						<div class="input-group-addon">密&emsp;码</div>
						<input class="form-control" name="password" type="password" value="1111"/>
					</div>
				</div>
				<div class="form-group">
					<button class="btn btn-lg btn-primary btn-block">登录</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>