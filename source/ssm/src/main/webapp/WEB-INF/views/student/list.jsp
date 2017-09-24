<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<layout:main containerId="studentViewList">
	<div class="row">
		<div class="col-sm-12">
			<sf:form id="studentListForm" modelAttribute="view" 
				action="${pageContext.request.contextPath}/student/list" 
				method="post">
				<sf:hidden path="pageInfo.pageNo"/>
				<sf:hidden path="pageInfo.pageSize"/>
				<sf:hidden path="pageInfo.total"/>
				<sf:hidden path="pageInfo.count"/>
				<sf:hidden id="editId" path="editor.id"/>
				<table class="table">
					<tr>
						<th>学生姓名</th>
						<th>学号</th>
						<th>学生性别</th>
						<th>出生日期</th>
					</tr>
					
					<c:if test="${!empty view.data}">
						<c:forEach items="${view.data}" var="item" varStatus="loop">
						<tr>	
							<td><a href="#" onclick="editStudent(${item.id})">${item.name}</a></td>
							<td>${item.stuNo}</td>
							<td>${item.sex}</td>
							<td>${item.birthday}</td>
						</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty view.data}">
						<tr><td colspan="4">没有找到记录</td></tr>
					</c:if>
					
				</table>
			</sf:form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			TODO pagation
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<input type="button" class="btn btn-primary" value="增加记录" onclick="addStudent()">
		</div>
	</div>
	
	<script type="text/javascript">
	function addStudent(){
		$("#studentListForm").attr("action","${pageContext.request.contextPath}/student/form");
		$("#studentListForm").submit();
	}
	function editStudent(studentId){
		$("#studentListForm").attr("action","${pageContext.request.contextPath}/student/form");
		$("#editId").val(studentId);
		$("#studentListForm").submit();
	}
	</script>	
</layout:main>