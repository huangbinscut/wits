<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
</head>
<body>
<a href="<c:url value='/demo/user'/>">用户列表</a>

<a href="<c:url value='/demo/ajax/ajaxpage'/>">ajax demo 1</a>
<a href="<c:url value='/demo/ajax/ajaxPage2'/>">ajax demo 2</a>

<a href="<c:url value='/demo/weibo/weibo'/>">weibo demo </a>
</body>
</html>