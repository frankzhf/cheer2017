<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<layout:blank title="选择地区">
	<%@include file="/WEB-INF/views/include/treeview.jsp" %>
	<script type="text/javascript">
		var key, lastValue = "", nodeList = [];
		var tree, 
		setting = {
			view:{
				selectedMulti:false,
				dblClickExpand:false
			},
			check:{
				enable:false,
				nocheckInherit:true
			},
			async:true,
			data:{simpleData:{enable:true}},callback:{
				onClick:function(event, treeId, treeNode){
					$.get("${ctx}/dialog/area/get?areaId=" + treeNode.id,function(data){
						if(parseInt(data.type) < ${scope}){
							if(treeNode.level !=3  && (treeNode.children == null || treeNode.children.length == 0)){
								$.get("${ctx}/dialog/area/tree/children/" + treeNode.id + "?"
										+ new Date().getTime(), function(zNodes){
									if(zNodes!=null){
										tree.addNodes(treeNode,zNodes,false);
									}
								});
							}
						}
					});
				},onCheck: function(e, treeId, treeNode){
					var nodes = tree.getCheckedNodes(true);
					for (var i=0, l=nodes.length; i<l; i++) {
						tree.expandNode(nodes[i], true, false, false);
					}
					return false;
				},onAsyncSuccess: function(event, treeId, treeNode, msg){
					var nodes = tree.getNodesByParam("pId", treeNode.id, null);
					for (var i=0, l=nodes.length; i<l; i++) {
						try{tree.checkNode(nodes[i], treeNode.checked, true);}catch(e){}
					}
					selectCheckNode();
				},onDblClick: function(){
					top.$.jBox.getBox().find("button[value='ok']").trigger("click");
				}
			}
		};
		
		$(document).ready(function(){
			$.get("${ctx}/dialog/area/tree?"
					+ new Date().getTime(), function(zNodes){
				tree = $.fn.zTree.init($("#tree"), setting, zNodes);
				var nodes = tree.getNodesByParam("level", 0);
				for(var i=0; i<nodes.length; i++) {
					tree.expandNode(nodes[i], true, false, false);
				}
				var nodesOne = tree.getNodesByParam("isParent", true);
				for(var j=0; j<nodesOne.length; j++) {
					tree.reAsyncChildNodes(nodesOne[j],"!refresh",true);
				}
				selectNode();
			});
		});
		
		// 默认选择节点
		function selectNode(){
			var _selectNodeParentIds = null;
			<c:if test="${!empty selectArea}">
			_selectNodeParentIds = "${selectArea.parentIds}";
			</c:if>
			if(_selectNodeParentIds!=null){
				var parentIds = _selectNodeParentIds.split(",");
				if(parentIds.length<3){
					var node = tree.getNodeByParam("id", '${selectArea.id}');
					tree.selectNode(node, true);
				}else{
					var parentId = ${scope=='3'?'parentIds[1]':'parentIds[2]'} ;
					var treeNode = tree.getNodeByParam("id", parentId);
					$.get("${ctx}/dialog/area/tree/children/" + parentId + "?"
							+ new Date().getTime(), function(zNodes){
						if(zNodes!=null){
							tree.addNodes(treeNode,zNodes,false);
							node = tree.getNodeByParam("id", '${selectArea.id}');
							if(node == null){
								parentId = parentIds[3];
								$.get("${ctx}/dialog/area/tree/children/" + parentId + "?"
										+ new Date().getTime(), function(zNodes0){
									treeNode = tree.getNodeByParam("id", parentId);
									tree.addNodes(treeNode,zNodes0,false);
									node = tree.getNodeByParam("id", '${selectArea.id}');
									tree.selectNode(node, true);
								});
							}else{
								tree.selectNode(node, true);
							}
						}
					});
				}
			}
		}
	</script>
	<div id="tree" class="ztree" style="padding:15px 20px;"></div>
</layout:blank>