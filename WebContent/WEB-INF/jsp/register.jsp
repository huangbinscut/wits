<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="inc/header.jsp"%>
<html>
	<head>
		<!-- Meta -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- End of Meta -->
		
		<!-- Page title -->
		<title>WITS - 微智  - 注册</title>
		<!-- End of Page title -->
		
		<!-- Libraries -->
		<link href="<c:url value='/css/pages/register.css'/>" rel="stylesheet" type="text/css" media="all"></link>
		<link href="<c:url value='/css/smoothness/jquery-ui-1.7.2.custom.html'/>" rel="stylesheet" type="text/css" media="all"></link>

		<script type="text/javascript" src="<c:url value='/js/inc/easyTooltip.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery-ui-1.7.2.custom.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery.json-2.2.min.js'/>"></script>   
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery.form.js'/>"></script>   
		<!-- End of Libraries -->	
		
		

		<script type="text/javascript">
			$(function() {
				$("#success").css("visibility", "hidden");
				$("#error").css("visibility", "hidden");

		
				$("#submit").click(	function() {
			        var jsonIndividualInfo = $('#individualCommand').formToArray();   
			        $.ajax( {   
			          type : 'POST',   
			          url : '/wits/individual/register',   
			          data : jsonIndividualInfo,   
			          dataType : 'json',   
			          success : function(data) {
			        	  	if (data && data.retFlag == 0) {
								var info = "";
								info += data.msg + "! ";
								info += "<a href='/wits/individual/login'>返回登录界面</a>";
								$("#error").replaceWith(
										'<div  id="error" class="message error close"><br><p>' + info + '</p><br></div>');
								$("#success").css("visibility", "hidden");
								$("#error").css("visibility", "visible");
								$("#form").css("visibility", "hidden");
			        	  	} else if (data && data.success == "false") {
								var info = "";
								$.each(data.errorList, function(i, item) {
									info += item.defaultMessage + "<br>";
								});
								$("#error").replaceWith(
										'<div  id="error" class="message error close"><br><p>' + info + '</p><br></div>');
								$("#success").css("visibility", "hidden");
								$("#error").css("visibility", "visible");
								$("#form").css("visibility", "visible");
							} else if (data && data.success == "true") {
								var info = "";
								info += data.data.userName + ", 恭喜你注册成功! ";
								info += "<a href='/wits/individual/login'>返回登录界面</a>";
								$("#success").replaceWith(
										'<div  id="success" class="message success close"><br><p>' + info + '</p><br></div>');
								$("#success").css("visibility", "visible");
								$("#error").css("visibility", "hidden");
								$("#form").css("visibility", "hidden");
							}
			          },   
			          error : function(data) {   
			            alert("error");   
			          }   
					});
				});
		
				$("#cancel").click(function() {
					location.href = "login";
				});
		
			});
		</script>
	</head>
	<body>
	<div id="container">
	

		<!-- Logo -->
		<div id="logo">
			<a href="#" title="WITS - 微智" class="tooltip"><img src="<c:url value='/images/wits-logo.png'/>" alt="WITS - 微智" /></a> 
		</div>
		<!-- End of Logo -->
		
		<div id="box">
			<div  id="error" class="message error close">
			</div>
			<div  id="success" class="message success close">
			</div>
			<span id="form">
				<form:form commandName="individualCommand" method="POST">
				<p class="main">
					<label>请填写注册信息（*号必填）</label>
				</p>
				<p class="main">
					<label>登录邮箱:&nbsp;&nbsp;*</label>
					<form:input path="loginName"/>
				</p>
				<p class="main">
					<label>密码:&nbsp;&nbsp;*</label>
					<form:password path="password"/>
				</p>
				<p class="main">
					<label>确认密码:&nbsp;&nbsp;*</label>
					<form:password path="passwordRepeat"/>
				</p>
				<p class="main">
					<label>用户名:&nbsp;&nbsp;*</label>
					<form:input path="userName"/>
				</p>
				<p class="main">
					<label>电话: </label>
					<form:input path="mobile"/>
				</p>
				<p class="space">
					<span><input type="checkbox" checked="true" />已阅读协议</span>
					<input id="submit" type="button" value="提交" class="login"/>
					<input id="cancel" type="button" value="取消" class="login"/>
				</p>
				</form:form>
			</span>
		</div>
		
	</div>

	</body>
</html>


