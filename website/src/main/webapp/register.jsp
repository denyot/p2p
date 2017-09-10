<%--
  Created by IntelliJ IDEA.
  User: XIAOMI
  Date: 2017/9/10
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>P2P平台->用户注册</title>
    <link rel="stylesheet" href="js/bootstrap-3.3.2-dist/css/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="css/core.css" type="text/css" />
    <script type="text/javascript" src="js/jquery/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="js/plugins/jquery-validation/jquery.validate.js"></script>
    <script type="text/javascript" src="js/plugins/jquery-validation/localization/messages_zh.js"></script>
    <script type="text/javascript" src="js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>

    <style type="text/css">
        .el-register-form{
            width:600px;
            margin-left:auto;
            margin-right:auto;
            margin-top: 20px;
        }
        .el-register-form .form-control{
            width: 220px;
            display: inline;
        }
    </style>
    <script type="text/javascript">

    </script>
</head>
<body>
<!-- 网页头信息 -->
<div class="el-header" >
    <div class="container" style="position: relative;">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/">首页</a></li>
            <li><a href="login.html">登录</a></li>
            <li><a href="#">帮助</a></li>
        </ul>
    </div>
</div>

<!-- 网页导航 -->
<div class="navbar navbar-default el-navbar">
    <div class="container">
        <div class="navbar-header">
            <a href=""><img alt="Brand" src="/images/logo.png"></a>
            <span class="el-page-title">用户注册</span>
        </div>
    </div>
</div>

<!-- 网页内容 -->
<div class="container">
    <form id="registerForm" class="form-horizontal el-register-form" action="/register" method="post" >
        <p class="h4" style="margin: 10px 10px 20px;color:#999;">请填写注册信息，点击“提交注册”即可完成注册！</p>
        <div class="form-group">
            <label class="control-label col-sm-2">用户名</label>
            <div class="col-sm-10">
                <input type="text" autocomplete="off" name="username" class="form-control" id="username"/>
                <p class="help-block">用户名为4~16位字母，数字，符号或中文</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">密&emsp;码</label>
            <div class="col-sm-10">
                <input type="password" autocomplete="off" name="password" id="password" class="form-control" />
                <p class="help-block">密码为4~16位字符组成,采用数字、字母、符号安全性更高</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">确认密码</label>
            <div class="col-sm-10">
                <input type="password" autocomplete="off" name="confirmPwd" class="form-control" />
                <p class="help-block">请再次填写密码</p>
            </div>
        </div>
        <div class="form-gorup">
            <div class="col-sm-offset-2">
                <button type="submit" class="btn btn-success">
                    同意协议并注册
                </button>
                &emsp;&emsp;
                <a href="/login.html" class="text-primary">已有账号，马上登录</a>

                <p style="padding-left: 50px;margin-top: 15px;">
                    <a href="#">《使用协议说明书》</a>
                </p>
            </div>
        </div>
    </form>
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
                    src="/images/sina.png"></a>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</body>
</html>
