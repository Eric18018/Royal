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
    <script src="../../../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <%--<script src="D:\work\Royal\royal_parent\royal_manage_web\src\main\webapp\plugins\jQuery\jquery-2.2.3.min.js"></script>--%>
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
                <%--<form action="${pageContext.request.contextPath}/user/findByUsernameAndRole.do">--%>
                 <form action="${pageContext.request.contextPath}/user/findByUsernameAndRole.do?name='valName'&role='selectedValue'">
                    <div class="dropdown">
                        <b>用户名：</b><input type="text" class="dropdown-toggle seek " name="name">
                        <%--<b>用户组：</b><input type="text" class="dropdown-toggle" name="role">--%>


                        <span>用户组</span>
                        <select name="role" style="width: 170px; height: 27px">
                            <option></option>
                            <option value="1">普通用户</option>
                            <option value="2">高级用户</option>
                            <option value="3">超级管理员</option>
                        </select>
                    <%--<b>用户组：</b><input type="text" class="dropdown-toggle" name="role">--%>


                        <%--<button type="button" class="btn dropdown-toggle" id="dropdownMenu1"--%>
                                <%--data-toggle="dropdown" name="role">--%>
                            <%--请输入用户组--%>
                            <%--<span class="caret"></span>--%>
                        <%--</button>--%>
                        <%--<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">--%>
           <%--                 <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/user/findByUsernameAndRole.do?role=1">普通用户</a>
                            </li>
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/user/findByUsernameAndRole.do?role=2">高级用户</a>
                            </li>
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/user/findByUsernameAndRole.do?role=3">超级管理员</a>
                            </li>--%>
                            <%--<input type="text" value="1">普通用户</input>--%>
                        <%--</ul>--%>
                        <button type="submit" class="btn btn-primary btn-xs">查询</button>
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
    <script>
        window.onload = function () {
            data: {
              role: '';
              name: '';
            };

            var select = document.getElementById("role");
            var name = document.getElementById("name");

            //1.如何获得当前选中的值？：
           // var value = select.value;
            var valName = name.value;//获取用户名

            //2.如何获得该下拉框所有的option的节点对象
            var options = select.options;
            //注意：得到的options是一个对象数组

            //3.如何获得第几个option的value值?比如我要获取第一option的value,可以这样：
            var value1 = options[0].value;
            //4.如何获得第几个option的文本内容?比如我要获取第一option的文本,可以这样：
            // var text1 = options[0].text;

            //5.如何获得当前选中的option的索引？
            var index = select.selectedIndex;

            //6.如何获得当前选中的option的文本内容？
            //从第2个问题，我们已经获得所有的option的对象数组options了
            //又从第5个问题，我们获取到了当前选中的option的索引值
            //所以我们只要同options[index]下标的方法得到当前选中的option了
            // var selectedText = options[index].text;
            var selectedValue = options[index].value;//获取下拉的value值
            // var names = valName.text
            // console.log(selectedText)
            // console.log(selectedValue)
            // console.log(valName)
            $("#btn").click(function(){
                console.log(selectedValue)
                console.log(valName)
                $.get("${pageContext.request.contextPath}/user/findByUsernameAndRole.do?name='valName'&role='selectedValue'",function(data,status){
                    alert("Data: " + data + "\nStatus: " + status);
                });
                <%--$.post("${pageContext.request.contextPath}/user/findByUsernameAndRole.do",{--%>
                    <%--name: valName,--%>
                    <%--role: selectedValue--%>
                <%--},function(data,status){--%>
                    <%--alert("Data: " + data + "\nStatus: " + status);--%>
                <%--});--%>
            });

        }
    </script>
</html>
