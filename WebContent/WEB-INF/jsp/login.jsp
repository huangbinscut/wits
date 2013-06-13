<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="inc/header.jsp"%>
<html>
	<head>
		<!-- Meta -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- End of Meta -->
		
		<!-- Page title -->
		<title>WITS - 微智  -</title>
		<!-- End of Page title -->
		
		<!-- Libraries -->
		<link href="<c:url value='/css/pages/login.css'/>" rel="stylesheet" type="text/css" media="all"></link>
		<link href="<c:url value='/css/smoothness/jquery-ui-1.7.2.custom.html'/>" rel="stylesheet" type="text/css" media="all"></link>

		<script type="text/javascript" src="<c:url value='/js/inc/easyTooltip.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery-ui-1.7.2.custom.min.js'/>"></script>
		<!-- End of Libraries -->	
		
		
		<script type="text/javascript">
	
        </script>
	</head>
	<body>
	<div id="container">
	
		<div id="motto">
			<p class="motto">
				<label id="info">
				</label>
				<label>
					"where is the wisdom we have lost in knowledge? where is the knowledge we have lost in information? ......"
				</label>
			</p>
		</div>
		
		<div id="logo">
			<a href="#"><img src="<c:url value='/images/wits-logo.png'/>" alt="" /></a>
		</div>
		
		<div id="box">
			<form:form action="/wits/individual/login" commandName="individualCommand" method="POST">
			<p class="main">
				<label>登录邮箱: </label>
				<form:input path="loginName"/>
				<label>密码: </label>
				<form:password path="password"/>
			</p>
			<p class="space">
				<span><input type="checkbox" />下次自动登录</span>
				<input type="submit" value="登录" class="login"/>
			</p>
			<p class="space">
				<span><a href="<c:url value='/individual/password'/>">忘记密码？</a></span>
				<span><a href="<c:url value='/individual/register'/>"><注册新用户></a></span>
			</p>
			<span class="error">
				
				<form:errors path="*"/><br/>
			</span>
			</form:form>
		</div>
		
	</div>

	</body>
</html>