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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>changePassword</title>
</head>
<body>
<div>
	<div class="input-group" style="margin-left:70px">
  		<span class="input-group-addon" id="basic-addon1">旧密码</span>
  		<input type="password" class="form-control" style="width:200px" id="oldPassword"  >
  		<span id="alert1" style="color:red"></span>
	</div>

	<div class="input-group" style="margin-top:20px;margin-left:70px">
		<span class="input-group-addon" id="basic-addon2">新密码</span>
  		<input type="password" class="form-control" style="width:200px" id="newPassword1" >
  		<span id="alert2" style="color:red"></span>
	</div>

	<div class="input-group" style="margin-top:20px">
  		<span class="input-group-addon">再输入一次新密码</span>
  		<input type="password" class="form-control" id="newPassword2"   style="width:200px" >
  		<span id="alert3" style="color:red"></span>
	</div>
	
	<div style="margin-top:20px">
	<button type="button" class="btn btn-primary" style="width:200px;margin-left:100px" data-toggle="button" aria-pressed="false" autocomplete="off" onclick="validate()">
  	确认
	</button></div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function validate(){
		$("#alert1").empty;
		$("#alert2").empty;
		$("#alert3").empty;
		var success=false;
		var oldpassword=$("#oldPassword").val();
		var newpassword1=$("#newPassword1").val();
		var newpassword2=$("#newPassword2").val();
		if(oldpassword==""){
			$("#alert1").html("请输入密码");
		}
		else if(newpassword1==""){
			$("#alert2").html("请输入新密码");
		}
		else if(newpassword2==""){
			$("#alert3").html("请再次输入新密码");
		}
		else if(newpassword1!=newpassword2){
			$("#alert3").html("两次输入密码不相同");
		}
		else
			success=true;
		if(success){
		$.post("json/changePassword",{oldPassword: oldpassword, newPassword1: newpassword1, newPassword2:newpassword2},
            function (data,status) {//ajax请求完成时执行，result为返回的结果
                alert(data.resultMessage);
            })
		}
	}
	
	$(function () {
		  $('[data-toggle="popover"]').popover()
		})
</script>
</body>
</html>