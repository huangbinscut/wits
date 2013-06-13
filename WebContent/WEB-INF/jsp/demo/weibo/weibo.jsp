<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Weibo 整合教程</title>
	
		<!-- Libraries -->
		<link href="<c:url value='/css/layout.css'/>" rel="stylesheet" type="text/css" media="all"></link>

		<script type="text/javascript" src="<c:url value='/js/easyTooltip.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.7.2.custom.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery.wysiwyg.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/hoverIntent.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/superfish.js'/>"></script>
		
		<!-- End of Libraries -->	
</head>
<body>
<input type="hidden" name="token" id="token" value="${token}"> 

<h3>Weibo 整合</h3>
<p>连接新浪微博</p>
	<a href="#" id="weiboLink">显示用户信息</a>
	<hr><br>
	<a href="#" id="timeline">显示用户weibo</a>
	<hr><br>
	<a href="#" id="clearToken">清除Token</a>
	<hr><br>
	<span id="info">(Result will be shown here)</span>

<hr><br>
<!-- Dialog -->
<div id="dialog" title="创造/分享信息!"> 
	<iframe src="https://api.weibo.com/oauth2/authorize?client_id=2966054766&redirect_uri=http://127.0.0.1/wits/demo/weibo/toauth&response_type=code" id="c-c-iframe" name="c-c-iframe" width="500px;"  frameborder="0" scrolling="no" marginwidth="0" marginheight="0"></iframe>
	<input type="hidden" name="recallfunc" id="recallfunc" value="">
</div>
<!-- End of Dialog -->
							

<hr><br>
<a href="<c:url value='/demo'/>">返回</a>
<hr><br>
<script type="text/javascript"> 

$(function() {
	
	// Dialog			
	$('#dialog').dialog({
		autoOpen: false,
		modal: true,
		width: 500,
		buttons: {
			"Ok": function() { 
				$(this).dialog("close"); 
				
			}, 
			"Cancel": function() { 
				$(this).dialog("close"); 
			} 
		},
			
		close: function() {
			eval($("#recallfunc").val);
		}
		
	});
		
	
	$("#c-c-iframe").load(function(){         
	    $(this).height($(this).contents().find("#content").height() + 400);  
	    $(this).width(800);
	});  
	
	
	
	$("#weiboLink").click(function(){	  
		showUser(1739851340);
	});	 
	
	$("#timeline").click(function(){	  
		timeline();
	});	 
	
	$("#clearToken").click(function(){	  
		clearToken();
	});	 
	
});


function getUrlParam(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r!=null) return unescape(r[2]); return null; //返回参数值
} 

function showAuth(recallfunc) {
	var data = "https://api.weibo.com/oauth2/authorize?client_id=2966054766&redirect_uri=http://127.0.0.1/wits/demo/weibo/toauth&response_type=code";
	//$("#c-c-iframe").src(data);
	$("#recallfunc").val(recallfunc);
	$('#dialog').dialog('open');
	return true;
}

function showUser(userId) {
	$.post("/wits/demo/weibo/showuser/"+userId,
			null,
			function(data){	
				if (data == "invalid token") {
					showAuth("showUser("+userId+")");
				} else {

				    var info = data;	
				    //$.each(data,function(index,entity) { 
				     	//info += "姓名: " + entity.name+",年龄: " + entity.age + ",地址: " + entity.address + ",性别: " + (entity.sex == 1 ? "男" : "女")+",密码: " + entity.password+"<br>";   
				    //});
				    $("#info").html(info);
				}
			});
}

function timeline() {
	$.post("/wits/demo/weibo/timeline",
			null,
			function(data){	
				if (data == "invalid token") {
					showAuth("timeline()");
				} else {

				    var info = data;	
				    //$.each(data,function(index,entity) { 
				     	//info += "姓名: " + entity.name+",年龄: " + entity.age + ",地址: " + entity.address + ",性别: " + (entity.sex == 1 ? "男" : "女")+",密码: " + entity.password+"<br>";   
				    //});
				    $("#info").html(info);
				}
			});
}

function clearToken() {
	$.post("/wits/demo/weibo/cleartoken",
			null,
			function(data){	
				$("#info").html("token has been cleared");
			});
}

</script>
</body>
</html>