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
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

    <style>
        .col {
            float: left;
            padding: 10px;
            text-align: left;
        }
        
        .path {
            background-color: #c0c0c0;
            text-align: left;
            padding: 5px;
        }
        
        a {
            color: black;
            text-decoration: none;
        }
        
        a:hover {
            color: black;
        }
        
        .smailpic {
            padding-right: 3px;
            padding-top: 3px;
        }
        
        .smailpic img {
            max-width: 60px;
        }
        
        .money {
            color: #c40000;
        }
        
        .number {
            float: initial;
            width: 100%;
        }
        
        .midpic {
            height: 140px;
        }
    </style>
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoodInfo</title>
</head>
<body onload="showPicture();">
    <div class="path">
        <a href="#">首页</a> / <a href="#">上装</a> / <a href="#">毛衣</a>
    </div>
    <div class="container" style="padding-top:10px;">
    <div class="row">
            <div class="col-sm-5">
                <div class="bigpic" >
                    <img class="img-responsive" id="bigPicture" src="<s:property value="mainPic"/>" alt="a" />
                </div>
                <div id="smallPicture" class="smailpic" >
                <!--
                <s:iterator  value="imgs" var="each_pic">
                <img class="img" src='<s:property value="#each_pic"/>' onclick="changePicture('<s:property value="#each_pic"/>')">
                </s:iterator>
                -->
                <img class="img" src="C:/Users/user/Desktop/img.jpeg" onclick="changePicture('C:/Users/user/Desktop/img.jpeg')">
                <img class="img" src="C:/Users/user/Desktop/img.jpeg" onclick="changePicture('C:/Users/user/Desktop/img.jpeg')">
                </div>
            </div>
             <div class="col-sm-7">
                <p><strong><s:property value="name"/></strong></p>
                <p class="money"><s:property value="price"/></p>
                <hr>
                <div class="smailpic">
                    <img src="<s:property value="mainPic"/>" alt="a" />
                </div>
                <table class="number" >
                    <thead >
                        <th style="font-size: 18px">尺码</th>
                        <th style="font-size: 18px">价格</th>
                        <th style="font-size: 18px">库存</th>
                        <th style="font-size: 18px">购买量</th>
                        <th style="font-size: 18px">总价</th>
                    </thead>
                    <tbody>
                    <s:iterator  value="stocks" var="stock">      
                        <tr>
                            <td><s:property value="#stock.size"/></td>
                            <td>￥<s:property value="price"/></td>
                            <td><s:property value="#stock.quantity"/></td>
                            <td>
                                <div class="btn-group" role="group" aria-label="...">
  									<button type="button"  class="glyphicon glyphicon-minus" style="background-color:transparent" onclick="deleteGood('<s:property value="#stock.size"/>','<s:property value="price"/>')"></button>
 									<span id="<s:property value="#stock.size"/>">0</span>
  									<button type="button" class="glyphicon glyphicon-plus" style="background-color:transparent" onclick="addGood('<s:property value="#stock.size"/>','<s:property value="price"/>','<s:property value="#stock.quantity"/>')"></button>
								</div>
                            </td>
                        </tr>
                         </s:iterator>
                        
                        <tr style="font-size:25px">
                        	<td>总计</td>
                        	<td></td>
                        	<td></td>
                            <td ><span id="totalGood">0</span>件</td>
                            <td >￥<span id="totalMoney">0</span></td>
                        </tr>
                    </tbody>
                </table>
                <div style="padding: 10px;">
                	<button type="button" class="btn btn-default glyphicon glyphicon-heart" style="float:left" onclick="favourt()">收藏</button>
                    <div class="btn-group" role="group" aria-label="..." style="float:right">
 						<button type="button" class="btn btn-default">加入购物车</button>
  						<button type="button" class="btn btn-default">立刻购买</button>
					</div>
                </div>
            </div>
        </div>
        <div class="row" style="padding-top:20px">
            <div class="col-sm-3">
                <h5>同类热销</h5>
                <s:iterator value="hotGood" var="each_good">
                <a href="getGoodInfo?goodId=<s:property value='#each_good.goodId'/>"><img class="img-responsive" src="<s:property value='#each_good.img'/>" alt="a"/></a>
                <p><s:property value="#each_good.name"/></p>
                </s:iterator>
            </div>
            <div class="col-sm-9">
            <!-- Nav tabs -->
  				<ul class="nav nav-tabs" role="tablist">
    					<li role="presentation" class="active"><a href="#description" aria-controls="description" role="tab" data-toggle="tab">商品详情</a></li>
    					<li role="presentation"><a href="#deliver_info" aria-controls="deliver_info" role="tab" data-toggle="tab">发货信息</a></li>
    					<li role="presentation"><a href="#return_info" aria-controls="return_info" role="tab" data-toggle="tab">退货信息</a></li>
  						</ul>
            
                <div class="tab-content">
  					<div role="tabpanel" class="tab-pane active" id="description"><s:property value="description"/></div>
  					<div role="tabpanel" class="tab-pane " id="deliver_info"><s:property value="deliver_info"/></div>
  					<div role="tabpanel" class="tab-pane " id="return_info"><s:property value="return_info"/></div>

            </div>
        </div>
        </div>
        </div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
var quantity=0;

function changePicture(img){
	$('#bigPicture').attr('src', img);
}

function deleteGood(thisSize,price){
	var numOfThisSize=$('#'+thisSize+'').text();
	var totalNum=$('#totalGood').text();
	if(numOfThisSize!=0){
	numOfThisSize--;
	totalNum--;
	var totalMoney=totalNum*price;
	$('#'+thisSize+'').text(numOfThisSize);
	$('#totalGood').text(totalNum);
	$('#totalMoney').text(totalMoney);
	}
}

function addGood(thisSize,price,quantity){
	var numOfThisSize=$('#'+thisSize+'').text();
	var totalNum=$('#totalGood').text();
	if((numOfThisSize-quantity)<0){
	numOfThisSize++;
	totalNum++;
	var totalMoney=totalNum*price;
	$('#'+thisSize+'').text(numOfThisSize);
	$('#totalGood').text(totalNum);
	$('#totalMoney').text(totalMoney);
	}
}


	</script>
</body>
</html>