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
<link rel="stylesheet" href="css/buttons.css">
<link href="css/homepage.css" rel="stylesheet">
<link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        .col {
            float: left;
            padding: 10px;
            text-align: left;
        }
        
        .path {
            background-color: #F0F0F0;
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
            font-size:25px;
        }
        
        .number {
            float: initial;
            width: 100%;
            table-layout:fixed;
            
        }
        
        .midpic {
            height: 140px;
        }
    </style>
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoodInfo</title>
</head>
<body>
    <div class="container" style="padding-top:10px;">
    <div class="row">
    	<jsp:include page="head.jsp"></jsp:include>
    </div>
    <div class="row">    
    <div class="path">
        <a href="Homepage">首页</a>   /   <a href='Category?kindId=<s:property value="fatherKind.kindId"/>&page=0'><s:property value="fatherKind.name"/></a>   /   <a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=0'><s:property value="sonKind.name"/></a>   /   <a><s:property value="name"/></a>
    </div>
    </div>
    <div class="row">
            <div class="col-sm-5">
                <div class="bigpic" >
                    <img class="img-responsive" id="bigPicture" src="<s:property value="mainPic"/>" alt="a" />
                </div>
                <div id="smallPicture" class="smailpic" >
                
                <s:iterator  value="imgs" var="each_pic">
                <img class="img" src='<s:property value="#each_pic"/>' onclick="changePicture('<s:property value="#each_pic"/>')">
                </s:iterator>
        
                </div>
            </div>
             <div class="col-sm-7">
                <p style="font-size:30px"><strong><s:property value="name"/></strong></p>
                <p class="money">￥<s:property value="price"/></p>
                <hr>
                <div class="smailpic">
                    <img src="<s:property value="mainPic"/>" alt="a" />
                </div >
                <table class="number">
                    <thead >
                        <th style="font-size: 18px" id="tsize" style="width:15%">尺码</th>
                        <th style="font-size: 18px"  style="width:15%">颜色</th>
                        <th style="font-size: 18px"  style="width:15%">价格</th>
                        <th style="font-size: 18px"  style="width:15%">库存</th>
                        <th style="font-size: 18px" id="tnumber"  style="width:15%">购买量</th>
                    </thead>
                    <tbody >
                    <s:iterator  value="stocks" var="stock">      
                        <tr style="line-height:50px" id="<s:property value="#stock.id"/>">
                            <td><s:property value="#stock.size"/></td>
                            <td><s:property value="#stock.color"/></td>
                            <td>￥<s:property value="price"/></td>
                            <td><s:property value="#stock.quantity"/></td>
                            <td>
  									<button class="button button-primary button-circle button-small " onclick="deleteGood('<s:property value="#stock.size"/><s:property value="#stock.color"/>','<s:property value="price"/>')"><i class="fa fa-minus"></i></button>
 									<span id="<s:property value="#stock.size"/><s:property value="#stock.color"/>">0</span>
  									<button class="button button-primary button-circle button-small " onclick="addGood('<s:property value="#stock.size"/><s:property value="#stock.color"/>','<s:property value="price"/>','<s:property value="#stock.quantity"/>')"><i class="fa fa-plus"></i></button>
                            </td>
                                                       
                        </tr>
                                                    
                         </s:iterator>
                        <tr style="font-size:25px;color: #c40000;">
                        	<td >总计</td>
                            <td ><span id="totalGood">0</span>件</td>
                            <td >￥<span id="totalMoney">0</span></td>
                        </tr>
                    </tbody>
                </table>
                <hr>
                <div style="padding: 10px;">
                	<button type="button" class="btn btn-default glyphicon glyphicon-heart" style="float:left;background-color: transparent; border: 0;color:#9999CC" onclick="favourite()">收藏</button>
                    <div class="btn-group" role="group" aria-label="..." style="float:right">
 						<button type="button" class="btn btn-default" style="background:#FFC78E" onclick="addPlan()"> <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>加入购物车</button>
  						<button type="button" class="btn btn-default" style="background:#ACD6FF"><span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>立刻购买</button>
					</div>
                </div>
            </div>
        </div>
        <div class="row" style="padding-top:20px">
            <div class="col-sm-3">
                <h5 style="font-size:25px">同类热销</h5>
               
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
var stockId='';
var numArray='';
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

function favourite(){
	$.post("json/addFavourite",
            function (data,status) {
                alert(data.resultMessage);
})
}

function addPlan(){
	stockId='';
	numArray='';
	$(".number tbody").find("tr").find("td:eq(4)").find("span").each(function(){
		numArray+=($(this).text())+',';
	});
	$(".number tbody").find("tr").each(function(){
		stockId+=(($(this)).attr("id"))+',';
	});
	$.post("json/addPlan",{stockIdList:stockId,numList:numArray},
            function (data,status) {
                alert(data.resultMessage.resultMessage)
})
}


	</script>
</body>
</html>