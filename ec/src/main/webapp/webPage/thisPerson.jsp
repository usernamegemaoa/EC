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
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<style type="text/css">
    .infoTable{border-top:1px solid #000;
               height:500px;
               width:500px;}
    .image{ width:90px; 
			height:90px; 
			border-radius:50px; } 	
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserInfo</title>
</head>
<body>

<div id="personInfo" >
	<div style="text-align:center">个人资料</div>
		<div class="infoTable" id="infoTable" style="margin-left:auto;margin-right:auto">
			<div><span class="content1-picture"> <img class="image" src="<s:property value="icon"/>" /> </span> </div>
			<ul class="list-group">
  				<li class="list-group-item"><span class="badge"><s:property value="name"/> </span>昵称</li>
 				<li class="list-group-item"><span class="badge"><s:property value="sex"/></span>性别</li>
  				<li class="list-group-item"><span class="badge"><s:property value="score"/></span>积分</li>
  				<li class="list-group-item"><span class="badge"><s:property value="birthday"/></span>生日</li>
  				<li class="list-group-item"><span class="badge"><s:property value="email"/></span>邮箱</li>
			</ul>
		</div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>