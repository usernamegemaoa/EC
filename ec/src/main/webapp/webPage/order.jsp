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
<base href=" <%=basePath%>">
<title>订单详情</title>
</head>
<body>

	<h4>收货人信息</h4>
	<hr />
	<s:iterator value="userVo.addressVoList" var="each_address">
		<div class="radio">
			<label> <input type="radio" name="addressId"
				value="<s:property value="#each_address.id" />"> <span><s:property
						value="#each_address.people" /></span> <span><s:property
						value="#each_address.phone" /></span> <span><s:property
						value="#each_address.placeName" /></span>
			</label>
		</div>
	</s:iterator>

	<h4>送货清单</h4>
	<hr />

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<span class="span-inline" style="color: red; margin-left: 15px"><s:property
						value="element.orderId" /></span> <span class="span-inline"
					style="margin-left: 280px">尺码</span> <span class="span-inline">选购数</span>
				<span class="span-inline">单价(元)</span> <span class="span-inline">金额(元)</span>
			</h3>
		</div>
		<div class="panel-body">
			<s:iterator value="element.goodList" var="each_good">
				<div class="left">
					<img style="width: 100px; height: 200px"
						src="<s:property value="#each_good.img"/>" />
				</div>
				<!-- Table -->
				<div class="tableDiv">
					<div>
						<span style="font-size: 30px"><s:property
								value="#each_good.name" /></span>
					</div>
					<table class="table" border=0>
						<tr>
							<th width="17%">颜色</th>
							<th width="19%">尺码</th>
							<th width="22%">选购数</th>
							<th width="20%">单价(元)</th>
							<th width="20%">金额(元)</th>
						</tr>

						<s:iterator value="#each_good.colorList" var="each_color">
							<s:iterator value="#each_color.detailList" var="each_element" status="L">
								<tr>
									<s:if test="#L.index==0">
										<th width="17%"
											rowspan='<s:property value="#each_color.detailList.size"/>'><s:property
												value="#each_color.color" /></th>
									</s:if>
									<th width="19%"><s:property value="#each_element.size" /></th>
									<th width="22%"><s:property value="#each_element.num" /></th>
									<th width="20%"><s:property
											value="#each_element.unitPrice" /></th>
									<th width="20%"><s:property
											value="#each_element.totalPrice" /></th>
								</tr>
							</s:iterator>
						</s:iterator>
					</table>
				</div>
			</s:iterator>
		</div>
	</div>

	<h4>订单统计</h4>
	<hr />
	<dl class="dl-horizontal">
		<dt>货品种类</dt>
		<dd>
			<s:property value="element.goodList.size" />
		</dd>
	</dl>
	<dl class="dl-horizontal">
		<dt>数量总计</dt>
		<dd>
			<s:property value="element.totalNum" />
			件
		</dd>
	</dl>
	<dl class="dl-horizontal">
		<dt>应付总额</dt>
		<dd>
			<s:property value="element.totalPrice" />
			元
		</dd>
	</dl>

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
		
	</script>
</body>
</html>