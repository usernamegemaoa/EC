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
<style type="text/css">
.pic {
	float: left;
	width: 15%;
}

.img {
	width: 100px;
	height: 200px
}

.content {
	float: left;
	width: 60%;
}

.right {
	float: right;
	margin-right: 150px;
	width: 10%
}
</style>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Favourite</title>
</head>
<body>
	<s:if test="favouriteGoodList.size==0">
		<div style="text-align: center; font-size: 60px">
			您还没有任何收藏商品，赶紧去收藏哦！</div>
	</s:if>
	<s:iterator value="favouriteGoodList" var="each_favourite">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<s:property value="#each_favourite.goodId" />
				</h3>
			</div>
			<div class="panel-body">
				<div class="pic">
					<img class="img"
						src="<s:property value="#each_favourite.mainPic"/>" />
				</div>
				<div class="content">
					<table class="table" border=1>
						<tr>
							<td>商品名</td>
							<td>单价</td>
							<td>商品描述</td>
						</tr>
						<tr>
							<td><s:property value="#each_favourite.name" /></td>
							<td><s:property value="#each_favourite.price" /></td>
							<td><s:property value="#each_favourite.description" /></td>
						</tr>
					</table>

				</div>
				<div class="right">
					<button type="button" class="btn btn-primary btn-lg"
						onclick="getInfo('<s:property value="#each_favourite.goodId"/>')">
						查看商品详情<span class="glyphicon glyphicon-chevron-right"></span>
					</button>
					<button type="button" class="btn btn-primary btn-lg"
						onclick="unfavour'<s:property value="#each_favourite.goodId"/>')">
						取消收藏</button>
				</div>
			</div>

		</div>

	</s:iterator>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
		function getInfo(goodId) {
			$.post("getGoodInfo", {
				goodId : goodId
			}, function(data, status) {
				alert(data.resultMessage);
			});
		}
	
		function unfavour(goodId) {
			$.post("json/unfavour", {
				goodId : goodId
			}, function(data, status) {
				alert(data.resultMessage);
			});
		}
		
	</script>
</body>
</html>