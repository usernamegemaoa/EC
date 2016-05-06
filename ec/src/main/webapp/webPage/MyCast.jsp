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

</head>

<body>
	<div class="search">
		<form action="Search" method="post" style="float: right;">
			<input name="search" type="text" style="margin: 0px;" /> 
			<input type="submit" value="搜索" style="margin: 0px;" />
		</form>
	</div>
	<div class="menu" style="height: 30px;">
		<ul class="left-list">
			<li><a href="#">主页</a></li>
			<s:iterator value="fatherKinds" id="each_father">
				<li><a href='Category?kindId=<s:property value="#each_father.kindId"/>&page=0'><s:property value="#each_father.name" /></a></li>
			</s:iterator>
		</ul>
		<ul class="right-list">
		<s:if test='userId==0'>
			<li><a href="login">登录</a></li>
			<li><a href="regiest">注册</a></li>
		</s:if>
		<s:else>		
			<li><s:property value="userName" /></li>
			<li><a href="logout">退出</a></li>
			<li><a href="personalCenter">个人中心</a></li>
			<li><a href="myCast">进货单</a></li>
		</s:else>
		</ul>
	</div>
	
	<s:if test="castElement.size() > 0">
		<s:iterator value="castElement" id="goodElement">
			<div class="panel panel-default"
				style="width: 1000px; margin: 10px auto;">
				<div class="panel panel-heading" style="margin: 0;">
					<h3 class="panel-title">
						<span style="margin: auto 80px;">货品</span> <span
							style="margin: auto 60px;">尺码</span> <span
							style="margin: auto 30px;">库存</span> <span
							style="margin: auto 70px;">选购数</span> <span
							style="margin: auto 30px;">单价(元)</span> <span
							style="margin-left: 100px;">金额(元)</span>
					</h3>

				</div>
				<div class="panel panel-body">
					<div style="float: left">
						<img style="width: 100px; height: 200px;"
							src=<s:property value="#goodElement.img" /> />
					</div>


					<div class="cast" style="float: left; margin-left: 30px;">
						<div style="padding-bottom: 10px;">
							<span style="margin-left: 50px;"> <input type="checkbox"
								name="goodCheck" class="good-btn" /> <s:property
									value="#goodElement.name" />
							</span>
						</div>
						<s:iterator value="#goodElement.colorList" id="colorElement">
							<div class="color" style="overflow: auto;">
								<div style="float: left; margin: 10px; width: 100px;">
									<input type="checkbox" name="colorCheck" class="color-btn" />
									<s:property value="#colorElement.color" />
								</div>
								<div style="float: left">
									<table class="table" style="float: left; width: 700px;">
										<s:iterator value="#colorElement.detailList" id="detail">
											<tr class="detail" id=<s:property value="#detail.castId" />>
												<td width="20%"><input type="checkbox" name="castCheck"
													class="size-btn" />
												<s:property value="#detail.size" /></td>
												<td width="20%"><s:property value="#detail.stockNum" /></td>
												<td width="20%"><input class="min" type="button"
													style="width: 20px;" value="-" /> <input class="num"
													type="text" style="width: 30px; text-align: center;"
													value=<s:property value="#detail.num" /> /> <input
													class="plus" type="button" style="width: 20px;" value="+" />
												</td>
												<td width="30%"><label class="unitPrice"> <s:property
															value="#detail.unitPrice" />
												</label></td>
												<td width="10%"><label class="price">0.0</label></td>
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

		<div class="panel panel-default"
			style="width: 1000px; margin: 10px auto;">
			<div class="panel panel-heading" style="margin: 0;">
				<span style="margin-right: 20px;"><input type="checkbox" />全选</span>
				<span style="margin-right: 200px;" onclick="ck(false)"><font
					color="red">清空全选</font></span> <span style="margin-right: 15px;">
					货品种类： <label class="kinds">5</label> 种
				</span> <span style="margin-right: 15px;"> 数量总计： <label
					class="counts">3</label> 件
				</span> <span style="margin-right: 60px;"> 货品金额总计(不包含运费)： <label
					class="totalPrice">0.00</label>
				</span>
				<div class="btn btn-danger" id="settle">前往结算</div>
			</div>
		</div>
	</s:if>
	<s:else>
		购物单为空
	</s:else>
	<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(getCount());
		
		$("input[name='goodCheck']").click(function(){
			var checked = $(this).prop("checked");
			var cast = $(this).parents(".cast");
			$(cast).find("input").each(function(){
				$(this).prop("checked", checked);
			});
			getCount();
		});
		
		$("input[name='colorCheck']").click(function(){
			var checked = $(this).prop("checked");
			var color = $(this).parents(".color");
			$(color).find("input").each(function(){
				$(this).prop("checked", checked);
			});
			getCount();
		});
		
		$("input[name='castCheck']").click(function(){
			getCount();
		});
		
		$("input").click(getCount());
		
		$(".min").click(function(){
			var num = $(this).next();
			if(parseInt($(num).val()) > 0){
				$(num).val(parseInt($(num).val()) - 1)
			}
			getCount();
		});
		
		$(".plus").click(function(){
			var num = $(this).prev();
			$(num).val(parseInt($(num).val()) + 1);
			getCount();
		});
		
		function getCount(){
			var kinds = 0;
			var counts = 0;
			var totalPrice = 0.00;
			$(".cast").each(function(){
				var hasDetail = false;
				$(this).find(".detail").each(function(){
					var num = parseInt($(this).find(".num").val());
					var unitPrice = parseFloat($(this).find(".unitPrice").text());
					var price = parseFloat(num * unitPrice);
					$(this).find(".price").text(price.toFixed(2));
					if($(this).find("input").prop('checked')){
						hasDetail = true;
						counts += num;
						totalPrice += price;
					}
				});
				if(hasDetail) {
					kinds++;
				}
			});
			$(".kinds").text(kinds);
			$(".counts").text(counts);
			$(".totalPrice").text(totalPrice.toFixed(2));
		};
		
		$("#settle").click(function(){
			var castStr ="";
			$(".cast").each(function(){
				$(this).find(".detail").each(function(){
					if($(this).find("input").prop('checked')){
						var castId = $(this).attr('id');
						var num = $(this).find(".num").val();
						castStr += castId + ":" + num + " ";
					}
				});
			});
			var data={};
			data['castStr'] = castStr;
			$.post("json/createOrder",data, function(data, status){
				if(data.code == 0){
					alert("请选择要付款的商品");
				} else{
					var url = "order?orderId=" + data.orderId;
					window.location.href=url;
				}
				
			});
		});
	
	</script>

</body>

</html>