<%@ tag language="java" pageEncoding="UTF-8"%>


<%@ attribute name="beginDateName" type="java.lang.String" required="true"
	description="开始日期的名字"%>
<%@ attribute name="endDateName" type="java.lang.String" required="true"
	description="结束日期的名字"%>
<%@ attribute name="id" type="java.lang.String" required="false"
	description="html元素ID"%>	
<%@ attribute name="beginDate" type="java.util.Date" required="false"
	description="开始日期"%>
<%@ attribute name="endDate" type="java.util.Date" required="false"
	description="结束日期"%>
<%@ attribute name="requried" type="java.lang.Boolean" required="false"
	description="是否可为空"%>
<%@ attribute name="format" type="java.lang.String" required="false"
	description="日期格式"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empty id}">
	<c:set var="id" value="defaultDateRange" />
</c:if>
<c:if test="${empty requried}">
	<c:set var="requried" value="false" />
</c:if>
	

<div class="input-group">
	<div class="input-group-addon">
		<i class="fa fa-calendar"></i>
	</div>
	<input type="text" class="form-control pull-right" id="${id}">
	<input type="hidden" name="${beginDateName}" id="${id}HiddenBegin" 
		value="<fmt:formatDate value='${beginDate}' pattern='yyyy-MM-dd'/>" <c:if test="${requried}">class="required"</c:if>>
	<input type="hidden" name="${endDateName}"  id="${id}HiddenEnd" 
		value="<fmt:formatDate value='${endDate}'  pattern='yyyy-MM-dd'/>" <c:if test="${requried}">class="required"</c:if>>
	<script type="text/javascript">
		$(function(){
			$("#${id}").daterangepicker({
				opens : 'right',
				showDropdowns:true,
				<c:if test="${!empty beginDate}">
				startDate:'<fmt:formatDate value="${beginDate}" pattern="yyyy-MM-dd"/>',
				</c:if>
				<c:if test="${!empty endDate}">
				endDate:'<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>',
				</c:if>
				format:'YYYY-MM-DD',
				locale:{
					applyLabel: '确定',
	                cancelLabel: '取消',
	                fromLabel: '从',
	                toLabel: '到',
	                weekLabel: '星期',
	                customRangeLabel : '自定义',  
                                daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],  
                                monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',  
                                        '七月', '八月', '九月', '十月', '十一月', '十二月' ], 
	                firstDay: moment.localeData()._week.dow
				}				
			},function(start, end, label){
				$("#${id}HiddenBegin").val(start.format('YYYY-MM-DD'));
				$("#${id}HiddenEnd").val(end.format('YYYY-MM-DD'));
				
			});
			$('#${id}').val("<fmt:formatDate value='${beginDate}' pattern='yyyy-MM-dd'/> -  <fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd'/>" );
		})
	</script>
</div>