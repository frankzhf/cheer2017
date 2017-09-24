<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<layout:default title="资产品类新增|编辑">
	
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
		<li><a href="${ctx}/assets/category">资产品类列表</a></li>
		<li class="active" ><a href="${ctx}/assets/category/form">资产品类新增|编辑</a></li>
	</ul>
	<br/>
	<form:form id="inputForm" modelAttribute="entity" action="${ctx}/assets/category/save" method="post" class="form-horizontal">
		<sys:message content="${message}"/>
		<form:hidden path="id"/>
		<form:hidden path="createBy"/>
		<input type="hidden" name="createDate" 
				value="<fmt:formatDate value='${entity.createDate}' pattern='yyyy-MM-dd HH:mm:ss'/>">
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">上级品类:</label>
				<div class="input-group">
					<sys:treeselect id="assets_categroy" name="parentId" value="${entity.parentId}" labelName="extention_parentId" labelValue="${parent.name}"
						title="品类" url="/assets/category/treeData" extId="${entity.id}" cssClass="" allowClear="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">资产品类名称:</label>
				<div class="input-group">
					<form:input path="name" htmlEscape="false" maxlength="50" class="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">资产品类代码前缀:</label>
				<div class="input-group">
					<form:input path="bnsPre" htmlEscape="false" maxlength="50" class="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
		</div>
		<div class="box-footer">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</layout:default>