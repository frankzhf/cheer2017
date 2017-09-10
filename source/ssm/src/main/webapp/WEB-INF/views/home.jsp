<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
	
home.jsp

<html>
	<head>
		<title></title>
	</head>
	<body>
		<h1>home.jsp</h1>
		<form action="${pageContext.request.contextPath}/ping" method="post">
			<input type="submit" value="postPing">
		</form>
	</body>
</html>