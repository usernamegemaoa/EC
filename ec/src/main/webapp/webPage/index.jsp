<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<base href=" <%=basePath%>">
</head>
<body>
<h1>hello world EC</h1>
<h1><s:property value="path"/></h1>
<a href="regiest">注册</a>
<a href="login">登录</a>
<a href="logout">登出</a>
<h1><a href="Category?kindId=1&page=0">上装</a></h1>
<a href="Search">搜索</a>
<a href="AddGood">添加商品</a>
<a href="personalCenter">个人中心</a>
<a href="AddGood">添加商品</a>
</body>
</html>