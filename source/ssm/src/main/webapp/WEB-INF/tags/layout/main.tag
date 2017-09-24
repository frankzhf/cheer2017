<%@tag language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="containerId" required="false" type="java.lang.String" %>

<c:set var="_containerId" />
<c:if test="${empty containerId}">
	<c:set var="_containerId" value="minisContainer" />	
</c:if>
<c:if test="${!empty containerId}">
	<c:set var="_containerId" value="${containerId}" />
</c:if>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>学生管理系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap-3.3.6/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap-3.3.6/css/bootstrap-theme.css">
<script
	src="${pageContext.request.contextPath}/resources/jquery-1.11.1/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/bootstrap-3.3.6/js/bootstrap.min.js"></script>

<style type="text/css">
body {
  padding-top: 50px;
}
.starter-template {
  padding: 40px 15px;
  text-align: center;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">
					Spring SpringMVC Mybatis - Student Management System</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container" id="${_containerId}" >
		<div class="starter-template">
			<jsp:doBody />
		</div>
	</div>
</body>
</html>