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
<html lang="zh-CN"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>personalcenter</title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
 <div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar"style="font-family: 'Microsoft Yahei', Tahoma, Arial, Helvetica, Simsun, STHeiti">
					<ul class="nav nav-sidebar">
						<li class="active">
							<a href="getUserInfo" id="thisPerson" name="thisPerson" target="i">个人中心<span class="sr-only">(current)</span>
							</a>
						</li>
						<li >
							<a href="" target="i">订单中心</a>
						</li>
						<li style="margin-left:15px">
							<a href="myOrder" id="myOrder" name="orderCenter" target="i">我的订单</a>
						</li>
						<li style="margin-left:15px">
							<a href="webPage/cancelOrder.jsp" id="cancelOrder" name="orderCenter" target="i">取消订单</a>
						</li>
						<li style="margin-left:15px">
							<a href="webPage/refound.jsp" id="refund" name="orderCenter" target="i">退款申请</a>
						</li>
						<li style="margin-left:15px">
							<a href="webPage/favourite.jsp" id="favourite" name="orderCenter" target="i">收藏产品</a>
						</li>
					</ul>
					<ul class="nav nav-sidebar">
						<li  class="active">
							<a href="">资料信息</a>
						</li>
						<li style="margin-left:15px">
							<a href="webPage/myInfo.jsp" id="myInfo" name="Information" target="i">我的资料</a>
						</li >
						<li style="margin-left:15px">
							<a href="getAddress" id="address" name="Information" target="i">收货地址</a>
						</li >
						<li style="margin-left:15px">
							<a href="jumpChangePassword" id="changeCode" name="Information" target="i">修改密码</a>
						</li>
				
					</ul>
					<ul class="nav nav-sidebar">
						<li  class="active">
							<a href="webPage/.jsp" id="logOut" name="Log" target="i" onclick="quit()">安全退出</a>
						</li>
					</ul>
				</div>
			<iframe src="getUserInfo" id="iframe" name="i" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
			 style="height:700px;width: 70%;margin-left: 150px;margin-top:10px" frameborder="0" scrolling="yes">
				
				</iframe>	
			</div>
		</div>



	</body>
</html>