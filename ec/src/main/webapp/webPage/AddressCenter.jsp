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
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.addressDiv {
	margin-top: 20px;
	width: 800px;
	height: 220px;
	border: 1px solid #F0F0F0;
}
</style>

<title>AddressCenter</title>
</head>
<body>

	<div>
		<button type="button" class="btn btn-primary btn-lg"
			data-toggle="modal" data-target="#myModal">
			添加收货地址<span class="glyphicon glyphicon-chevron-right"></span>
		</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog  bs-example-modal-sm" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">添加收货地址</h4>
					</div>
					<div class="modal-body">
						<form action="AddAddressForm" method="POST" id="address-form">
							<ul class="list-group">
								<li class="list-group-item form-group">收货人<input
									type="text" placeholder="请输入收货人姓名"
									style="float: right; border: 0; width: 200px" name="people"
									id="people"></input></li>
								<li class="list-group-item form-group">电话<input type="text"
									placeholder="请输入收货人电话"
									style="float: right; border: 0; width: 200px" name="phone"
									id="phone"></input></li>
								<li class="list-group-item form-group">邮编<input type="text"
									placeholder="请输入地址邮编"
									style="float: right; border: 0; width: 200px" name="placeCode"
									id="placeCode"></input></li>
							</ul>
							<div class="form-group">
								<label for="provinceList">省份</label> <select
									class="form-control" id="provinceList" name="province">
									<s:iterator value="provinceList" var="each_province">
										<option value='<s:property value="#each_province.placeCode"/>'><s:property
												value="#each_province.placeName" /></option>
									</s:iterator>
								</select>
							</div>
							<div class="form-group">
								<label for="cityList">城市</label> <select class="form-control"
									id="cityList" name="city">
									<s:iterator value="cityList" id="each_city">
										<option value='<s:property value="#each_city.placeCode"/>'><s:property
												value="#each_city.placeName" /></option>
									</s:iterator>
								</select>
							</div>
							<div class="form-group">
								<label for="districtList">区县</label> <select
									class="form-control" id="districtList" name="district">
									<s:iterator value="districtList" id="each_district">
										<option value='<s:property value="#each_district.placeCode"/>'><s:property
												value="#each_district.placeName" /></option>
									</s:iterator>
								</select>
							</div>
							<li class="list-group-item form-group">地址<input type="text"
								placeholder="请输入具体地址"
								style="float: right; border: 0; width: 250px" id="place"></input></li>
						</form>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							id="cancelAdd">取消</button>
						<button type="button" class="btn btn-primary" id="save">保存</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<s:iterator value="addressList" var="each_address">
		<div class="addressDiv">
			<ul class="list-group">
				<li class="list-group-item"><span class="badge"><s:property
							value="#each_address.people" /> </span>收货人</li>
				<li class="list-group-item"><span class="badge"><s:property
							value="#each_address.phone" /></span>电话</li>
				<li class="list-group-item"><span class="badge"><s:property
							value="#each_address.placeCode" /></span>邮编</li>
				<li class="list-group-item"><span class="badge"><s:property
							value="#each_address.placeName" /></span>地址</li>
			</ul>
			<div>
				<button type="button" class="btn btn-primary" style="float: right"
					data-toggle="button" aria-pressed="false" autocomplete="off"
					onclick="deleteAdd('#each_address.id')">删除</button>
			</div>
		</div>
	</s:iterator>



	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
		$('#save').click(
				function() {
					var provinceName = $("#provinceList option:selected")
							.text();
					var cityName = $("#cityList option:selected").text();
					var districtName = $("#districtList option:selected")
							.text();
					var place = $("#place").val();
					var placeName = provinceName + cityName + districtName
							+ place;
					$("#address-form")
							.append(
									$("<input name='placeName'>")
											.val(placeName).hide());
					console.log($("#address-form"));
					$("#address-form").submit();

				})

		$("#cancelAdd").click(
				function() {
					$('#myModal').modal('hide');
					$(':input', '#address-form').not(
							':button, :submit, :reset, :hidden').val('')
							.removeAttr('checked').removeAttr('selected');

				})

		$("#provinceList").change(function() {
			var provinceId = $(this).val();
			$.post("json/getCity", {
				provinceId : provinceId
			}, function(data, status) {
				$("#cityList").empty();
				$("#districtList").empty();
				$(data.cityList).each(function() {
					var option = $("<option></option>");
					option.text(this.placeName);
					option.val(this.placeCode);
					$("#cityList").append(option);
				});
				$(data.districtList).each(function() {
					var option = $("<option></option>");
					option.text(this.placeName);
					option.val(this.placeCode);
					$("#districtList").append(option);
				});
			});
		});

		$("#cityList").change(function() {
			var cityId = $(this).val();
			$.post("json/getDistrict", {
				cityId : cityId
			}, function(data, status) {
				$("#districtList").empty();
				$(data.districtList).each(function() {
					var option = $("<option></option>");
					option.text(this.placeName);
					option.val(this.placeCode);
					$("#districtList").append(option);
				});
			});
		});
	</script>
</body>
</html>