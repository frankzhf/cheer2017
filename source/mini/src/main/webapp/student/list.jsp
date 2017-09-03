<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>JSP -- 学生列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap-3.3.6/css/bootstrap.css">
<!--[if lt IE 9]
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>	
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/resources/jquery-1.11.1/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap-3.3.6/js/bootstrap.js"></script>
<style type="text/css">
</style>
</head>
<body>
	<div class="container">
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
						<input type="button" class="btn" 
							value="ajax">
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
					</tr>
					<c:if test="${empty store}">
						<tr>
							<td colspan="5">No record(s) Watch</td>
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
					</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
		</div>
	</div>
</body>
</html>