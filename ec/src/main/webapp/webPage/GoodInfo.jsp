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
    <div class="row">
            <div class="col-sm-5">
                <div class="bigpic" >
                    <img class="img-responsive" src="./1.jpg" alt="a" />
                </div>
                <div id="smallPicture" class="smailpic" >
                <s:iterator  value="imgs" var="var">
                <img src='<s:property value="#each_pic"/>'>
                </s:iterator>
                </div>
            </div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
showPicture(){
	var imgs=<s:property value="imgs"/>;
	for(var i=0;i<imgs.size();i++){
		var div = document.createElement("div");
		var thisImg=imgs.get(i);
		div.innerHTML = "<img src='"+thisImg+"' alt="+a+"/>";
		document.getElementById("smallPicture").append(div);
		}
	}
</script>
</body>
</html>