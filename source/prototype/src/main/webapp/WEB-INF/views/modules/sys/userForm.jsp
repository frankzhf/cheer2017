<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<layout:default title="用户管理">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#no").focus();
			$("#inputForm").validate({
				rules: {
					loginName: {remote: "${ctx}/sys/user/checkLoginName?oldLoginName=" + encodeURIComponent('${user.loginName}')}
				},
				messages: {
					loginName: {remote: "用户登录名已存在"},
					confirmNewPassword: {equalTo: "输入与上面相同的密码"}
				},
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
		<li><a href="${ctx}/sys/user/list">用户列表</a></li>
		<li class="active"><a href="${ctx}/sys/user/form?id=${user.id}">用户
		<shiro:hasPermission name="sys:user:edit">${not empty user.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/save" method="post" class="form-horizontal">
		<sys:message content="${message}"/>
		<form:hidden path="id"/>
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">头像:</label>
				<div class="input-group">
					<form:hidden id="nameImage" path="photo" htmlEscape="false" maxlength="255" class="input-xlarge"/>
					<sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100" maxHeight="100"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">归属公司:</label>
				<div class="input-group">
	                <sys:treeselect id="company" name="company.id" value="${user.company.id}" labelName="company.name" labelValue="${user.company.name}"
						title="公司" url="/sys/office/treeData?type=1" cssClass="required"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">归属部门:</label>
				<div class="input-group">
	                <sys:treeselect id="office" name="office.id" value="${user.office.id}" labelName="office.name" labelValue="${user.office.name}"
						title="部门" url="/sys/office/treeData?type=2" cssClass="required" notAllowSelectParent="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">工号:</label>
				<div class="input-group">
					<form:input path="no" htmlEscape="false" maxlength="50" class="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">姓名:</label>
				<div class="input-group">
					<form:input path="name" htmlEscape="false" maxlength="50" class="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">登录名:</label>
				<div class="input-group">
					<input id="oldLoginName" name="oldLoginName" type="hidden" value="${user.loginName}">
					<form:input path="loginName" htmlEscape="false" maxlength="50" class="required userName"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">密码:</label>
				<div class="input-group">
					<input id="newPassword" name="newPassword" type="password" value="" maxlength="50" minlength="3" class="${empty user.id?'required':''}"/>
					<c:if test="${empty user.id}"><span class="help-inline"><font color="red">*</font> </span></c:if>
					<c:if test="${not empty user.id}"><span class="help-inline">若不修改密码，请留空。</span></c:if>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">确认密码:</label>
				<div class="input-group">
					<input id="confirmNewPassword" name="confirmNewPassword" type="password" value="" maxlength="50" minlength="3" equalTo="#newPassword" class="${empty user.id?'required':''}"/>
					<c:if test="${empty user.id}"><span class="help-inline"><font color="red">*</font> </span></c:if>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">邮箱:</label>
				<div class="input-group">
					<form:input path="email" htmlEscape="false" maxlength="100" class="email"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">电话:</label>
				<div class="input-group">
					<form:input path="phone" htmlEscape="false" maxlength="100"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">手机:</label>
				<div class="input-group">
					<form:input path="mobile" htmlEscape="false" maxlength="100"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">是否允许登录:</label>
				<div class="input-group">
					<form:select path="loginFlag">
						<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
					<span class="help-inline">“是”代表此账号允许登录，“否”则表示此账号不允许登录</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">用户类型:</label>
				<div class="input-group">
					<form:select path="userType" class="input-xlarge">
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('sys_user_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">用户角色:</label>
				<div class="input-group">
					<form:checkboxes path="roleIdList" items="${allRoles}" 
						itemLabel="name" itemValue="id" htmlEscape="false"
						class="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注:</label>
				<div class="input-group">
					<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>
				</div>
			</div>
			<c:if test="${!empty user.id}">
				<div class="form-group">
					<label class="col-sm-2 control-label">创建时间:</label>
					<div class="input-group">
						<fmt:formatDate value="${user.createDate}" type="both" dateStyle="full"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">最后登陆:</label>
					<div class="input-group">
						IP: ${user.loginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.loginDate}" type="both" dateStyle="full"/></label>
					</div>
				</div>
			</c:if>
		</div>
		<div class="box-footer">
			<shiro:hasPermission name="sys:user:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</layout:default>


	
