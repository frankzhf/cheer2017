<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"  %>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<html>
	<head>
		<title></title>
	</head>
	<body>
		<h1>系统登录</h1>
		<c:if test="${!empty errorMsg}">
			<div>${errorMsg}</div>
		</c:if>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<table width="60%">
				<tr>
					<td width="35%">用户名</td>
					<td><input type="text" id="userName" name="userName"></td>
				</tr>
				<tr>
					<td>密&nbsp;&nbsp;码</td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="登录">
						<input type="reset" value="清空">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>