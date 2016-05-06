<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="search">
	<form action="Search" method="post" style="float: right;">
		<input name="search" type="text" style="margin: 0px;" /> <input
			type="submit" value="搜索" style="margin: 0px;" />
	</form>
</div>
<div class="menu" style="height: 30px;">
	<ul class="left-list">
		<li><a href="./">主页</a></li>
		<s:iterator value="fatherKinds" id="each_father">
			<li><a
				href='Category?kindId=<s:property value="#each_father.kindId"/>&page=0'><s:property
						value="#each_father.name" /></a></li>
		</s:iterator>
	</ul>
	<ul class="right-list">
		<s:if test='headuserId==0'>
			<li><a href="login">登录</a></li>
			<li><a href="regiest">注册</a></li>
		</s:if>
		<s:else>
			<li><s:property value="headuserName" /></li>
			<li><a href="logout">退出</a></li>
			<li><a href="personalCenter">个人中心</a></li>
			<li><a href="myCast">进货单</a></li>
		</s:else>
	</ul>
</div>