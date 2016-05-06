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
	<hr style="margin: 10px; height: 0.5px; border: none; border-top: 2px solid #DDDDDD;" />
	<div class="ad">
		<img src="img/ad2.jpg" />
		<!--此处应有js-->
	</div>
	<div class="kind">
		<ul class="kind-list">
			<s:iterator value="fatherKinds" id="each_father">
				<li><a href='Category?kindId=<s:property value="#each_father.kindId"/>&page=0'><s:property value="#each_father.name" /></a></li>
				<s:if test="#each_father.kindId==fatherId">
					<s:iterator value="sonKinds" id="each_son">
						<s:if test="#each_son.kindId==sonKind.kindId">
						<li class="son-kind" style="padding-left: 30px;"><a href='Category?kindId=<s:property value="#each_son.kindId"/>&page=0'><s:property value="#each_son.name" /></a></li>
						</s:if>
						<s:else>
						<li class="son-kind" style="padding-left: 30px;"><a href='Category?kindId=<s:property value="#each_son.kindId"/>&page=0'><s:property value="#each_son.name" /></a></li>
						</s:else>
					</s:iterator>
				</s:if>
			</s:iterator>
		</ul>
	</div>
	<div class="items">
	 	<h2>今日上新</h2>
    	<hr style="margin: 10px;height:0.5px;border:none;border-top:2px solid #4B4B4B;">
    	<ul class="item-list">
    		<s:iterator value="goodsList" id="good">
    			<li>
    			<div class="main-pic" style="margin:20px;">
    				<img src=<s:property value="#good.img" /> style="width:160px;height:280px;"/>
    			</div>
    			<div class="item-link">
    			<a href='getGoodInfo?goodId=<s:property value="#good.goodId" />'><s:property value="#good.name" /></a>
    			</div>
    			</li>
    		</s:iterator>
    	</ul>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!--script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script-->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!--<script src="js/bootstrap.min.js"></script>-->

	<!--  	<nav>
	    	<ul class="pagination">
	    		<s:if test="page < 4">
	    			<s:if test="page != 0">
	    				<li>
		    				<a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="page - 1" />' aria-label="Previous">
	        					<span aria-hidden="true">&laquo;</span>
	      					</a>
      					</li>
	    			</s:if>
	    				<li class="disabled">
		    				<a aria-label="Previous">
	        					<span aria-hidden="true">&laquo;</span>
	      					</a>
      					</li>
	    			<s:iterator begin='0' end='page' id="status">
	    				<s:if test="#status == page">
	    					<li class="active"><a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="#status" />'><s:property value="#status + 1" /></a></li>
	    				</s:if>
	    				<s:else>
	    					<li><a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="#status" />'><s:property value="#status + 1" /></a></li>
	    				</s:else>
	    			</s:iterator> 
	    		</s:if>
	    		<s:else>
	    			<a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="page - 1" />' aria-label="Previous">
        				<span aria-hidden="true">&laquo;</span>
      				</a>
	    			<li><a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=0'>1</a></li>
	    			<li style="border: none;">...</li>
	    			<s:iterator begin='page-2' end='page' id="status"> 
	    				<s:if test="#status == page">
	    					<li class="active"><a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="#status" />'><s:property value="#status + 1" /></a></li>
	    				</s:if>
	    				<s:else>
	    					<li><a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="#status" />'><s:property value="#status + 1" /></a></li>
	    				</s:else>
	    			</s:iterator>
	    		</s:else>
	    		
	    		<s:if test="(totalPage-page)>4">
	    			<s:iterator begin='page+1' end='page+2' id='status'>
	    				<li><a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="#status" />' ><s:property value="#status+1" /></a></li>
	    			</s:iterator>
	    			<li style="border: none;">...</li>
	    			<li><a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="totalPage - 1" />' ><s:property value="totalPage" /></a></li>	
	    			<a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="page + 1" />' aria-label="Next">
        				<span aria-hidden="true">&raquo;</span>
      				</a>
	    		</s:if>
	    		<s:else>
	    			<s:if test="page < (totalPage-1)">
		    			<s:iterator begin='page+1' end='totalPage-1' id='status'>
		    				<li><a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="#status" />' ><s:property value="#status+1" /></a></li>
		    			</s:iterator>
		    			<a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="page + 1" />' aria-label="Next">
        					<span aria-hidden="true">&raquo;</span>
      					</a>
	    			</s:if>
	    		</s:else>
	    	</ul>
    	</nav>-->
    	
    	<nav style="text-align:center;">
    		<ul class="pagination">
    			<s:if test="page != 0">
    				<li>
		    			<a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="page - 1" />' aria-label="Previous">
	        				<span aria-hidden="true">&laquo;</span>
	      				</a>
      				</li>
    			</s:if>
    			<s:else>
    				<li class="disabled">
		    			<a aria-label="Previous">
	        				<span aria-hidden="true">&laquo;</span>
	      				</a>
      				</li>
    			</s:else>
    			<s:iterator begin='0' end='page' id="status">
    				<s:if test="#status == page">
    					<li class="active"><a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="#status" />'><s:property value="#status + 1" /></a></li>
    				</s:if>
    				<s:else>
    					<li><a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="#status" />'><s:property value="#status + 1" /></a></li>
    				</s:else>
    			</s:iterator>
    			<s:if test="page < (totalPage-1)">
    				<li>
		    			<a href='Category?kindId=<s:property value="sonKind.kindId"/>&page=<s:property value="page - 1" />' aria-label="Next">
	        				<span aria-hidden="true">&raquo;</span>
	      				</a>
      				</li>
    			</s:if>
    			<s:else>
    				<li class="disabled">
		    			<a aria-label="Next">
	        				<span aria-hidden="true">&raquo;</span>
	      				</a>
      				</li>
    			</s:else>
    		</ul>
    	</nav>

  	</div>
</body>

</html>