<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛</title>
    <link rel="stylesheet" href="../css/common.css"/>
    <link rel="stylesheet" href="../css/common-new.css"/>
    <link rel="stylesheet" href="../css/index.css"/>
    <link rel="stylesheet" href="../css/search.css"/>
    <link rel="stylesheet" href="../css/index-new.css"/>
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="../js/hm-bbs.js"></script>
</head>
<body>

<jsp:include page="header.jsp"/>

<!-- 主体部分 -->
<div class="hm-header"></div>
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="hm-banner"></div>



        <!--头部，帖子统计，搜索-->
        <div class="hm-bbs-info">
            <div class="hm-bbs-icon l" style="width:130px;">
                <span><img src="../images/bbs-icon.png" height="80"/></span>
            </div>
            <div class="hm-bbs-info-in l" style="margin-left:30px;">
                <div class="t clearfix"><h2 class="l">王者荣耀</h2></div>
                <p>
                    <span>今日帖子<strong>99</strong></span>
                    <span>全部帖子<strong>250</strong></span>
                </p>
            </div>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>



        <!-- 导航 -->
        <ul class="hm-bbs-nav border-lrb clearfix">
            <c:forEach items="${zones}" var="zone">

                <li <c:if test= "${zone.zoneId == currentZoneId}">class="current"</c:if> >
                    <a href=/article/findArticlesByZoneId.do?zoneId=${zone.zoneId}><em></em>${zone.zoneName}</a>
                </li>
            </c:forEach>
        </ul>

        <!-- 主体部分 -->
        <div class="hm-bbs-main border-lrb clearfix">
            <!-- 左侧列表 -->
            <div class="list-view l">
                <%--展示置顶帖子--%>
                <c:forEach items="${articles}" var="article">
                    <c:if test= "${article.isTop == '1'}">
                        <li class="clearfix ding">
                            <div class="hm-index-title">
                                <i class="set-to-top">顶</i> <a href=/article/findByArticleId.do?articleId=${article.articleId}>${article.title}</a>
                            </div>
                            <div class="hm-index-con">${article.content}</div>
                            <div class="hm-index-info l">
                                <span class="article-username">${article.senderName}</span>
                                <span class="post-time">${article.sendTimeStr}</span>
                            </div>
                            <div class="hm-index-fun r">
                                <span class="icon-like"><i></i>${article.upvoteCount}</span>
                                <span class="icon-talk"><i></i>${article.replyCount}</span>
                            </div>
                        </li>
                    </c:if>
                </c:forEach>
                <%--展示普通帖子--%>
                <c:forEach items="${articles}" var="article">
                    <c:if test="${article.isTop == '0'}">
                        <li class="clearfix">
                            <div class="hm-index-title">
                                <i class="set-to-top">顶</i> <a href=/article/findByArticleId.do?articleId=${article.articleId}>${article.title}</a>
                            </div>
                            <div class="hm-index-con">${article.content}</div>
                            <div class="hm-index-info l">
                                <span class="article-username">${article.senderName}</span>
                                <span class="post-time">${article.sendTimeStr}</span>
                            </div>
                            <div class="hm-index-fun r">
                                <span class="icon-like"><i></i>${article.upvoteCount}</span>
                                <span class="icon-talk"><i></i>${article.replyCount}</span>
                            </div>
                    </c:if>
                </c:forEach>
            </div>

            <!-- 右侧侧边栏,在线用户 -->
            <div class="aside l">
                <div class="aside-box">
                    <h3 class="t">
                        <a href="javascript:;">在线用户(2)</a>
                    </h3>
                    <ul class="b clearfix">
                        <li>
                            <div><img src="../images/default.png" height="55"/> </div>
                            <p>Mr.King</p>
                        </li>
                        <li>
                            <div><img src="../images/default.png" height="55"/></div>
                            <p>疯子</p>
                        </li>
                    </ul>
                </div>
            </div>

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

<!-- 右边发帖，回顶部 -->
<div class="fixedBar" id="j_fixedBar">
    <a id="newTopicBtn" href="javascript:;" class="newTopic"><span></span>发帖</a>
    <a href="#" class="goTop"><i></i><span>返回<br/>顶部</span></a>
</div>

<!-- 发帖弹出框 -->
<form action="${pageContext.request.contextPath}/article/save.do" method="post">
    <div class="pop-box ft-box">
        <div class="mask"></div>
        <div class="win">
            <div class="win_hd">
                <h4 class="l">主题帖</h4><span class="close r">&times;</span>
            </div>
            <div class="win_bd">
                <div class="win_bd_t">
                    <input type="text" id="title" name="title" placeholder="帖子标题"/>
                </div>
                <div class="win_bd_b">
                    <textarea id="content" name="content" placeholder="正文"></textarea>
                </div>
            </div>
            <div class="win_ft">
                <div class="win_ft_in">
                    <input type="submit" class="btn" value="发表"/>
                </div>
            </div>
        </div>
    </div>
</form>


</body>
</html>
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

        //查询用户是否登录
        $.post("user/findUser.do",{},function(data){

            alert(data);
        })
    });
</script>

</body>
</html>
