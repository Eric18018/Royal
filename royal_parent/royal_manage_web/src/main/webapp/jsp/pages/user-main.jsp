<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>王者荣耀论坛管理系统</title>
</head>
<body>
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="../commom/head.jsp" %>

    <!-- 中间部分-->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="../commom/leftsidebar.jsp" %>

        <!-- 中间轮播图内容 -->
        <div class="hrms_main_ad col-sm-10">
            <div class="panel panel-success">
                <ol class="breadcrumb">
                    <li><a href="#">用户管理</a></li>
                    <li class="active">用户信息</li>
                </ol>

                <hr>

                <%--搜索栏--%>
                <form action="${pageContext.request.contextPath}/user/findByUsernameAndRole.do">

                    <div class="dropdown">
                    <b>用户名：</b><input type="text" class="dropdown-toggle" name="name">
                    <%--<b>用户组：</b><input type="text" class="dropdown-toggle" name="role">--%>

                        <button type="button" class="btn dropdown-toggle" id="dropdownMenu1"
                                data-toggle="dropdown" name="role">
                            请输入用户组
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/user/findByUsernameAndRole.do?role=1">普通用户</a>
                            </li>
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/user/findByUsernameAndRole.do?role=2">高级用户</a>
                            </li>
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/user/findByUsernameAndRole.do?role=3">超级管理员</a>
                            </li>
                        </ul>
                        <button type="submit" class="btn btn-primary btn-xs" href="#">查询</button>
                    </div>


                </form>
                <hr>
                <%--表格--%>
                <div class="box-body"></div>
                <table id="example2" class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>用户组</th>
                        <th>邮箱</th>
                        <th>是否禁言</th>
                        <th>最近登录时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.userName }</td>
                            <td>${user.roleStr }</td>
                            <td>${user.email }</td>
                            <td>${user.talkStatusStr }</td>
                            <td>${user.lastLoginTimeStr }</td>
                            <td>
                                        <a href="/article/deleteByArticleId.do?articleId=${article.articleId}"
                                           class="btn btn-primary btn-xs">升级</a>
                                    </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <%--页码--%>


                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            <br>
                            总共2 页，共14 条数据
                        </div>
                    </div>
                    <div class="box-tools pull-right"><br>
                        <ul class="pagination">
                            <li><a href="#" aria-label="Previous">首页</a></li>
                            <li><a href="#">上一页</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">下一页</a></li>
                            <li><a href="#" aria-label="Next">尾页</a></li>
                        </ul>
                    </div>
                </div>


            </div><!-- /.panel -->
        </div><!-- /.hrms_main_ad -->
    </div><!-- /.hrms_body -->
    <!-- 尾部 -->
    <%@ include file="../commom/foot.jsp" %>


</body>
</html>
