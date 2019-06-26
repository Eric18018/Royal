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

        <!-- 中间 敏感词汇数据内容内容 -->
        <div class="hrms_main_ad col-sm-10">
            <div class="panel panel-success">
                <ol class="breadcrumb">
                    <li><a href="#">用户帖子管理</a></li>
                    <li class="active">铭感词汇管理</li>
                </ol>

                <hr>

                <%--工具栏--%>
                <form>
                    <button type="button" class="btn btn-primary " href="#">新增敏感词汇</button>

                </form>
                <hr>
                <%--表格--%>
                <div class="box-body"></div>
                <table id="example2" class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>敏感词</th>
                        <th>是否启用</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="words">
                        <tr>
                            <td>${words.wordId}</td>
                            <td>${words.word }</td>
                            <td>${words.statusStr }</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/article/findById?id=${article.articleId}"
                                           class="btn btn-info btn-xs">启用</a>
                                        <a href="${pageContext.request.contextPath}/article/findById?id=${article.articleId}"
                                           class="btn btn-danger btn-xs">停用</a>
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
                            总共${pageInfo.pages}页，共${pageInfo.total}条数据
                        </div>
                    </div>
                    <%--<div class="box-tools pull-right"><br>--%>
                        <%--<ul class="pagination">--%>
                            <%--<li><a href="#" aria-label="Previous">首页</a></li>--%>
                            <%--<li><a href="#">上一页</a></li>--%>
                            <%--<li><a href="#">1</a></li>--%>
                            <%--<li><a href="#">2</a></li>--%>
                            <%--<li><a href="#">3</a></li>--%>
                            <%--<li><a href="#">4</a></li>--%>
                            <%--<li><a href="#">5</a></li>--%>
                            <%--<li><a href="#">下一页</a></li>--%>
                            <%--<li><a href="#" aria-label="Next">尾页</a></li>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="${pageContext.request.contextPath}/word/findAll.do?page=1&size=${pageInfo.pageSize}" aria-label="Previous">首页</a>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a></li>
                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                <li><a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                            </c:forEach>
                            <li><a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a></li>
                            <li>
                                <a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="Next">尾页</a>
                            </li>
                        </ul>
                    </div>
                </div>

                </div>


            </div><!-- /.panel -->
        </div><!-- /.hrms_main_ad -->
    </div><!-- /.hrms_body -->
    <!-- 尾部 -->
    <%@ include file="../commom/foot.jsp" %>



</body>
</html>
