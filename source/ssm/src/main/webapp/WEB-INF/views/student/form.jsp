<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<layout:main>
	<div class="row">
		<div class="col-md-12">
			<sf:form modelAttribute="view" method="post"
				action="${pageContext.request.contextPath}/student/save" 
				class="form-horizontal">
				<sf:hidden path="pageInfo.pageNo"/>
				<sf:hidden path="pageInfo.pageSize"/>
				<sf:hidden path="pageInfo.total"/>
				<sf:hidden path="pageInfo.count"/>
				
				<div class="form-group">
					<label class="control-label">学生姓名</label>
					<sf:input path="editor.name" cssClass="form-control"
						placeholder="请输入学生的姓名" />
				</div>
				<div class="form-group">
					<label class="control-label">学生学号</label>
					<sf:input path="editor.stuNo" cssClass="form-control"
						placeholder="请输入学生的学号" />
				</div>
				<div class="form-group">
					<label class="control-label">学生性别</label>
					<sf:input path="editor.sex" cssClass="form-control"
						placeholder="请输入学生的性别" />
				</div>
				<div class="form-group">
					<label class="control-label">出生日期</label>
					<sf:input path="editor.birthday" cssClass="form-control"
						placeholder="请输入学生的出生日期" />
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" 
						value="保存">
					<input type="button" class="btn" 
						value="取消">
				</div>
			</sf:form>
		</div>
	</div>
</layout:main>
