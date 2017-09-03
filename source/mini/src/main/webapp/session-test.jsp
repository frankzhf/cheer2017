<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
	<title>Session-test</title>
</head>
<body>
<%
	String _h1Value = "Session Test!";
%>
<H1><%=_h1Value%></H1>

<%
	String prevAaa = session.getAttribute("aaa").toString();
%>

<div><%=prevAaa%>></div>

</body>
</html>