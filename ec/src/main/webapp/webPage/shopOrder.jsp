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
.span-inline {
	display: inline-block;
	width: 14%
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
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>shopOrder</title>
</head>
<body>
	<div>
		<div id="showFrame">

			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#allOrder"
					aria-controls="allOrder" role="tab" data-toggle="tab">所有订单<span
						class="badge"><s:property value="allOrderList.size" /></span></a></li>
				<li role="presentation"><a href="#waitSend"
					aria-controls="waitSend" role="tab" data-toggle="tab">待发货<span
						class="badge"><s:property value="waitSendOrderList.size" /></span></a></li>
				<li role="presentation"><a href="#refund"
					aria-controls="refund" role="tab" data-toggle="tab">退款中<span
						class="badge"><s:property value="refundOrderList.size" /></span></a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="allOrder">
					<s:iterator value="allOrderList" var="each_order">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									订单号
									<s:property value="#each_order.orderId" />
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
													var="each_element" status="L">
													<tr>
														<s:if test="#L.index==0">
															<th width="17%"
																rowspan='<s:property value="#each_color.detailList.size"/>'><s:property
																	value="#each_color.color" /></th>
														</s:if>
														<th width="19%"><s:property
																value="#each_element.size" /></th>
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
									</div>
								</div>
							</s:iterator>
						</div>
					</s:iterator>
				</div>


				<div role="tabpanel" class="tab-pane" id="waitSend">
					<s:iterator value="waitSendOrderList" var="each_order">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									订单号
									<s:property value="#each_order.orderId" />
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
													var="each_element" status="L">
													<tr>
														<s:if test="#L.index==0">
															<th width="17%"
																rowspan='<s:property value="#each_color.detailList.size"/>'><s:property
																	value="#each_color.color" /></th>
														</s:if>
														<th width="19%"><s:property
																value="#each_element.size" /></th>
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
	<div>
	<button type="button" class="btn btn-primary btn-lg"  data-toggle="modal" data-target="#myModal" >
 				 发货<span class="glyphicon glyphicon-chevron-right"></span>
	</button> 
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  		<div class="modal-dialog  bs-example-modal-sm" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
        		<h4 class="modal-title" id="myModalLabel">发货</h4>
      		</div>
      		<div class="modal-body">
      		<form action="sendOrderForm" method="POST" id="sendOrderForm">
        		<ul class="list-group">
        		<li class="list-group-item form-group">订单编号<input type="text" style="float: right;border:0;width:200px" name="orderId" id="orderId" disabled="true"><s:property value="#each_order.orderId" /></input></li>
  				<li class="list-group-item form-group">快递单号<input type="text" style="float: right;border:0;width:200px" name="expressNumber" id="expressNumber"></input></li>
  				</ul>
			</form>
      		</div>
      		
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal" id="cancelAdd">取消</button>
        		<button type="button" class="btn btn-primary" id="send">确认发货</button>
           </div>
         </div>
       </div>
     </div>
	</div>
										
									</div>
								</div>
							</s:iterator>
						</div>
					</s:iterator>
				</div>


				<div role="tabpanel" class="tab-pane" id="refund">
					<s:iterator value="refundOrderList" var="each_order">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									订单号
									<s:property value="#each_order.orderId" />
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
													var="each_element" status="L">
													<tr>
														<s:if test="#L.index==0">
															<th width="17%"
																rowspan='<s:property value="#each_color.detailList.size"/>'><s:property
																	value="#each_color.color" /></th>
														</s:if>
														<th width="19%"><s:property
																value="#each_element.size" /></th>
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
												value="#each_order.status" /></span><span><a
											onclick="refund('<s:property value="#each_order.orderId"/>')">确认退款</a></span>
									</div>
								</div>
							</s:iterator>
						</div>
					</s:iterator>
				</div>
			</div>
		</div>
	</div>
		
	
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
$('#send').click(function() {
	  $("#sendOrderForm").submit();
	  
})
		
		  $("#cancelAdd").click(function() {
			  $('#myModal').modal('hide');
			  $(':input','#sendOrderForm')
			  .not(':button, :submit, :reset, :hidden')
			  .val('')
			  .removeAttr('checked')
			  .removeAttr('selected');

		  })
		  
		  function refund(orderId){
	$.post("json/refundMoney", {
		orderId : orderId
	}, function (data,status) {//ajax请求完成时执行，result为返回的结果
        alert(data.resultMessage);
	})}
	</script>
</body>
</html>