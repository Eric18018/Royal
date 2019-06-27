<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登录失败</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/bootstrap/bootstrap.min.css">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/bootstrap/bootstrap-theme.min.css">
    <script src="/bootstrap/jquery-1.11.0.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/bootstrap/bootstrap.min.js"></script>

    <style type="text/css">
        .txt{
            font-size: 20px;
            color: red;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="margin: 380px 380px">
            <div class="login-panel panel panel-default"style="margin-top:-130px" >
                <div class="panel-heading">
                    <h3 class="panel-title" style="text-align: center;">王者荣耀论坛管理后台</h3>
                </div>
                <div class="panel-body">
                    <div id="errorMsg" class="alert alert-danger" ></div>
                    <form role="form" method="post" id="login_form">
                        <fieldset>
                            <div class="form-group">
                                <b class="txt">对不起，由于您的余额不足，已被关闭登录权限 ！！！</b>
                            </div>

                            <!-- Change this to a button or input when using this as a form -->
                            <!--<a href="javascript:void(0)" class="btn btn-lg btn-success btn-block" id='login_btn'>登录</a>-->
                            <input onclick="javascrtpt:window.location.href='/jsp/login.jsp'" type="button" id="btn_sub" class="btn btn-lg btn-success btn-block" value="充值">
                        </fieldset>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
