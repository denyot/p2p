<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>蓝源Eloan-P2P平台</title>
<#include "common/links-tpl.ftl" />
    <link type="text/css" rel="stylesheet" href="/css/account.css"/>
    <script type="text/javascript" src="/js/plugins/uploadify/jquery.uploadify.min.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="/js/plugins/jQuery-File-Upload-master/js/vendor/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="/js/plugins/jQuery-File-Upload-master/js/jquery.iframe-transport.js"></script>
    <script type="text/javascript" src="/js/plugins/jQuery-File-Upload-master/js/jquery.fileupload.js"></script>
    <style type="text/css">
        #realAuthForm input, #realAuthForm select {
            width: 260px;
        }

        .idCardItem {
            width: 160px;
            height: 150px;
            float: left;
            margin-right: 10px;
            border: 1px solid #e3e3e3;
            text-align: center;
            padding: 5px;
        }

        .uploadImg {
            width: 120px;
            height: 100px;
            margin-top: 5px;
        }

        .bar {
            height: 18px;
            background: green;
        }

        .swfupload {
            left: 0px;
            cursor: pointer;
        }

        .uploadify {
            height: 20px;
            font-size: 13px;
            line-height: 20px;
            text-align: center;
            position: relative;
            margin-left: auto;
            margin-right: auto;
            cursor: pointer;
            background-color: #337ab7;
            border-color: #2e6da4;
            color: #fff;
        }

        #viewExample {
            position: relative;
            left: 50px;
            top: 60px;
        }

        .uploadExample {
            width: 200px;
            height: 130px;
            margin-bottom: 20px;
        }
    </style>

    <script type="text/javascript">

        $(function () {
            $("#viewExample").popover({
                html: true,
                content: '正面<img src="/images/upload_source_2.jpg" class="uploadExample"/><br/>反面<img src="/images/upload_source_2_1.jpg" class="uploadExample"/>',
                trigger: "hover",
                placement: "top"
            });
            $("#uploadBtn1").uploadify({
                buttonText: "身份证正面",
                fileObjName: "file",
                fileTypeName: "身份证正面图片",
                fileTypeExts: "*.gif; *.jpg; *.png",
                multi: false,
                swf: "js/plugins/uploadify/uploadify.swf",
                uploader: "/realAuthUpload",
                overrideEvents: ["onUploadSuccess","onselect"],
                onUploadSuccess: function (file, data) {
                    $("#uploadImg1").prop("src", data);
                    $("#uploadImage1").val(data);
                }
            });
            $("#uploadBtn2").uploadify({
                buttonText: "身份证反面",
                fileObjName: "file",
                fileTypeName: "身份证反面图片",
                fileTypeExts: "*.gif; *.jpg; *.png",
                multi: false,
                swf: "js/plugins/uploadify/uploadify.swf",
                uploader: "/realAuthUpload",
                overrideEvents: ["onUploadSuccess"],
                onUploadSuccess: function (file, data) {
                    $("#uploadImg2").prop("src", data);
                    $("#uploadImage2").val(data);
                }
            });

            $("#realAuthForm").ajaxForm(function () {
                $.messager.confirm("提示", "实名认证申请提交成功", function () {
                    window.location.reload();
                })

            })
        });
    </script>
</head>
<body>
<!-- 网页顶部导航 -->
<#include "common/head-tpl.ftl"/>
<#assign currentNav="personal" />
<#include "common/navbar-tpl.ftl" />

<div class="container">
    <div class="row">
        <!--导航菜单-->
        <div class="col-sm-3">
        <#assign currentMenu="realAuth"/>
					<#include "common/leftmenu-tpl.ftl" />
        </div>
        <!-- 功能页面 -->
        <div class="col-sm-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    实名认证
                </div>
                <form class="form-horizontal" id="realAuthForm" method="post" action="/realAuth_save"
                      novalidate="novalidate">
                    <fieldset>
                        <div class="form-group">
                            <p class="text-center text-danger">为保护您账户安全，实名认证成功之后不能修改信息，请认真填写！</p>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label ">用户名</label>
                            <div class="col-sm-8">
                                <p class="form-control-static">${logininfo.username }</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="realName">姓名</label>
                            <div class="col-sm-8">
                                <input id="realName" name="realname" class="form-control" type="text" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4  control-label" for="sex">性别</label>
                            <div class="col-sm-8">
                                <select id="sex" class="form-control" name="sex" size="1">
                                    <option value="0">男</option>
                                    <option value="1">女</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4  control-label" for="idnumber">证件号码</label>
                            <div class="col-sm-8">
                                <input id="idNumber" class="form-control" name="idNumber" type="text" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4  control-label" for="birthdate">出生日期</label>
                            <div class="col-sm-8">
                                <input id="birthDate" class="form-control" name="birthDate" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4  control-label" for="address">证件地址</label>
                            <div class="col-sm-8">
                                <input id="address" class="form-control" name="address" type="text"
                                       style="max-width: 100%;width:500px;">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-4  control-label" for="address">身份证照片</label>
                            <div class="col-sm-8">
                                <p class="text-help text-primary">请点击“选择图片”,选择证件的正反两面照片。</p>
                                <a href="javascript:;" id="viewExample">查看样板</a>
                                <div class="idCardItem">
                                    <div>
                                        <a href="javascript:;" id="uploadBtn1">上传正面</a>
                                    </div>
                                    <img alt="" src="" class="uploadImg" id="uploadImg1"/>
                                    <input type="hidden" name="image1" id="uploadImage1"/>
                                </div>
                                <div class="idCardItem">
                                    <div>
                                        <a href="javascript:;" id="uploadBtn2">上传反面</a>
                                    </div>
                                    <img alt="" src="" class="uploadImg" id="uploadImg2"/>
                                    <input type="hidden" name="image2" id="uploadImage2"/>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" id="asubmit" class="btn btn-primary col-sm-offset-4"
                                    data-loading-text="正在提交"><i class="icon-ok"></i> 提交认证
                            </button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<#include "common/footer-tpl.ftl" />
</body>
</html>