<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<layout:default title="日志管理">
	<%@ include file="/WEB-INF/views/include/daterange.jsp"%>
	<script type="text/javascript">
		function page(n, s) {
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
			return false;
		}
	</script>
	<!-- 	<ul class="nav nav-tabs"> -->
	<%-- 		<li class="active"><a href="${ctx}/sys/log/">日志列表</a></li> --%>
	<!-- 	</ul> -->
	<form:form id="searchForm" action="${ctx}/sys/log/" method="post"
		class="row form-horizontal well">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />

		<div class="row">
			<div class="form-group col-sm-4">
				<label class="col-sm-4 control-label">操作菜单：</label>
				<div class="col-sm-8">
					<input id="title" name="title" type="text" maxlength="50"
						value="${log.title}" class="form-control" />
				</div>
			</div>
			<div class="form-group col-sm-4">
				<label class="col-sm-4 control-label">用户ID：</label>
				<div class="col-sm-8">
					<input id="createBy.id" name="createBy.id" type="text"
						maxlength="50" value="${log.createBy.id}" class="form-control" />

				</div>
			</div>
			<div class="form-group col-sm-4">
				<label class="col-sm-4 control-label">URI：</label>
				<div class="col-sm-8">
					<input id="requestUri" name="requestUri" type="text" maxlength="50"
						value="${log.requestUri}" class="form-control" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-4">
				<label class="col-sm-4 control-label">日期范围：</label>
				<div class="col-sm-8">
					<sys:daterange beginDateName="beginDate" endDateName="endDate"
						beginDate="${log.beginDate}" endDate="${log.endDate}" />
				</div>
			</div>
			<div class="form-group col-sm-4">
				<label class="col-sm-4 control-label"> <input id="exception"
					name="exception" type="checkbox"
					${log.exception eq '1'?'checked':''} value="1" /></label>
				<div class="col-sm-8">
					<label for="exception">只查询异常信息</label>
				</div>
			</div>
			<div class="form-group col-sm-4">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="查询" />
			</div>
		</div>
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable" class="table table-hover">
		<thead>
			<tr>
				<th>操作菜单</th>
				<th>操作用户</th>
				<th>所在公司</th>
				<th>所在部门</th>
				<th>URI</th>
				<th>提交方式</th>
				<th>操作者IP</th>
				<th>操作时间</th>
		</thead>
		<tbody>
			<c:set var="strEnter" value="\n" />
			<c:set var="strTab" value="\t" />
			<c:forEach items="${page.list}" var="log">
				<tr>
					<td>${log.title}</td>
					<td>${log.createBy.name}</td>
					<td>${log.createBy.company.name}</td>
					<td>${log.createBy.office.name}</td>
					<td><strong>${log.requestUri}</strong></td>
					<td>${log.method}</td>
					<td>${log.remoteAddr}</td>
					<td><fmt:formatDate value="${log.createDate}" type="both" /></td>
				</tr>
				<c:if test="${not empty log.exception}">
					<tr>
						<td colspan="8"
							style="word-wrap: break-word; word-break: break-all;">
							<%-- 					用户代理: ${log.userAgent}<br/> --%> <%-- 					提交参数: ${fns:escapeHtml(log.params)} <br/> --%>
							异常信息: <br />
							${fn:replace(fn:replace(fns:escapeHtml(log.exception), strEnter, '<br/>'), strTab, '&nbsp; &nbsp; ')}
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<div class="box-tools">
		<sys:pagination object="${page}" />
	</div>
</layout:default>