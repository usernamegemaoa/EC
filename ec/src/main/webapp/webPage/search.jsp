<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/homepage.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="search">
		<form action="Search" method="post" style="float: right;">
			<input name="search" type="text" style="margin: 0px;" /> 
			<input type="submit" value="搜索" style="margin: 0px;" />
		</form>
	</div>
	<div class="menu" style="height: 30px;">
		<ul class="left-list">
			<li><a href="">主页</a></li>
			<li><a href="">每日上新</a></li>
			<s:iterator value="fatherKinds" id="each_father">
				<li><a href='Category?kindId=<s:property value="#each_father.kindId"/>&page=0'><s:property value="#each_father.name" /></a></li>
			</s:iterator>
			<li><a href="">关于我们</a></li>
			<li><a href="">常见问题</a></li>
		</ul>
		<ul class="right-list">
			<li><s:property value="fatherKind.kindId" /></li>
			
			<li><a href="">用户id</a></li>
			<li><a href="">退出</a></li>
			<li><a href="">我的订单</a></li>
			<li><a href="">个人中心</a></li>
			<li><a href="">进货单</a></li>
		</ul>
	</div>
	<s:if test="goodList.size() > 0">
		<div class="search-div">
			<ul class="search-list">
				<s:iterator value="goodList" id="good">
					<li>
	    			<div class="main-pic">
	    			<img src=<s:property value="#good.img" /> />
	    			</div>
	    			<div class="item-link">
	    			<a href=""><s:property value="#good.name" /></a>
	    			</div>
	    			</li>
				</s:iterator>
			</ul>
		</div>
	</s:if>
	<s:else>
		未找到搜索结果
	</s:else>
</body>
</html>