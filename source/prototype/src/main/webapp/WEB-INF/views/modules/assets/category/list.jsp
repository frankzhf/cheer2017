<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>

<layout:default title="资产品类列表">
	<link href="${ctxStatic}/treeTable/themes/vsStyle/treeTable.min.css" rel="stylesheet" type="text/css" />
	<script src="${ctxStatic}/treeTable/jquery.treeTable.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var tpl = $("#treeTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
			var data = ${fns:toJson(list)}, rootId = "0";
			addRow("#treeTableList", tpl, data, rootId, true,1);
			$("#treeTable").treeTable({
				expandLevel : 3,
				beforeExpand : function($treeTable, id){
					for(var i=0;i<data.length;i++){
						if(data[i]['parentId']===id){
							var dId = data[i].id;
							var finder = $("#"+dId,$("#treeTableList"));
							if(finder.length < 1){
								var insertHtml =
									Mustache.render(tpl, {
										 pid:data[i].parentId , row: data[i]
									});
								$treeTable.addChilds(insertHtml);
							}
						}	
					}
				},
				onSelect : function($treeTable, id){
					return true;
				}
			});
			
			function addRow(list, tpl, data, pid, root,level){
				for (var i=0; i<data.length; i++){
					var row = data[i];
					if ((${fns:jsGetVal('row.parentId')}) == pid){
						$(list).append(Mustache.render(tpl, {
							 pid: (root?0:pid), row: row
						}));
						if( level < 3 ){
							var tpl2 = $("#treeTableTplHasChild").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
							addRow(list, tpl2, data, row.id,null,level+1);
						}
					}
				}
			}
			
			
		});
	</script>
	
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/assets/category">资产品类列表</a></li>
		<li><a href="${ctx}/assets/category/form">资产品类添加</a></li>
	</ul>
	<sys:message content="${message}"/>
	<table id="treeTable" class="table table-hover">
		<thead>
			<tr>
				<th>资产品类名称</th>
				<th>资产品类代码前缀</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="treeTableList"></tbody>
	</table>
	
	<script type="text/template" id="treeTableTpl">
		<tr id="{{row.id}}" pId="{{pid}}">
			<td><a href="${ctx}/assets/category/form?id={{row.id}}">{{row.name}}</a></td>
			<td>{{row.bnsPre}}</td>
			<td>
				<a href="${ctx}/assets/category/form?id={{row.id}}">修改</a>
				<a href="${ctx}/assets/category/delete?id={{row.id}}" onclick="return confirmx('要删除该品类及所有子品类项吗？', this.href)">删除</a>
				<a href="${ctx}/assets/category/form?parentId={{row.id}}">添加下级品类</a> 
			</td>
		</tr>
	</script>
	<script type="text/template" id="treeTableTplHasChild">
		<tr id="{{row.id}}" pId="{{pid}}" haschild="true">
			<td><a href="${ctx}/assets/category/form?id={{row.id}}">{{row.name}}</a></td>
			<td>{{row.bnsPre}}</td>
			<td>
				<a href="${ctx}/assets/category/form?id={{row.id}}">修改</a>
				<a href="${ctx}/assets/category/delete?id={{row.id}}" onclick="return confirmx('要删除该品类及所有子品类项吗？', this.href)">删除</a>
				<a href="${ctx}/assets/category/form?parentId={{row.id}}">添加下级品类</a> 
			</td>
		</tr>
	</script>
</layout:default>