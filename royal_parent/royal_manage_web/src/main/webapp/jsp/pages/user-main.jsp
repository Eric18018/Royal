<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>王者荣耀论坛管理系统</title>
</head>
<body>
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="../commom/head.jsp"%>

    <!-- 中间部分-->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="../commom/leftsidebar.jsp"%>

        <!-- 中间轮播图内容 -->
        <div class="hrms_main_ad col-sm-10">
            <div class="panel panel-success">
                <a href="/jsp/main.jsp">用户管理</a>
                / 用户信息
                <br>
                <br>



                用户名<input type="text">
                用户组<input type="text">
                <button type="button" class="btn btn-primary">查询</button>
                <br>
                <br>

                <div class="panel-body" style="position:relative; top:-15px;">
                    <table border="1" width="200%">
                        <tr>
                            <td height="100%">
                                用户名
                            </td>
                            <td>
                                用户组
                            </td>
                            <td>
                                邮箱
                            </td>
                            <td>
                                是否禁言
                            </td>
                            <td>
                                最近登录时间
                            </td>
                            <td>
                                操作
                            </td>
                        </tr>
                        <tr>
                            <c:forEach items="${userList}" var="user">
                        <tr>
                            <%--<td><input name="ids" type="checkbox"></td>--%>
                            <td>${user.userName }</td>
                            <td>${user.roleStr }</td>
                            <td>${user.email }</td>
                            <td>${user.talkStatusStr }</td>
                            <td>${user.lastLoginTimeStr }</td>
                            <td><button type="button" class="btn btn-primary">升级</button></td>
                        </tr>
                        </c:forEach>
                        </tr>

                    </table>


                </div><!-- /.panel-body -->
            </div><!-- /.panel -->
        </div><!-- /.hrms_main_ad -->
    </div><!-- /.hrms_body -->
    <!-- 尾部 -->
    <%@ include file="../commom/foot.jsp"%>
</div><!-- /.hrms_container -->

</body>
</html>
