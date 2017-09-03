<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
	<title>HTML sample</title>
</head>
<body>
<%
	String _h1Value = "Hellow JSP!";
%>
<H1><%=_h1Value%></H1>
<%@ include file="currentTime.jsp" %>
<a href="session-test.jsp">session-test.jsp</a>
</body>
</html>