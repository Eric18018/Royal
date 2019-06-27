<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>王者荣耀论坛管理系统</title>

    <style type="text/css">
        .seek {
            border: 1px solid gainsboro;
            border-radius: 5px 5px 5px 5px;
        }
    </style>
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
                        <b>用户名：</b><input type="text" class="dropdown-toggle seek " name="name">
                        <%--<b>用户组：</b><input type="text" class="dropdown-toggle" name="role">--%>

                        <b>用户组：</b><input type="text" list="roles" class="seek">
                        <datalist id="roles">
                            <option value="普通用户"
                                    href="${pageContext.request.contextPath}/user/findByUsernameAndRole.do?role=1">
                            <option value="高级用户"
                                    href="${pageContext.request.contextPath}/user/findByUsernameAndRole.do?role=2">
                            <option value="超级管理员"
                                    href="${pageContext.request.contextPath}/user/findByUsernameAndRole.do?role=2">
                        </datalist>

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
                    <c:forEach items="${pageInfo.list}" var="user">
                        <tr>
                            <td>${user.userName }</td>
                            <td>${user.roleStr }</td>
                            <td>${user.email }</td>
                            <td>${user.talkStatusStr }</td>
                            <td>${user.lastLoginTimeStr }</td>
                            <td>
                                <c:if test="${user.updateStatus == 0 && user.isupdating == 1 && user.role == 1}">
                                <a href="${pageContext.request.contextPath}/user/updateByUserId.do?userId=${user.userId}&role=${user.role}"
                                   class="btn btn-primary btn-xs">升级</a>
                                </c:if>
                                <c:if test="${user.role == 2}">
                                <a href="${pageContext.request.contextPath}/user/updateByUserId.do?userId=${user.userId}&role=${user.role}"
                                   class="btn btn-warning btn-xs">降级</a>
                                </c:if>

                                <c:if test="${user.talkStatus == 0 && user.role != 3}">
                                    <a href="${pageContext.request.contextPath}/user/stopByUserId.do?userId=${user.userId}&talkStatus=${user.talkStatus}"
                                       class="btn btn-danger btn-xs">禁言</a>
                                </c:if>
                                <c:if test="${user.talkStatus == 1 && user.role != 3}">
                                    <a href="${pageContext.request.contextPath}/user/stopByUserId.do?userId=${user.userId}&talkStatus=${user.talkStatus}"
                                       class="btn btn-info btn-xs">取消</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <%--页码--%>

                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            <br>、
                            当前第 ${pageInfo.pageNum} 页.总共${pageInfo.pages}页，共${pageInfo.total}条数据
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="${pageContext.request.contextPath}/user/findAll.do?page=1&size=${pageInfo.pageSize}"
                                   aria-label="Previous">首页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/user/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                            </li>
                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                <li>
                                    <a href="${pageContext.request.contextPath}/user/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                </li>
                            </c:forEach>
                            <li>
                                <a href="${pageContext.request.contextPath}/user/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/user/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
                                   aria-label="Next">尾页</a>
                            </li>
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
