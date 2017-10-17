<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld"%>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld"%>

<layout:default title="资产列表">
	<script type="text/javascript">
		function createAssets() {
			$("#searchForm").attr("action", "${ctx}/assets/form");
			$("#searchForm").submit();
		}
		$(function() {
			$(".btnStatusNormal").click(function() {
				var assetsId = $(this).attr("data");
				console.log(assetsId);
				var requestBody = {
					"assetsId" : assetsId
				};
				$.ajax({
					type : "post",
					url : "${ctx}/assets/status/normal",
					contextType : "json",
					data : requestBody,
					dataType : "json",
					success : function(response) {
						$("#searchForm").submit();
					},
					error : function(e) {
						console.log(e)
					}
				});
			});

			$(".btnDepreciation").click(function() {
				var assetsId = $(this).attr("data");
				console.log(assetsId);
				var requestBody = {
					"assetsId" : assetsId,
					"deratingValue" : 0
				};
				var d = top.dialog({
					title : '折旧',
					url : '${ctx}/assets/dialog/derating',
					height : 60,
					width : 180,
					okValue : '确定',
					ok : function() {
						var iframeWindow = this.iframeNode.contentWindow;
						var deratingVal = iframeWindow.document.getElementById("deratingValue").value;
						if (deratingVal != null
								&& deratingVal != ""
								&& deratingVal != "0") {
							requestBody.deratingValue = deratingVal;
							$.ajax({
								type:"post",
								url:"${ctx}/assets/finance/derating",
								contextType:"json",
								data : requestBody,
								dataType: "json", 
								success: function(response){
									alert("资产折旧成功");
								},
								error : function(e){
									console.log(e)
								}
							});
						} else {
							top.alert("折旧值不能为空或0!");
							return false;
						}
					},
					cancelValue : '取消',
					cancel : function() {
					}
				});
				d.showModal();
			});
			
			$(".btnBorrow").click(function() {
				var assetsId = $(this).attr("data");
				console.log(assetsId);
				var requestBody = {
					"assetsId" : assetsId,
					"dutyId" : null
				};
				var url = '${ctx}/tag/treeselect?url=' + encodeURIComponent("/sys/office/treeData?type=3");
				var d = top.dialog({
					title : '借出',
					url : url,
					height : 250,
					width : 400,
					okValue : '确定',
					ok : function() {
						var iframeWindow = this.iframeNode.contentWindow;
						var tree = iframeWindow.tree;
						var nodes = [];
						nodes = tree.getSelectedNodes();
						if(nodes != null && nodes.length>0){
							var node = null;
							for (var i = 0; i < nodes.length; i++) {
								if (nodes[i].level == 0) {
									top.alert("不能选择根节点（" + nodes[i].name + "）请重新选择。");
									return false;
								}
								if (nodes[i].isParent) {
									top.alert("不能选择父节点（" + nodes[i].name + "）请重新选择。");
									return false;
								}
								node = nodes[i];
			                    break; // 如果为非复选框选择，则返回第一个选择
			                }
							if(node!=null){
								requestBody.dutyId = node.id.substring(2);
								$.ajax({
									type:"post",
									url:"${ctx}/assets/borrow",
									contextType:"json",
									data : requestBody,
									dataType: "json", 
									success: function(response){
										alert("资产借出成功");
										$("#searchForm").submit();
									},
									error : function(e){
										console.log(e)
									}
								});
							}
						}else{
							return false;
						}
					},
					cancelValue : '取消',
					cancel : function() {
					}
				});
				d.showModal();
				
			});

			$(".btnStatusDis").click(function() {
				var assetsId = $(this).attr("data");
				console.log(assetsId);
				var requestBody = {
					"assetsId" : assetsId
				};
				$.ajax({
					type : "post",
					url : "${ctx}/assets/status/disabled",
					contextType : "json",
					data : requestBody,
					dataType : "json",
					success : function(response) {
						console.log(assetsId);
						$("#searchForm").submit();
					},
					error : function(e) {
						console.log(e)
					}
				});
			});
			
			
			$(".btnDetails").click(function() {
				var assetsId = $(this).attr("data");
				console.log(assetsId);
				var url = '${ctx}/assets/details?assetsId=' + assetsId;
				var d = top.dialog({
					title : '资产详情',
					url : url,
					height : 480,
					width : 700,
					cancelValue : '取消',
					cancel : function() {
					}
				}).showModal();
			});
		});
	</script>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/assets">资产品表</a></li>
		<li><a href="#" onclick="createAssets()">添加资产订购</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="form" action="${ctx}/assets"
		method="post" class="row form-horizontal well" role="form">
		<input id="pageNo" name="pageInfo.current" type="hidden"
			value="${form.pageInfo.current}" />
		<input id="pageSize" name="pageInfo.pageSize" type="hidden"
			value="${form.pageInfo.pageSize}" />

		<sys:message content="${message}" />
		<table id="contentTable" class="table table-hover">
			<thead>
				<tr>
					<th>资产编号</th>
					<th>资产名称</th>
					<th>资产描述</th>
					<th>状态</th>
					<th>订购价格</th>
					<th>订购日期</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty form.list}">
					<c:forEach items="${form.list}" var="assets">
						<tr>
							<td>${assets.bnsId}</td>
							<td>${assets.name}</td>
							<td>${assets.desc}</td>
							<td>${fns:getDictLabel(assets.status,'asset_phase','')}</td>
							<td>${assets.sellPrice}</td>
							<td><fmt:formatDate value="${assets.sellDate}"
									pattern="yyyy-MM-dd" /></td>
							<td><c:if test="${'P' eq assets.status}">
									<a href="#" data="${assets.id}" class="btnStatusNormal">采购入库</a>
								</c:if> <c:if test="${'N' eq assets.status}">
									<a href="#" data="${assets.id}" class="btnDepreciation">折旧...</a>
									<c:if test="${empty assets.dutyBy}">
									&nbsp;<a href="#" data="${assets.id}" class="btnBorrow">借用...</a>
									</c:if>                
								</c:if>
								&nbsp;<a href="#" data="${assets.id}" 
									class="btnDetails">详情</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty form.list}">
					<tr>
						<td colspan="7">没有资产记录</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<div class="box-tools">
			<ui:newPagination value="${form.pageInfo}" dataUrl="${ctx}/assets" />
		</div>
	</form:form>
</layout:default>