<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<body>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>黑马程序员论坛首页</title>
    <link rel="stylesheet" href="../css/common.css"/>
    <link rel="stylesheet" href="../css/common-new.css"/>
    <link rel="stylesheet" href="../css/user_info.css"/>
    <link rel="stylesheet" href="../css/search.css"/>
    <script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../js/hm-bbs.js"></script>
    <style type="text/css">
        .hm-header-b { border-bottom: 1px solid #d9d9d9; }
    </style>
</head>


<!--头部信息-->
<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="../images/logo.png" alt=""/></a>
            </h1>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="/index.jsp">首页</a><span>></span>修改密码
        </div>
    </div>
</div>

<!--修改密码-->
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="user-info clearfix">
            <div class="user-info-t" style="height:20px;"></div>

            <!--左侧用户名，头像-->
            <div class="user-info-l l">
                <div class="user-info-l-t">
                    <img src="${user.picUrl}"/>
                    <div class="username">${user.userName}</div>
                </div>
                <ul class="user-info-l-b">
                    <li><i class="info-icon"></i>我的资料</li>
                    <li class="cur"><i class="safe-icon"></i>修改密码</li>
                    <c:if test="${user.role==1}"><li><i class="safe-icon"></i>申请高级用户</c:if>
                    <c:if test="${user.role==2}"> <li><i class="safe-icon"></i>开辟新板块</li></c:if>
                </ul>
            </div>

            <!--右侧用户信息-->
            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li><a href="user_info.jsp">个人信息</a></li>
                    <li class="cur"><a href="user_pwd.jsp">修改密码</a></li>
                    <c:if test="${user.role==1}"><li><a href="user_upgrade.jsp">申请高级用户</a></li></c:if>
                    <c:if test="${user.role==2}"><li><a href="user_upgrade.jsp">开辟新板块</a></li></c:if>

                </ul>
                <form action="${pageContext.request.contextPath}/user/updatePassWord.do" method="post" >
                    <ul class="bd">
                        <li class="clearfix">
                            <div class="info-l"><i class="red">*</i>旧密码：</div>
                            <div class="info-r"><input type="password" name="oldPassword" class="txt"/></div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l"><i class="red">*</i>新密码：</div>
                            <div class="info-r"><input type="password" name="newPassword" class="txt"/></div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l"></div>
                            <div class="info-r">
                                <input type="submit" class="btn" value="保存"/>
                                <div>${result}</div>
                                <%--<span style="color:red;">修改成功！</span>--%>
                            </div>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- 底部 -->
<jsp:include page="/common/footer.jsp"/>

</body>
</html>