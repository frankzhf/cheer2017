<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>

<layout:default title="分配角色">
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/role/">角色列表</a></li>
		<li class="active"><a href="${ctx}/sys/role/assign?id=${role.id}"><shiro:hasPermission name="sys:role:edit">角色分配</shiro:hasPermission><shiro:lacksPermission name="sys:role:edit">人员列表</shiro:lacksPermission></a></li>
	</ul>
	
	
	<div class="row">
		<div class="form-group col-sm-4">
			<label class="col-sm-4 control-label">角色名称: </label>
			<b>${role.name}</b>
		</div>
		<div class="form-group col-sm-4">
			<label class="col-sm-4 control-label">归属机构: </label>
			${role.office.name}
		</div>
		<div class="form-group col-sm-4">
			<label class="col-sm-4 control-label">英文名称: </label>
			${role.enname}
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-sm-4">
			<label class="col-sm-4 control-label">角色类型: </label>
			${role.roleType}
		</div>
		<div class="form-group col-sm-4">
			<label class="col-sm-4 control-label">数据范围: </label>
			<c:set var="dictvalue" value="${role.dataScope}" scope="page" />
			${fns:getDictLabel(dictvalue, 'sys_data_scope', '')}
		</div>
		<div class="form-group col-sm-4">
		</div>
	</div>
	<sys:message content="${message}"/>
	<div class="breadcrumb">
		<form id="assignRoleForm" action="${ctx}/sys/role/assignrole" method="post" class="hide">
			<input type="hidden" name="id" value="${role.id}"/>
			<input id="idsArr" type="hidden" name="idsArr" value=""/>
		</form>
		<input id="assignButton" class="btn btn-primary" type="submit" value="分配角色"/>
		<script type="text/javascript">
			$("#assignButton").click(function(){
				var url = '${ctx}/sys/role/usertorole?id=${role.id}';
		        var d = top.dialog({
					title: '分配角色',
					url: url,
					width: 810,
					height: 650,
					button:[{
						id:"btnOk",
						value:"确定分配",
						autofocus :true,
						callback:function(event){
							var iframeWindow = this.iframeNode.contentWindow;
							var pre_ids = iframeWindow.pre_ids;
							var ids = iframeWindow.ids;
							if (ids[0] == '') {
							    ids.shift();
							    pre_ids.shift();
							}
							if (pre_ids.sort().toString() == ids.sort().toString()) {
								alertx("未给角色【${role.name}】分配新成员！");
							    //top.alert("", 'info');
							    return false;
							}
							var idsArr = "";
							for (var i = 0; i < ids.length; i++) {
								idsArr = (idsArr + ids[i]) + (((i + 1) == ids.length) ? '' : ',');
							}
							$('#idsArr').val(idsArr);
							$('#assignRoleForm').submit();
							return true;
						}
					},{
						id:"btnClear",
						value:"清除",
						callback:function(event){
							var iframeWindow = this.iframeNode.contentWindow;
							iframeWindow.clearAssign();
							return false;
						}
					},{
						id:"btnClose",
						value:"取消",
						callback:function(event){
						}
					}]
		        });
		        d.showModal();
			});
		</script>
	</div>
	<table id="contentTable" class="table table-hover">
		<thead><tr><th>归属公司</th><th>归属部门</th><th>登录名</th><th>姓名</th><th>电话</th><th>手机</th><shiro:hasPermission name="sys:user:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.company.name}</td>
				<td>${user.office.name}</td>
				<td><a href="${ctx}/sys/user/form?id=${user.id}">${user.loginName}</a></td>
				<td>${user.name}</td>
				<td>${user.phone}</td>
				<td>${user.mobile}</td>
				<shiro:hasPermission name="sys:role:edit"><td>
					<a href="${ctx}/sys/role/outrole?userId=${user.id}&roleId=${role.id}" 
						onclick="return confirmx('确认要将用户<b>[${user.name}]</b>从<b>[${role.name}]</b>角色中移除吗？', this.href)">移除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</layout:default>

