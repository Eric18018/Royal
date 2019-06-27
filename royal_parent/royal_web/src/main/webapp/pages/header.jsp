<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <script>

        $(function () {
            $("#submit").click(checkLogin);

            function checkLogin() {
                var userName = $("#userName").val();
                var userPass = $("#userPass").val();

                $.post("${pageContext.request.contextPath}/user/login.do",{"userName":userName,"userPass":userPass},function(data){
                    if(data == "false"){
                        alert("登录失败，请重新登录");
                    }else{
                        //登录成功
                        alert("登录成功");
                        window.location.reload();
                    }
                });

            }
        });



    </script>
</head>

<!-- 头部 -->
<div class="hm-top-nav">
    <div class="hm-inner clearfix">
        <div class="hm-inner-l l"></div>
        <div class="hm-inner-r r">
            <div class="box">
                <c:if test= "${user.userName == null}">
                    <a href="javascript:;" id="login" class="to-login">游客登录</a>
                    <a href="${pageContext.request.contextPath}/pages/register.jsp">【新用户注册】</a>
                </c:if>
                <c:if test= "${user.userName != null}">
                    <d>欢迎&nbsp;${user.roleStr}&nbsp;:&nbsp;${user.userName}</d>
                    <a href="${pageContext.request.contextPath}/pages/user_info.jsp">个人中心</a>
                    <a href="${pageContext.request.contextPath}/user/logout.do">注销</a>
                </c:if>

                <div id="dialogBg"></div>
                <div id="dialog" class="animated">
                    <img class="dialogIco" width="50" height="40" src="../images/ico.png"/>
                    <div class="dialogTop" style="height:25px;">
                        <a href="javascript:;" class="closeDialogBtn">关闭</a>
                    </div>
                    <%--<form action="${pageContext.request.contextPath}/user/login.do" >--%>
                    <form action="#" >
                        <ul class="editInfos">
                            <li>用户名：<input type="text" id="userName" name="userName" class="ipt"/></li>
                            <li>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="userPass" name="userPass" class="ipt"/></li>
                            <li><input id="submit" type="submit" value="登录" class="submitBtn"/></li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    $(function () {
        //显示弹框
        $('.box #login').click(function () {
            var className = $(this).attr('class');
            $('#dialogBg').fadeIn(300);
            $('#dialog').removeAttr('class').addClass('animated ' + className + '').fadeIn();
            $('#userName').focus();
            $("#j_fixedBar").hide();
        });

        //关闭弹窗
        $('.closeDialogBtn').click(function () {
            $('#dialogBg').fadeOut(300, function () {
                $('#dialog').addClass('bounceOutUp').fadeOut();
                $("#j_fixedBar").show();
            });
        });

    });
</script>
