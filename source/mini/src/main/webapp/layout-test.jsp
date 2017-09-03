<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:blank title="测试布局" containerId="testContainerId">
	<script>
		$(function(){
			var container = $("#testContainerId");
			console.log(container);
		});
	</script>
	<h1>Hello Tag!</h1>
</layout:blank>