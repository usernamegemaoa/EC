<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href=" <%=basePath%>">

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<style>
</style>
</head>

<body>

	<div class="container" style="padding-top: 10px;">
		<div class="row">
			<div class="col-sm-12">
				<form id="login-form">
					<div class="form-group">
						<label for="account">账号</label> <input type="text"
							class="form-control" id="account" placeholder="账号" name="account" />
					</div>
					<div class="form-group">
						<label for="password">密码</label> <input type="password"
							class="form-control" id="password" placeholder="密码"
							name="password">
					</div>
					<div class="btn btn-primary" id="login-btn">登录</div>
				</form>
			</div>
		</div>
	</div>


	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js">
		
	</script>
	<script type="text/javascript">
		$("#login-btn").click(
				function() {
					$.post("json/login", $("#login-form").serialize(),
							function(data, status) {
								if (data.code == 0) {
									window.location.href="/ec/";
								} else {
									alert(data.message);									
								}
							});
				});
	</script>

</body>
</html>