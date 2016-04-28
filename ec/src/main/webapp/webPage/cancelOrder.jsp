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
<title>cancelOrder</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<style>
.span-inline {
	display: inline;
	margin-left: 150px
}

.left {
	float: left;
	width: 15%
}

.tableDiv {
	float: left;;
	width: 70%
}

.right {
	float: right;
	width: 10%;
	font-size: 20px
}
</style>
</head>
<body>
	<div>
		<s:iterator value="allOrderList" var="each_order">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span class="span-inline" style="color: red;width:25%"><s:property
											value="#each_order.orderId" /></span> <span class="span-inline"
										>尺码</span> <span class="span-inline">选购数</span>
									<span class="span-inline">单价(元)</span> <span
										class="span-inline" >金额(元)</span> <span class="span-inline" style="float:right"
										>订单状态</span>
								</h3>
							</div>
							<s:iterator value="#each_order.goodList" var="each_good">
							<div class="panel-body">
								<div class="left">
									<img style="width: 100px; height: 200px"
										src="<s:property value="#each_good.img"/>" />
								</div>
								<!-- Table -->
								<div class="tableDiv">
									<div>
										<span style="font-size: 25px; color: #FF9D6F"><s:property
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
											<s:iterator value="#each_color.detailList"
													var="each_element">
													<tr>
													<th width="17%"><s:property value="#each_color.color" /></th>
												
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
					<div class="right">
						<span style="display: block; margin-bottom: 15px;"><s:property
								value="#each_order.status" /></span>
						<s:if test="#each_order.status=='待支付'"||test="#each_order.status=='待发货'"||test="#each_order.status=='退款中'">
							<span><a onclick="cancelOrder('<s:property value="#each_order.orderId"/>')">取消订单</a></span>
						</s:if>
					</div>
				</div>
				</s:iterator>
			</div>
		</s:iterator>
	</div>
	
	
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
		function cancelOrder(orderId){
				$.post("json/cancelOrder", {
					orderId : orderId
				}, function(data, status) {
					alert(data.resultMessage);
					});
			
		}
	</script>
</body>
</html>