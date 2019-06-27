<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"/>
    <title>黑马程序员论坛详情页</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common-new.css"/>
    <link rel="stylesheet" type="text/css" href="../css/index.css"/>
    <link rel="stylesheet" type="text/css" href="../css/search.css"/>
    <link rel="stylesheet" type="text/css" href="../css/detail.css"/>
    <link rel="stylesheet" type="text/css" href="../css/getArticle.css"/>
    <script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../js/hm-bbs.js"></script>
</head>
<body>
<!-- 头部 -->

<jsp:include page="header.jsp"/>


<div class="hm-header"></div>
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">

        <!--帖子标题，点赞数，回复数，搜索-->
        <div class="hm-bbs-info">
            <div class="hm-bbs-icon l" style="width:130px;">
                <span><img src="../images/bbs-icon.png" height="80"/></span>
            </div>
            <div class="hm-bbs-info-in l" style="margin-left:30px;">
                <div class="t clearfix">
                    <h2 class="l">${article.title}</h2>
                    <div class="hm-detail-fun l">
					     <span class="icon-like">
					         <a href="#"><i></i>3</a>
					     </span>
                        <span class="icon-talk">
						     <i></i>${countCommentsAndReplies}
						</span>
                    </div>
                </div>
            </div>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>


        <!--导航，回首页，帖子标题，排序-->
        <div class="detail-page-box clearfix">
            <a href="${pageContext.request.contextPath}/index.jsp">
                <i class="hm-ico-home"></i>首页
            </a>
            <span>></span>
            <a href="#">${article.title}</a>
            <a class="new-to-old r" href="" style="font-size:12px;float: right;">
                <i></i>从新到旧查看
            </a>
        </div>


        <div class="detail-box">
            <ul class="detail-floors">

                <!--原帖楼-->
                <li class="floor clearfix">
                    <div class="floorer-info l">
                        <div class="floorer-photo"><img src="../images/default.png"/></div>
                        <div class="floorer-name">${article.senderName}</div>
                    </div>
                    <div class="floor-con l">
                        <div class="floor-info clearfix">
                            <div class="floor-time l">${article.sendTimeStr}</div>
                            <div class="r">浏览数：${article.browseCount}</div>
                        </div>
                        <div class="floor-art-ans">
                            <div class="floor-art">
                                <p>${article.content}</p>
                            </div>
                            <div class="floor-ans"></div>
                        </div>
                        <span class="icon-comment"><a href="#comment"> <i></i> 评论</a></span>
                    </div>
                </li>


                <%--评论楼--%>
                <c:forEach items="${comments}" var="comment" varStatus="status">
                    <li class="floor clearfix">
                        <div class="floorer-info l">
                            <div class="floorer-photo"><img src="../images/default.png"/></div>
                            <div class="floorer-name">${comment.commentUserName}</div>
                        </div>
                        <div class="floor-con l">
                            <div class="floor-info clearfix">
                                <div class="floor-time l">回贴时间：${comment.commentTimeStr}</div>
                                <div class="r">${status.index + 1}楼</div>
                            </div>
                            <div class="floor-art-ans">
                                <div class="floor-art">
                                    <p>${comment.commentContent}</p>
                                </div>

                                <div class="floor-ans">
                                    <ul>
                                        <c:forEach items="${replies}" var="entrySet">
                                            <c:if test= "${entrySet.key == comment.commentId}">
                                                <c:forEach items="${entrySet.value}" var="reply">
                                                            <!-- 回复部分,楼中楼 -->
                                                            <li class="clearfix">
                                                                <div class="floor-ans-pho l"><img src="../images/default.png"/></div>
                                                                <div class="floor-ans-con l">
                                                                    <span class="name">${reply.replyUserName}</span>：${reply.replyContent}
                                                                    <span class="ans-time">${reply.replyTimeStr}</span>
                                                                </div>
                                                            </li>
                                                </c:forEach>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </div>


                                <span class="icon-feedback">
                                <a href="javascript:;" onclick="showDialog(${status.index + 1},${comment.commentId})"> <i></i> 回复</a>
                            </span>
                            </div>
                        </div>
                    </li>
                </c:forEach>


            </ul>
        </div>

        <!--发表评论-->
        <div class="detail-to-comment">
            <div class="tit"><a name="comment">发表评论</a></div>
            <!-- 未登录时候显示 <div class="con">您没有登录论坛，请登录后再进行回复</div>-->

            <!-- 登录后显示评论输入框-->
            <form action="${pageContext.request.contextPath}/comment/save.do" method="post">
                <div class="con con-loged">
                    <div class="con-t">
                        <textarea id="content" name="commentContent" placeholder="请在此输入您要回复的信息"></textarea>
                    </div>
                    <input type="hidden" name="articleId" value="${article.articleId}">
                    <input type="hidden" name="commentUserName" value="${user.userName}">
                    <div class="con-b">
                        <%--登录后的提交按钮--%>
                        <c:if test= "${user.userName != null}">
                            <input type="submit" class="btn"/>
                        </c:if>
                        <%--未登录的提交按钮--%>
                        <c:if test= "${user.userName == null}">
                            <input id="unLoginCommit" class="btn" value="提交">
                        </c:if>
                        <span class="num">不能超过5000字</span>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>



<!-- 底部 -->
<div class="hm-footer" style="padding-top:10px;">
    <div class="hm-inner">
        <div class="hm-footer-cpr">
            <p>Copyright@2006-2017 ITCAST. All Rights Reserved</p>
            <p>传智播客 版权所有</p>
        </div>
    </div>
</div>



<!-- 回复弹出框 -->
<form action="/reply/save.do" method="post">
    <div class="pop-box ft-box" id="huifu">
        <div class="mask"></div>
        <div class="win">
            <div class="win_hd">
                <h4 class="l">回复<span id="floorSpan"></span>楼</h4>
                <span class="close r">&times;</span>
            </div>
            <div class="win_bd">
                <div class="win_bd_b">
                    <textarea id="replyContent" name="replyContent" placeholder="回复内容限于40字以内"></textarea>
                </div>
            </div>
            <input type="hidden" name="replyUserName" value="${user.userName}">
            <input type="hidden" name="commentId" id="commentId">
            <div class="win_ft">
                <div class="win_ft_in">
                    <%--登录后的提交按钮--%>
                    <c:if test= "${user.userName != null}">
                        <input type="submit" class="btn" value="回复"/>
                    </c:if>
                    <%--未登录的提交按钮--%>
                    <c:if test= "${user.userName == null}">
                        <input id="unLoginReply" class="btn" value="回复">
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- 举报弹出框 -->
<form action="${pageContext.request.contextPath}/report/setReport.do?articleId=${article.articleId}" method="post">
    <div class="pop-box ft-box" id="jubao">
        <div class="mask"></div>
        <div class="win">
            <div class="win_hd">
                <h4 class="l">举报</h4>
                <span class="close r">&times;</span>
            </div>
            <div class="win_bd">
                <div class="win_bd_b">
                    <textarea id="reportContent" name="reportContent" placeholder="回复内容限于400字以内"></textarea>
                </div>
            </div>
            <div class="win_ft">
                <div class="win_ft_in">
                    <input type="submit" class="btn" value="举报"/>
                    <input type="hidden" id="reportUserName" name="reportUserName"/>
                </div>
            </div>
        </div>
    </div>
</form>


<div class="fixedBar" id="j_fixedBar">
    <a href="#comment" class="newTopic"><span></span>评论</a>
    <a href="#" class="goTop"><i></i><span>返回<br/>顶部</span></a>
</div>


</body>

<script type="text/javascript">
    //弹出回复框
    function showDialog(num,commentId) {
        $('#huifu').css('display', 'block');
        $("#commentId").val(commentId);
        $('.pop-box').css('display', 'block');
        $("#floorSpan").html(num);
    }
    $(function () {
        document.getElementById("unLoginCommit").onclick = function () {
            alert("您尚未登录，请先登录后评论")
        }

        document.getElementById("unLoginReply").onclick = function () {
            alert("您尚未登录，请先登录后回复")
        }
    });
    //弹出举报框
    function showReport(num) {
        var user_Name = "${user.userName}";
        var sender_Name = "${article.senderName}";
        if(!user_Name){
            alert("您尚未登录，请先登录后才能举报");
            return;
        }
        if (user_Name == sender_Name){
            alert("不能举报自己的帖子")
            return;
        }
        $("#jubao").css('display', 'block');
    }
</script>
</html>