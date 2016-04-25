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
<title>注册用户</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href=" <%=basePath%>">

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">

<style>
</style>
</head>

<body>

	<div class="container" style="padding-top: 10px;">
		<div class="row">
			<div class="col-sm-12">
				<form id="regist-form">
					<div class="form-group">
						<label for="account">账号</label> <input type="text"
							class="form-control" id="account" placeholder="账号" name="account" />
					</div>
					<div class="form-group">
						<label for="pw1">密码</label> <input type="password"
							class="form-control" id="pw1" placeholder="密码" name="pw1">
					</div>
					<div class="form-group">
						<label for="pw2">重复密码</label> <input type="password"
							class="form-control" id="pw2" placeholder="重复密码" name="pw2">
					</div>
					<div class="form-group">
						<label for="name">姓名</label> <input type="text"
							class="form-control" id="name" placeholder="姓名" name="name">
					</div>
					<div class="form-group">
						<label for="email">邮箱</label> <input type="text"
							class="form-control" id="email" placeholder="email@example.com"
							name="email">
					</div>
					<div class="form-group ">
						<label for="birth">生日</label>
						<div class="input-append date datetimepicker" id="birth"
							data-date="2000-01-01" data-date-format="yyyy-mm-dd">
							<input class="form-control" size="16" type="text" value="2000-01-01" name="birth">
							<span class="add-on"><i class="icon-th"></i></span>
						</div>
					</div>
					<div class="form-group">
						<label for="sex0">性别</label> <label class="radio-inline">
							<input type="radio" name="male" id="sex0" value="0" checked>
							男
						</label> <label class="radio-inline"> <input type="radio"
							name="male" id="sex1" value="1"> 女
						</label>
					</div>
					<div class="form-group">
						<label for="role1">身份</label> <label class="radio-inline">
							<input type="radio" name="role" id="role1" value="1" checked>
							顾客
						</label> <label class="radio-inline"> <input type="radio"
							name="role" id="role2" value="2"> 店家
						</label>
					</div>
					<div class="btn btn-primary" id="regiest-btn">注册</div>
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
	<script src="//cdn.bootcss.com/moment.js/2.10.0/moment.min.js"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" charset="UTF-8">
	</script>
	<script type="text/javascript">
		$(".datetimepicker").datetimepicker({
			language: 'zh-CN'
		});
		
		$("#regiest-btn").click(
				function() {
					$.post("json/regiest", $("#regist-form").serialize(),
							function(data, status) {
								alert(data.message);
							});
				});
	</script>

</body>
</html>