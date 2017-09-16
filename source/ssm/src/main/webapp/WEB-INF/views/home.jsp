<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<layout:main>
	
	<sf:form modelAttribute="student" action="${pageContext.request.contextPath}/student/form">
		姓名：<sf:input path="name"/> <br>
		学号：<sf:input path="stuNo"/> <br>
		
		<input type="submit" value="提交" >
		<input type="button" value="ajax" onclick="testAjax()" >
	</sf:form>
	
	<script type="text/javascript">
	function testAjax(){
		var stuParam = {
			name:"王五",
			stuNo:"100003"
		};
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/student/ajax",
			contentType:"application/json",
			data : stuParam,
			dataType: "json", 
			success: function(response){
				console.log(response);
			},
			error :function(error){
				
			}
		});
	}
	</script>
	
</layout:main>