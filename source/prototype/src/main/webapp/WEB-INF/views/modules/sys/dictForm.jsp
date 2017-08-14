<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>

<layout:default title="字典管理">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#value").focus();
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
		<li><a href="${ctx}/sys/dict/">字典列表</a></li>
		<li class="active"><a href="${ctx}/sys/dict/form?id=${dict.id}">字典<shiro:hasPermission name="sys:dict:edit">${not empty dict.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:dict:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="dict" 
		action="${ctx}/sys/dict/save" method="post" class="form-horizontal">
		<sys:message content="${message}"/>
		<form:hidden path="id"/>
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">键值:</label>
				<div class="input-group">
					<form:input path="value" htmlEscape="false" maxlength="50" class="required"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">标签:</label>
				<div class="input-group">
					<form:input path="label" htmlEscape="false" maxlength="50" class="required"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">类型:</label>
				<div class="input-group">
					<form:input path="type" htmlEscape="false" maxlength="50" class="required abc"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">描述:</label>
				<div class="input-group">
					<form:input path="description" htmlEscape="false" maxlength="50" class="required"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">排序:</label>
				<div class="input-group">
					<form:input path="sort" htmlEscape="false" maxlength="11" class="required digits"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注:</label>
				<div class="input-group">
					<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>
				</div>
			</div>
		</div>
		<div class="box-footer">
			<shiro:hasPermission name="sys:dict:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</layout:default>
