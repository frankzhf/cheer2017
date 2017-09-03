<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mini" uri="http://www.cheer.com/jsp/mini" %>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:blank title="JSP -- 学生列表">
	<mini:current format="dd-MM-yyyy" />
	<div class="row">
		<div class="col-md-12">
			<form action="${pageContext.request.contextPath}/student/save" 
				method="post" class="form-horizontal">
				<div class="form-group">
					<label class="control-label">学生姓名</label>
					<input id="name" name="name" type="text" class="form-control" 
						placeholder="请输入学生的姓名">
				</div>
				<div class="form-group">
					<label class="control-label">学生年龄</label>
					<input id="age" name="age" type="text" class="form-control" 
						placeholder="请输入学生的年龄">
				</div>
				<div class="form-group">
					<label class="control-label">学生身高</label>
					<input id="height" name="height" type="text" class="form-control" 
						placeholder="请输入学生的身高">
				</div>
				<div class="form-group">
					<label class="control-label">学生体重</label>
					<input id=weight name="weight" type="text" class="form-control" 
						placeholder="请输入学生的体重">
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" 
						value="保存">
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered">
				<tr>
					<th>标识</th>
					<th>姓名</th>
					<th>年龄</th>
					<th>身高</th>
					<th>体重</th>
					<th>操作</th>
				</tr>
				<c:if test="${empty store}">
					<tr>
						<td colspan="6">No record(s) Watch</td>
					</tr>	
				</c:if>
				
				<c:if test="${!empty store}">
					<c:forEach items="${store}" var="student" varStatus="loop">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.age}</td>
					<td>${student.heigth}</td>
					<td>${student.weight}</td>
					<td>
						<input type="button" value="删除" class="btn" onclick="deleteStudent('${student.id}')">
					</td>
				</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			
		});
		function deleteStudent(id){
			window.location = "${pageContext.request.contextPath}/student/delete?id=" + id;
		}
	</script>
</layout:blank>