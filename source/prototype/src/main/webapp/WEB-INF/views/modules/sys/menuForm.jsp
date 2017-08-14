<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
	
<layout:default title="菜单管理">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					renderErrorMsg(error,element);
				}
			});
		});
	</script>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/menu/">菜单列表</a></li>
		<li class="active"><a href="${ctx}/sys/menu/form?id=${menu.id}&parent.id=${menu.parent.id}">菜单<shiro:hasPermission name="sys:menu:edit">${not empty menu.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:menu:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="menu" 
		action="${ctx}/sys/menu/save" method="post" class="form-horizontal">
		<sys:message content="${message}"/>
		<form:hidden path="id"/>
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">上级菜单:</label>
				<div class="input-group">
	                <sys:treeselect id="menu" name="parent.id" value="${menu.parent.id}" labelName="parent.name" labelValue="${menu.parent.name}"
						title="菜单" url="/sys/menu/treeData" extId="${menu.id}" cssClass="required"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">名称:</label>
				<div class="input-group">
					<form:input path="name" htmlEscape="false" maxlength="50" class="required input-xlarge"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">链接:</label>
				<div class="controls">
					<form:input path="href" htmlEscape="false" maxlength="2000" class="input-xxlarge"/>
					<span class="help-inline">点击菜单跳转的页面</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">目标:</label>
				<div class="controls">
					<form:input path="target" htmlEscape="false" maxlength="10" class="input-small"/>
					<span class="help-inline">链接地址打开的目标窗口，默认：mainFrame</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">图标:</label>
				<div class="input-group">
					<sys:iconselect id="icon" name="icon" value="${menu.icon}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">排序:</label>
				<div class="input-group">
					<form:input path="sort" htmlEscape="false" maxlength="50" class="required digits input-small"/>
					<span class="help-inline">排列顺序，升序。</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">可见:</label>
				<div class="input-group">
					<form:radiobuttons path="isShow" items="${fns:getDictList('show_hide')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
					<span class="help-inline">该菜单或操作是否显示到系统菜单中</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">权限标识:</label>
				<div class="input-group">
					<form:input path="permission" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
					<span class="help-inline">控制器中定义的权限标识，如：@RequiresPermissions("权限标识")</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注:</label>
				<div class="input-group">
					<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xxlarge"/>
				</div>
			</div>
		</div>
		<div class="box-footer">
			<shiro:hasPermission name="sys:menu:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</layout:default>	
