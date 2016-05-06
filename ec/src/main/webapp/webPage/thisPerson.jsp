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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<style type="text/css">
.infoTable {
	border-top: 1px solid #000;
	height: 500px;
	width: 500px;
}

.image {
	width: 90px;
	height: 90px;
	border-radius: 50px;
}

.input {
	margin-top: 10px float: right;
	border: 1;
	width: 200px
}
</style>

<title>UserInfo</title>
</head>
<body>
	<div>


		<div id="personInfo">
			<div style="text-align: center; font-size: 40px">个人资料</div>
			<div class="infoTable" id="infoTable"
				style="margin-left: auto; margin-right: auto">
				<div>
					<s:if test='icon=="img/a.jpg"'>
						<span class="content1-picture"> <img class="image"
							src="img/icon.jpeg" />
						</span>
					</s:if>
					<s:else>
						<span class="content1-picture"> <img class="image"
							src="<s:property value="icon"/>" />
						</span>
					</s:else>
				</div>
				<ul class="list-group">
					<li class="list-group-item"><span class="badge"><s:property
								value="name" /> </span>昵称</li>
					<li class="list-group-item"><span class="badge"><s:property
								value="sex" /></span>性别</li>
					<li class="list-group-item"><span class="badge"><s:property
								value="score" /></span>积分</li>
					<li class="list-group-item"><span class="badge"><s:property
								value="birthday" /></span>生日</li>
					<li class="list-group-item"><span class="badge"><s:property
								value="email" /></span>邮箱</li>
				</ul>
				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal">
					编辑个人资料<span class="glyphicon glyphicon-chevron-right"></span>
				</button>

				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog  bs-example-modal-sm" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="myModalLabel">编辑个人资料</h4>
							</div>
							<div class="modal-body">
								<form action="modifyInfo" method="POST" id="info-form"
									enctype="multipart/form-data">
									<ul>
										<div class="form-group">
											<label for="name">昵称</label> <input type="text"
												class="form-control" id="name"
												value="<s:property
							value="name" /> " name="name">
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
											<label for="name">邮箱</label> <input type="text"
												class="form-control" id="email"
												value="<s:property
							value="email" /> " name="email">
										</div>
										<div class="form-group ">
											<label for="birth">生日</label>
											<div class="input-append date datetimepicker" id="birthday"
												data-date="2000-01-01" data-date-format="yyyy-mm-dd">
												<input class="form-control" size="16" type="text"
													value="<s:property
								value="birthday" />"
													name="birthday"> <span class="add-on"><i
													class="icon-th"></i></span>
											</div>
										</div>
										<div class="form-group">
											<label for="mainphoto">上传头像</label> <input type="file"
												id="mainphoto" name="mainpic" aria-describedby="mainhelp">
											<span id="mainhelp" class="help-block"></span>
										</div>
									</ul>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal" id="cancelAdd">取消</button>
								<button type="button" class="btn btn-primary" id="save">提交</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="//cdn.bootcss.com/moment.js/2.10.0/moment.min.js"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/locales/bootstrap-datetimepicker.zh-CN.js"
		type="text/javascript" charset="UTF-8">
		
	</script>
	<script type="text/javascript">
		$(".datetimepicker").datetimepicker({
			language : 'zh-CN'
		});

		$('#save').click(function() {
			$("#info-form").submit();
		});

		$("#cancelAdd").click(
				function() {
					$('#myModal').modal('hide');
					$(':input', '#info-form').not(
							':button, :submit, :reset, :hidden').val('')
							.removeAttr('checked').removeAttr('selected');

				})
	</script>
</body>
</html>