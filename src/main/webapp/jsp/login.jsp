<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%String root = request.getContextPath();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>宁波-舟山核心港区仿真模拟系统</title>
    <link href="<%=root %>/image/favicon.ico" rel="shortcut icon">
    <link href="<%=root %>/css/themes/css/login.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div id="login">
    <div id="login_header">
        <h1 class="login_logo">
            <%--<a href="https://github.com/Liuxboy/HarbourSimulation" target="_blank">
                <img src="../css/themes/default/images/login_logo.jpg"/>
            </a>--%>
        </h1>

        <div class="login_headerContent">
            <div class="navList">
                <ul>
                    <li></li>
                </ul>
            </div>
            <h2 class="login_title">
                <img src="<%=root %>/css/themes/default/images/login_title1.png"/>
            </h2>
        </div>
    </div>
    <div id="login_content">
        <div class="loginForm">
            <form action="<%=root %>/harbour/login" method="post">
                <p align="center">
                   <font color="red"> ${message}</font>
                </p>
                <p>
                    <label>用户名：</label>
                    <input type="text" name="userName" size="20" value="${user.userName}" class="login_input"/>
                </p>
                <p>
                    <label>密码：</label>
                    <input type="password" name="passWord" size="20" class="login_input"/>
                </p>
                <div class="login_bar">
                    <input class="sub" type="submit" value=""/>
                </div>
            </form>
        </div>
        <div class="login_banner"><img src="<%=root %>/css/themes/default/images/login_banner2.png"/></div>
        <div class="login_main">
            <ul class="helpList">
                <li><a href="#">忘记密码怎么办？</a></li>
                <li><a href="#">为什么登录失败？</a></li>
            </ul>
            <%--<div class="login_inner">
                <p>XXXXXX</p>
                <p>XXXXXX</p>
                <p>XXXXXX</p>
            </div>--%>
        </div>
    </div>
    <div id="login_footer">
        Copyright &copy; 2016 https://github.com/Liuxboy. All Rights Reserved.
    </div>
</div>
</body>
</html>