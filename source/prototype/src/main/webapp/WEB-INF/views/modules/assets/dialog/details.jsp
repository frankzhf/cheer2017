<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld"%>

<layout:blank>
	<div class="row">
		<div class="col-sm-12">
			<table class="table table-hover"> 
				<tr>
					<td>资产编号</td>
					<td>${details.bnsId}</td>
					<td>资产名称</td>
					<td>${details.name}</td>
					<td>资产状态</td>
					<td>${fns:getDictLabel(details.status,'asset_phase','')}</td>
					<td rowspan="3">
						TODO media
					</td>
				</tr>
				<tr>
					<td>购置日期</td>
					<td><fmt:formatDate value="${details.sellDate}" pattern="yyyy-MM-dd" /></td>
					<td>购置价格</td>
					<td>${details.sellPrice}</td>
					<td>出借信息</td>
					<td>
						<c:if test="${empty details.dutyBy}">
							在库
						</c:if>
						<c:if test="${!empty details.dutyBy}">
							出借 (${details.lastBorrower})
						</c:if>
					</td>
				</tr>
				<tr>
					<td>资产描述</td>
					<td colspan="5">
						${details.desc}
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="#financeRecord" data-toggle="tab">财务记录</a></li>
		<li><a href="#transferRecord" data-toggle="tab">流转记录</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="financeRecord">
			<table class="table table-hover">
				<tr>
					<th>发生日期</th>
					<th>描述</th>
					<th>财务标记</th>
					<th>发生数额</th>
					<th>余额</th>
				</tr>
				<c:if test="${!empty details.financeRecordList}">
					<c:forEach items="${details.financeRecordList}" var="item" >
						<tr>
							<td><fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd" /></td>
							<td>${item.desc}</td>
							<td>${item.type eq "I" ? "进" : "出" }</td>
							<td>${item.turnover}</td>
							<td>${item.afterVal}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty details.financeRecordList}">
					<tr>
						<td colspan="5">没有记录</td>
					</tr>
				</c:if>
			</table>
		</div>
		<div class="tab-pane fade" id="transferRecord">
			<table class="table table-hover">
				<tr>
					<th>发生日期</th>
					<th>流转对像</th>
					<th>描述</th>
				</tr>
				<c:if test="${!empty details.transferRecordList}">
					<c:forEach items="${details.transferRecordList}" var="item" >
						<tr>
							<td><fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd" /></td>
							<td>${item.userName}</td>
							<td>${item.desc}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty details.transferRecordList}">
					<tr>
						<td colspan="3">没有记录</td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>
</layout:blank>