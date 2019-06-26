<%@ page language="java"   isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>王者荣耀论坛管理系统</title>
    <style type="text/css">
        .modal-title {
            color: deepskyblue;
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

        <!-- 中间 敏感词汇数据内容内容 -->
        <div class="hrms_main_ad col-sm-10">
            <div class="panel panel-success">
                <ol class="breadcrumb">
                    <li><a href="#">用户帖子管理</a></li>
                    <li class="active">敏感词汇管理</li>
                </ol>

                <hr>
                <%--工具栏--%>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    新增敏感词汇
                </button>
                <form action="/word/saveByWord.do">
                    <div id="myModal" class="modal modal-primary" role="dialog">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">新的敏感词:</h4>
                                    <br>
                                    <input name="word" type="text" class="form-control" placeholder="请输入要增加的敏感词汇..">
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-outline" data-dismiss="modal">关闭</button>
                                        <button type="submit" class="btn btn-outline" >保存</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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
                                <c:if test="${words.status==0}">
                                    <a href="${pageContext.request.contextPath}/word/updateBywordId.do?wordId=${words.wordId}&status=${words.status}"
                                       class="btn btn-info btn-xs">启用</a>
                                </c:if>
                                <c:if test="${words.status==1}">
                                    <a href="${pageContext.request.contextPath}/word/updateBywordId.do?wordId=${words.wordId}&status=${words.status}"
                                       class="btn btn-danger btn-xs">停用</a>
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
                                <a href="${pageContext.request.contextPath}/word/findAll.do?page=1&size=${pageInfo.pageSize}"
                                   aria-label="Previous">首页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                            </li>
                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                <li>
                                    <a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                </li>
                            </c:forEach>
                            <li>
                                <a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
                                   aria-label="Next">尾页</a>
                            </li>
                        </ul>
                    </div>
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
