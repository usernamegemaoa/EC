<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/homepage.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
 <s:if test="castElement.size() > 0">
 <s:iterator value="castElement" id="goodElement">
  <div class="panel panel-default" style="width:1000px; margin: 10px auto;">
    <div class="panel panel-heading" style="margin:0;">
      <h3 class="panel-title">
      	<span style="margin:auto 80px;">货品</span>
      	<span style="margin:auto 60px;">尺码</span>
      	<span style="margin:auto 30px;">库存</span>
      	<span style="margin:auto 70px;">选购数</span>
      	<span style="margin:auto 30px;">单价(元)</span>
      	<span style="margin-left: 100px;">金额(元)</span>
      </h3>
        
    </div>
    <div class="panel panel-body">
      <div style="float:left">
        <img style="width: 100px; height: 200px;" src=<s:property value="#goodElement.img" /> />
      </div>
    
    
      <div class="cast" style="float:left;margin-left:30px;">
        <div style="padding-bottom:10px;">
          <span style="margin-left:50px;">
          	<input type="checkbox" />
          	<s:property value="#goodElement.name" />
          </span> 
        </div>
        <s:iterator value="#goodElement.colorList" id="colorElement">
	       <div class="color" style="overflow:auto;">
	          <div style="float:left;margin:10px;width:100px;">
	            	<s:property value="#colorElement.color" />
	          </div>
	          <div style="float:left">
	            <table class="table" style="float:left;width: 700px;">
	             	<s:iterator value="#colorElement.detailList" id="detail">
			            <tr>
			              <td width="20%"><input type="checkbox" /><s:property value="#detail.size" /></td>
			              <td width="20%"><s:property value="#detail.stockNum" /></td>
			              <td width="20%"><s:property value="#detail.num" /></td>
			              <td width="30%"><s:property value="#detail.unitPrice" /></td>
			              <td width="10%">总价</td>
			            </tr>
		            </s:iterator>
	            </table>
	          </div>     
	        </div>
        </s:iterator>
      </div>
    </div>
   </div>
   </s:iterator>
   
   <div class="panel panel-default" style="width:1000px; margin: 10px auto;">
   	<div class="panel panel-heading" style="margin:0;">
   		<span style="margin-right: 20px;"><input type="checkbox" />全选</span>	
   		<span style="margin-right: 200px;"><font color="red">清空</font></span>
   		<span style="margin-right: 30px;">货品种类：种</span>
   		<span style="margin-right: 30px;">数量总计：件</span>
   		<span style="margin-right: 70px;">货品金额总计(不包含运费)：9999</span>
   		<a href="" class="btn btn-danger">前往结算</a>
   	</div>
   </div>
   </s:if>
   <s:else>
   	购物单为空
   </s:else>
</body>
</html>