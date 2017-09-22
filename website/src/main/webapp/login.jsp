<%--
  Created by IntelliJ IDEA.
  User: XIAOMI
  Date: 2017/9/11
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>P2P平台->用户登录</title>
    <link rel="stylesheet" href="js/bootstrap-3.3.2-dist/css/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="css/core.css" type="text/css" />
    <script type="text/javascript" src="js/jquery/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>
    <script type="text/javascript" src="js/plugins/jquery-validation/jquery.validate.js"></script>
    <script type="text/javascript" src="js/plugins/jquery-validation/localization/messages_zh.js"></script>
    <script type="text/javascript" src="js/plugins/jquery.form.js"></script>

    <style type="text/css">
        .el-login-form{
            width:600px;
            margin-left:auto;
            margin-right:auto;
            margin-top: 20px;
        }
        .el-login-form .form-control{
            width: 220px;
            display: inline;
        }
    </style>

    <script type="text/javascript">
        $(function(){
            $("#loginForm").validate({
                //自定义错误样式
                errorClass:"text-danger",
                //未通过验证,进行高亮处理或其他处理；
                highlight:function(input){
                    $(input).closest(".form-group").addClass("has-error");
                },
                //通过验证,清除高亮效果或其他处理；
                unhighlight:function(input){
                    $(input).closest(".form-group").removeClass("has-error");
                },
                //验证成功后，提交操作；
                submitHandler:function(form){
                    $(form).ajaxSubmit(function(data){
                        if(data.success){
                            $.messager.confirm("提示","登录成功,点击确认跳转个人中心!",function(){
                                window.location.href="/personal";
                            });
                        }else{
                            $.messager.popup(data.msg);
                        }
                    });
                },
                rules:{
                    username:"required",
                    password:"required"
                }
            });
        });

    </script>

</head>
<body>
<!-- 网页头信息 -->
<div class="el-header" >
    <div class="container" style="position: relative;">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/index">首页</a></li>
            <li><a href="/login.jsp">登录</a></li>
            <li><a href="#">帮助</a></li>
        </ul>
    </div>
</div>

<!-- 网页导航 -->
<div class="navbar navbar-default el-navbar">
    <div class="container">
        <div class="navbar-header">
            <a href=""><img alt="Brand" src="/images/logo.png"></a>
            <span class="el-page-title">用户登录</span>
        </div>
    </div>
</div>

<!-- 网页内容 -->
<div class="container">
    <form id="loginForm" class="form-horizontal el-login-form" action="/login" method="post" >
        <p class="h4" style="margin: 10px 10px 20px 110px;color:#999;">请输入用户名和密码</p>
        <div class="form-group">
            <label class="control-label col-sm-2">用户名</label>
            <div class="col-sm-10">
                <input type="text" autocomplete="off" name="username" class="form-control" value="huxinfeng1"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">密&emsp;码</label>
            <div class="col-sm-10">
                <input type="password" autocomplete="off" name="password" class="form-control" value="1111"/>
            </div>
        </div>
        <div class="form-gorup">
            <div class="col-sm-offset-3">
                <button type="submit" class="btn btn-success" style="width: 100px;">
                    登录
                </button>
                &emsp;&emsp;
                <a href="/register.jsp">新用户，马上注册</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
