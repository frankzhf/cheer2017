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
			$("#searchForm").attr("action", "${ctx}/assets/mine");
			$("#searchForm").submit();
		}
		$(function() {
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
	<form:form id="searchForm" modelAttribute="form" action="${ctx}/mine"
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
							<td>
								<a href="#" data="${assets.id}"
									class="btnReturn">归还</a>
								<a href="#" data="${assets.id}" 
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
			<ui:newPagination value="${form.pageInfo}" dataUrl="${ctx}/mine" />
		</div>
	</form:form>
</layout:default>