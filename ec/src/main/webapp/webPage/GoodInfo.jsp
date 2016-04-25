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
<title>OrderView</title>
</head>
<body onload="showPicture();">
    <div class="path">
        <a href="#">首页</a> / <a href="#">上装</a> / <a href="#">毛衣</a>
    </div>
    <div class="container" style="padding-top:10px;">
    <div class="row">
            <div class="col-sm-5">
                <div class="bigpic" >
                    <img class="img-responsive" src="" alt="a" />
                </div>
                <div id="smallPicture" class="smailpic" >
                <s:iterator  value="imgs" var="each_pic">
                <img class="img" src='<s:property value="#each_pic"/>' onclick="changePicture('#each_pic')">
                </s:iterator>
                </div>
            </div>
             <div class="col-sm-7">
                <p><strong><s:property value="name"/></strong></p>
                <p class="money"><s:property value="price"/></p>
                <hr>
                <div class="smailpic">
                    <img src="./1.jpg" alt="a" />
                </div>
                <table class="number">
                    <thead>
                        <th>尺码</th>
                        <th>价格</th>
                        <th>库存</th>
                        <th>购买量</th>
                    </thead>
                    <tbody>
                    <s:iterator  value="stock">      
                        <tr>
                            <td><s:property value="size"/></td>
                            <td><s:property value="price"/></td>
                            <td><s:property value="quantity"/></td>
                            <td>
                                <button onclick="deleteGood()">-</button> 0
                                <button onclick="addGood()">+</button>
                            </td>
                        </tr>
                         </s:iterator>
                        
                        <tr>
                            <td id="totelGood"></td>
                            <td id="totelMoney">0</td>
                        </tr>
                    </tbody>
                </table>
                <div style="padding: 10px;">
                    <button style="float:left;">收藏</button>
                    <button style="float:right;">立即购买</button>
                    <button style="float:right;">加入进货单</button>
                </div>
            </div>
        </div>
        <div class="row" style="padding-top:20px">
            <div class="col-sm-3">
                <h5>同类热销</h5>
                <img class="img-responsive" src="./1.jpg" alt="a" />
                <p>女士圆领爱心毛衣纯棉线衫直筒毛衫韩版</p>
                <img class="img-responsive" src="./1.jpg" alt="a" />
                <p>女士圆领爱心毛衣纯棉线衫直筒毛衫韩版</p>
                <img class="img-responsive" src="./1.jpg" alt="a" />
                <p>女士圆领爱心毛衣纯棉线衫直筒毛衫韩版</p>
            </div>
            <div class="col-sm-9">
            <!-- Nav tabs -->
  				<ul class="nav nav-tabs" role="tablist">
    					<li role="presentation" class="active"><a href="description" aria-controls="description" role="tab" data-toggle="tab">商品详情</a></li>
    					<li role="presentation"><a href="deliver_info" aria-controls="deliver_info" role="tab" data-toggle="tab">发货信息</a></li>
    					<li role="presentation"><a href="return_info" aria-controls="return_info" role="tab" data-toggle="tab">退货信息</a></li>
  						</ul>
            
                <div class="tab-content">
  					<div role="tabpanel" class="tab-pane active" id="description"><s:property value="description"/></div>
  					<div role="tabpanel" class="tab-pane " id="deliver_info"><s:property value="deliver_info"/></div>
  					<div role="tabpanel" class="tab-pane " id="return_info"><s:property value="return_info"/></div>
				</div>
                <div>马璐璐，和铃兰，服务态度很好，也很亲切。说句实在话，森马的客服员，比其他我所遇到的客服员好很多。有的客服员难怪卖不出去东西。我也很喜欢在森马买东西，价格实惠，商品质量也很不错。大爱。
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
	$('#img-responsive').attr('src', img);
}

function deleteGood(thisSize){
	var 
}
function addGood(){
	
}

$('#description').click(function (e) {
	  e.preventDefault();
	  $(this).tab('show');
	})
	
	
$('#deliver_info').click(function (e) {
	  e.preventDefault();
	  $(this).tab('show');
	})
	
$('#return_info').click(function (e) {
	  e.preventDefault();
	  $(this).tab('show');
})
	</script>
</body>
</html>