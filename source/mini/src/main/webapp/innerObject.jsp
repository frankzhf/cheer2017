<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
	<title>HTML sample</title>
</head>
<body>
<%
	public String sayName(){
		return "innerObject.jsp";
	}
%>
	<%
	String abe = "aab";
	System.out.println("aab");
	pageContext.setAttribute("aaaa", new Object);
	request.getAttribute("aab");
	session.getAttribute("aaa");
	
	response.setContentType("applcation/excel");
	out.print("<h1>out</h1>");
	application.getAttribute("aaa");
	config.getInitParameter("appStatus");
	//page.
%>
</body>
</html>