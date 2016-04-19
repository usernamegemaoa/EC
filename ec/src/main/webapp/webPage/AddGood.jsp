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
<title>添加商品</title>
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

				<form action="AddGoodForm" method="POST"
					enctype="multipart/form-data" id="good-form">
					<div class="form-group">
						<label for="name">商品名</label> <input type="text"
							class="form-control" id="name" placeholder="商品名" name="name">
					</div>
					<div class="form-group">
						<label for="number">货号</label> <input type="text"
							class="form-control" id="number" placeholder="货号" name="number">
					</div>
					<div class="form-group">
						<label for="price">单价</label> <input type="number"
							class="form-control" id="price" placeholder="单价" name="price">
					</div>
					<div class="form-group">
						<label for="fatherkind">分类</label> <select class="form-control"
							id="fatherkind" name="father">
							<s:iterator value="fatherKind" id="each_father">
								<option value='<s:property value="#each_father.kindId"/>'><s:property
										value="#each_father.name" /></option>
							</s:iterator>
						</select>
					</div>
					<div class="form-group">
						<label for="sonkind">子类</label> <select class="form-control"
							id="sonkind" name="son">
							<s:iterator value="sonKind" id="each_son">
								<option value='<s:property value="#each_son.kindId"/>'><s:property
										value="#each_son.name" /></option>
							</s:iterator>
						</select>
					</div>
					<div class="form-group">
						<label for="photos">图片列表</label> <input type="file" multiple
							id="photos" name="upload" aria-describedby="photohelp"> <span
							id="photohelp" class="help-block">可以一次上传多个文件</span>
					</div>
					<div class="form-group">
						<label>库存信息</label>
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>尺寸</th>
									<th>颜色</th>
									<th>数量</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
							<tfoot>
								<tr class="add-row">
									<th></th>
									<th><button type="button" class="btn btn-info btn-xs"
											id="add-stock">添加新库存</button></th>
									<th></th>
									<th></th>
									<th></th>
								</tr>
							</tfoot>
						</table>
					</div>
					<div class="form-group">
						<label for="description">商品描述</label>
						<textarea class="form-control" id="description" placeholder="商品描述"
							rows="5" name="description"></textarea>
					</div>
					<div class="form-group">
						<label for="deliverInfo">送货信息</label>
						<textarea class="form-control" id="deliverInfo" placeholder="送货信息"
							rows="5" name="deliverInfo"></textarea>
					</div>
					<div class="form-group">
						<label for="returnInfo">退货信息</label>
						<textarea class="form-control" id="returnInfo" placeholder="退货信息"
							rows="5" name="returnInfo"></textarea>
					</div>
					<div class="btn btn-primary" id="add-good">添加商品</div>
				</form>
			</div>
		</div>
	</div>

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script src="js/edit.js"></script>
	<script>
		//添加新库存
		$("#add-stock")
				.click(
						function() {
							var newrow = '<tr><th></th><td>尺寸</td><td>颜色</td><td>0</td><th class="del-stock"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></th></tr>';
							$(".table tbody").append(newrow);
							updateTableId();
						});

		//删除库存
		$(document).on("click", ".del-stock", function() {
			$(this).parent().remove();
			updateTableId();
		});

		function updateTableId() {
			$(".table tbody tr").each(function(index, element) {
				$(this).children("th:first").text(index + 1);
			});
			$('.table').editableTableWidget();
		}

		$("#add-good").click(
				function() {
					$(".table tbody tr")
							.each(
									function() {
										var size = $(this).children("td:eq(0)")
												.text();
										var color = $(this)
												.children("td:eq(1)").text();
										var quantity = $(this).children(
												"td:eq(2)").text();
										$("#good-form").append(
												$("<input name='size'>").val(
														size).hide());
										$("#good-form").append(
												$("<input name='color'>").val(
														color).hide());
										$("#good-form").append(
												$("<input name='quantity'>")
														.val(quantity).hide());
									});
					$("#good-form").submit();
				});

		$("#fatherkind").change(function() {
			var fatherId = $(this).val();
			$.post("json/getSon", {
				father : fatherId
			}, function(data, status) {
				$("#sonkind").empty();
				$(data.sonList).each(function() {
					var option = $("<option></option>");
					option.text(this.name);
					option.val(this.kindId);
					$("#sonkind").append(option);
				});
			});
		});

		function IsNum(s) {
			if (s != null) {
				var r, re;
				re = /\d*/i; //\d表示数字,*表示匹配多个数字
				r = s.match(re);
				return (r == s) ? true : false;
			}
			return false;
		}

		$(document).on('validate', 'table td', function(evt, newValue) {
			if ($(this)[0].cellIndex == 3) {
				console.log($(this).text());
				return IsNum(newValue);
			}
		});
	</script>
</body>

</html>