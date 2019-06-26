<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>王者荣耀论坛管理系统</title>

    <style type="text/css">
        .seek{
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
                    <li><a href="#">用户帖子管理</a></li>
                    <li class="active">帖子信息</li>
                </ol>

                <hr>

                <%--搜索栏--%>
                <form>

                    <b>标题：</b><input type="text" class="dropdown-toggle seek">
                    <b>创贴人：</b><input type="text" class="dropdown-toggle seek">


                    <button type="button" class="btn btn-primary btn-xs" href="#">查询</button>

                </form>
                <hr>
                <%--表格--%>
                <div class="box-body"></div>
                <table id="example2" class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>标题</th>
                        <th>内容</th>
                        <th>创贴人</th>
                        <th>是否置顶</th>
                        <th>回复数</th>
                        <th>点赞数</th>
                        <th>浏览数</th>
                        <th>所在交流区</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="article">
                        <tr>
                            <td>${article.title}</td>
                            <td>${article.content }</td>
                            <td>${article.senderName }</td>
                            <td>${article.isTopStr}</td>
                            <td>${article.replyCount}</td>
                            <td>${article.upvoteCount }</td>
                            <td>${article.browseCount}</td>
                            <td>${article.zoneId}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/article/deleteByArticleId.do?articleId=${article.articleId}"
                                           class="btn btn-primary btn-xs">屏蔽</a>
                                        <c:if test="${article.isTop == 1}">
                                        <a href="${pageContext.request.contextPath}/article/updateByArticleId.do?articleId=${article.articleId}&isTop=${article.isTop}"
                                           class="btn btn-info btn-xs">取消</a>
                                        </c:if>
                                        <c:if test="${article.isTop == 0}">
                                        <a href="${pageContext.request.contextPath}/article/updateByArticleId.do?articleId=${article.articleId}&isTop=${article.isTop}"
                                           class="btn btn-danger btn-xs">置顶</a>
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
                            <br>
                            总共${pageInfo.pages}页，共${pageInfo.total}条数据
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="${pageContext.request.contextPath}/article/findAll.do?page=1&size=${pageInfo.pageSize}"
                                   aria-label="Previous">首页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/article/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                            </li>
                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                <li>
                                    <a href="${pageContext.request.contextPath}/article/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                </li>
                            </c:forEach>
                            <li>
                                <a href="${pageContext.request.contextPath}/article/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/article/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
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
