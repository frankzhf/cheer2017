<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%-- 
<c:if test=""></c:if>
<c:choose></c:choose>
<c:forEach></c:forEach>
<c:set var="varibleName" value="abc" scope="page|request|session|applcation"/>
<c:remove var="varibleName"/>
<c:redirect url=""/>

<fmt:formatDate />
<fmt:formatNumber />
--%>

<%
	//DateFormat df =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	Date currentTime = new Date();
	
	//String strDate = df.format(currentTime);
	pageContext.setAttribute("currentTime", currentTime);
%>