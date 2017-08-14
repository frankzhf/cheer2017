<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>

<layout:default title="个人信息">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					renderErrorMsg(error, element);
				}
			});
		});
	</script>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/user/info">个人信息</a></li>
		<li><a href="${ctx}/sys/user/modifyPwd">修改密码</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/info" method="post" class="form-horizontal">
		<sys:message content="${message}"/>
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">头像:</label>
				<div class="input-group">
					<form:hidden id="nameImage" path="photo" htmlEscape="false" maxlength="255" class="input-xlarge"/>
					<sys:ckfinder input="nameImage"  type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100" maxHeight="100"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">归属公司:</label>
				<div class="input-group">
					${user.company.name}
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">归属部门:</label>
				<div class="input-group">
					${user.office.name}
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">姓名:</label>
				<div class="input-group">
					<form:input path="name" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">邮箱:</label>
				<div class="input-group">
					<form:input path="email" htmlEscape="false" maxlength="50" class="email"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">电话:</label>
				<div class="input-group">
					<form:input path="phone" htmlEscape="false" maxlength="50" class=""/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">手机:</label>
				<div class="input-group">
					<form:input path="mobile" htmlEscape="false" maxlength="50" class=""/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注:</label>
				<div class="input-group">
					<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">用户类型:</label>
				<div class="input-group">
					${fns:getDictLabel(user.userType, 'sys_user_type', '无')}
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">用户角色:</label>
				<div class="input-group">
					${user.roleNames}
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">上次登录:</label>
				<div class="input-group">
					IP: ${user.oldLoginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.oldLoginDate}" type="both" dateStyle="full"/>
				</div>
			</div>
		</div>
		<div class="box-footer">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
		</div>
	</form:form>
</layout:default>