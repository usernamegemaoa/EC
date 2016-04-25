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
<title>MyOrder</title>
</head>
<body>
<div>
	<div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">旧密码</span>
  		<input type="password" class="form-control" style="width:200px" id="oldPassword"  >
	</div>

	<div class="input-group" style="margin-top:20px">
		<span class="input-group-addon" id="basic-addon2">新密码</span>
  		<input type="password" class="form-control" style="width:200px" id="newPassword1" >
	</div>

	<div class="input-group" style="margin-top:20px">
  		<span class="input-group-addon">再输入一次新密码</span>
  		<input type="password" class="form-control" id="newPassword2"   style="width:200px" >
	</div>
	
	<div style="margin-top:20px">
	<button type="button" class="btn btn-primary" data-toggle="button" aria-pressed="false" autocomplete="off" onclick="validate()">
  	确认
	</button></div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function validate(){
		var oldpassword=$("#oldPassword").val();
		var newpassword1=$("#newPassword1").val();
		var newpassword2=$("#newPassword2").val();
		if(oldpassword==""){
			alert("请输入旧密码");
		}
		else if(newpassword1==""){
			alert("请输入新密码");
		}
		else if(newpassword2==""){
			alert("请输入第二次密码");
		}
		else if(newpassword1!=newpassword2){
			alert("两次密码不相同")
		}
		$.ajax({
            url: 'UserAction!changePassword',//ajax提交路径
            type: 'post',//提交方式
            data: { oldPassword: oldpassword, newPassword1: newpassword1, newPassword2:newpassword2},//提交参数
            success: function (result) {//ajax请求完成时执行，result为返回的结果
                alert(result);
            },
            error: function () {
                alert("ajax请求处理错误");
            }
        });

	}
	
	$(function () {
		  $('[data-toggle="popover"]').popover()
		})
</script>
</body>
</html>