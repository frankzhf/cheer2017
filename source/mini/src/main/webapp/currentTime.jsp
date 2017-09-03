<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
<%@ page import="java.util.Date" %>
<%@ page import="com.cheer.mini.Student" %>


<jsp:useBean id="aaa" class="java.util.Date" scope="application" />


<jsp:useBean id="student" class="com.cheer.mini.Student">
</jsp:useBean>

<jsp:setProperty property="name" name="student" value="zhangsan" />
<jsp:setProperty property="age" name="student" value="17" />

<%
	Student item = (Student)pageContext.getAttribute("student");
	if(item.getAge()  >=18){
%>
<jsp:forward page="welcome.jsp" />
<% 

	}else{

%>
<jsp:forward page="notice.jsp" />
<%
	}
%>

