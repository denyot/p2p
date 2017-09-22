<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>蓝源Eloan-P2P平台</title>
<#include "common/links-tpl.ftl" />
    <link type="text/css" rel="stylesheet" href="/css/account.css"/>
    <script type="text/javascript" src="/js/plugins/jQuery-File-Upload-master/js/vendor/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="/js/plugins/jQuery-File-Upload-master/js/jquery.iframe-transport.js"></script>
    <script type="text/javascript" src="/js/plugins/jQuery-File-Upload-master/js/jquery.fileupload.js"></script>
    <script type="text/javascript" src="/js/plugins/uploadify/jquery.uploadify.min.js"></script>

    <style type="text/css">
    </style>
    <script type="text/javascript">
        $(function () {
            $("#btn_uploadUserFiles").uploadify({
                buttonText: "风控资料上传",
                fileObjName: "file",
                fileTypeName: "风控资料",
                fileTypeExts: "*.gif; *.jpg; *.png",
                swf: "js/plugins/uploadify/uploadify.swf",
                uploader: "/userFileUpload;jsessionid=${sessionid}",
                overrideEvents: ["onQueueComplete"],
                onQueueComplete: function () {
                    window.location.reload();
                }
            });
        })
    </script>
</head>
<body>
<!-- 网页顶部导航 -->
<#include "common/head-tpl.ftl"/>
<#assign currentNav="account" />
<#include "common/navbar-tpl.ftl" />

<div class="container">
    <div class="row">
        <!--导航菜单-->
        <div class="col-sm-3">
        <#assign currentMenu="userFile"/>
					<#include "common/leftmenu-tpl.ftl" />
        </div>
        <!-- 功能页面 -->
        <div class="col-sm-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    用户认证文件信息
                </div>
            </div>
            <div class="row">
            <#list userFiles as file>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="${file.image}"/>
                        <div class="caption">
                            <#--<h4>${file.filetype.title}</h4>-->
                            <#--<p>得分：${file.score} &nbsp;&nbsp;状态：${file.stateDisplay}</p>-->
                        </div>
                    </div>
                </div>
            </#list>
            </div>
            <div class="row">
                <a href="javascript:;" id="btn_uploadUserFiles"></a>
            </div>
        </div>
    </div>
</div>
<#include "common/footer-tpl.ftl" />
</body>
</html>