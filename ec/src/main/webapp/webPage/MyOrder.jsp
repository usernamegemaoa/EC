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
	<style type="text/css">
	     .leftdiv{float:left;width:8%;height:100px;
	     }
	     .rightdiv{float:right;width:90%}
	</style>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyOrder</title>

<script>
function show(i){
	 document.getElementById(i).style.display='';
	
}

</script>
</head>
<body>
<div>
	<div id="showFrame">

  		<!-- Nav tabs -->
  		<ul class="nav nav-tabs" role="tablist">
   		<li role="presentation" class="active"><a href="#allOrder" aria-controls="allOrder" role="tab" data-toggle="tab">所有订单<span class="badge"><s:property value="allOrderList.size"/></span></a></li>
    	<li role="presentation"><a href="#waitPay" aria-controls="waitPay" role="tab" data-toggle="tab">未付款<span class="badge"><s:property value="waitPayOrderList.size"/></span></a></li>
    	<li role="presentation"><a href="#waitSend" aria-controls="waitSend" role="tab" data-toggle="tab">待发货<span class="badge"><s:property value="waitSendOrderList.size"/></span></a></li>
    	<li role="presentation"><a href="#waitConfirm" aria-controls="waitConfirm" role="tab" data-toggle="tab">待收货<span class="badge"><s:property value="waitConfirmOrderList.size"/></span></a></li>
    	<li role="presentation"><a href="#refund" aria-controls="refund"" role="tab" data-toggle="tab">退款中<span class="badge"><s:property value="refundOrderList.size"/></span></a></li>
  		</ul>

  		<!-- Tab panes -->
  		<div class="tab-content">
  			<div role="tabpanel" class="tab-pane active" id="allOrder">
  				<div>
  				<s:iterator value="allOrderList" var="allordereach" >
  				
  						
  					<div class="leftdiv">
  						<img style="width:80px;height:80px" src="C:\Users\user\Desktop\img.jpeg" />
  						<div style="margin-left:20px;"><span><s:property value="#eachr_orderDetail.goodId"/></span></div>
  					</div>
  					<div class="rightdiv">
  					
  						<div class="panel panel-default">
  						
  							<div class="panel-heading"><span><s:property value="#eachr_orderDetail.id"/></span></div>

 								 <!-- Table -->
  							<table class="table" border=1>
  							<tr width="1000px"> 
        						<th width="20%">颜色</th> 
        						<th width="20%">尺码</th>  
        						<th width="20%">选购数</th> 
        						<th width="20%">单价(元)</th> 
        						<th width="20%">金额(元)</th>
   							 </tr>
   							 <s:iterator value="allOrderDetailList" id="eachr_orderDetail" status="status">
   							 		<s:if test="#allordereach.id==#eachr_orderDetail.orderId"> 
   							 <tr>
   							 		<th><s:property value="#eachr_orderDetail.color"/></th>
   							 		<th><s:property value="#eachr_orderDetail.size"/></th>
   							 		<th><s:property value="#eachr_orderDetail.quantity"/></th>
   							 		<th><s:property value="#eachr_orderDetail.price"/></th>
   							 		<th><s:property value="#eachr_orderDetail.price"/></th>
   							 	</tr>
   							 	</s:if>
   					</s:iterator>
   					</table>
						</div>
  					</div>
  					 
  				</s:iterator>
  			</div>
  		</div>
  		
  		
    	<div role="tabpanel" class="tab-pane" id="waitPay">
    		<div>
  					<div class="leftdiv">
  						<img style="width:100px;height:200px" src="C:/Users/user/Desktop/img.jpeg" />
  						<div style="margin-left:20px;"><span><s:property value="name"/></span></div>
  					</div>
  					<div class="rightdiv">
  						<div class="panel panel-default">
  							<div class="panel-heading"><span><s:property value="goodId"/></span></div>

 								 <!-- Table -->
  							<table class="table" border=1>
  							<tr> 
        						<th>颜色</th> 
        						<th>尺码</th> 
        						<th>选购数</th> 
        						<th>单价(元)</th> 
        						<th>金额(元)</th>
   							 </tr></table>
						</div>
  					</div>
  			</div>
		</div>
   	 	<div role="tabpanel" class="tab-pane" id="waitSend">
   	 		<div>
  					<div class="leftdiv">
  						<img style="width:100px;height:200px" src="C:/Users/user/Desktop/img.jpeg" />
  						<div style="margin-left:20px;"><span><s:property value="name"/></span></div>
  					</div>
  					<div class="rightdiv">
  						<div class="panel panel-default">
  							<div class="panel-heading"><span><s:property value="goodId"/></span></div>

 								 <!-- Table -->
  							<table class="table" border=1>
  							<tr> 
        						<th>颜色</th> 
        						<th>尺码</th> 
        						<th>选购数</th> 
        						<th>单价(元)</th> 
        						<th>金额(元)</th>
   							 </tr></table>
						</div>
  					</div>
  			</div>
  			</div>
    	<div role="tabpanel" class="tab-pane" id="waitConfirm">
    		<div>
  					<div class="leftdiv">
  						<img style="width:100px;height:200px" src="C:/Users/user/Desktop/img.jpeg" />
  						<div style="margin-left:20px;"><span><s:property value="name"/></span></div>
  					</div>
  					<div class="rightdiv">
  						<div class="panel panel-default">
  							<div class="panel-heading"><span><s:property value="goodId"/></span></div>

 								 <!-- Table -->
  							<table class="table" border=1>
  							<tr> 
        						<th>颜色</th> 
        						<th>尺码</th>  
        						<th>选购数</th> 
        						<th>单价(元)</th> 
        						<th>金额(元)</th>
   							 </tr></table>
						</div>
  					</div>
  			</div>
    	</div>
    	<div role="tabpanel" class="tab-pane" id="refund"">
    		<div>
  					<div class="leftdiv">
  						<img style="width:100px;height:200px" src="C:/Users/user/Desktop/img.jpeg" />
  						<div style="margin-left:20px;"><span><s:property value="name"/></span></div>
  					</div>
  					<div class="rightdiv">
  						<div class="panel panel-default">
  							<div class="panel-heading"><span><s:property value="goodId"/></span></div>

 								 <!-- Table -->
  							<table class="table" border=1>
  							<tr> 
        						<th>颜色</th> 
        						<th>尺码</th>  
        						<th>选购数</th> 
        						<th>单价(元)</th> 
        						<th>金额(元)</th>
        						<th>状态</th>
   							 </tr></table>
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
</body>
</html>