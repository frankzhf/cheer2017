<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="value"
	type="com.cheer.assets.pagination.SimplePageInfo" required="true"
	description="分页对像"%>
<%@ attribute name="dataUrl" type="java.lang.String" required="true"
	description="分面请求数据的url"%>
<%@ attribute name="formId" type="java.lang.String" required="false" 
	description="分面请求formId"%>
<%@ attribute name="id" type="java.lang.String" required="false"
	description="元素ID"%>
	
<c:if test="${empty formId}">
	<c:set var="formId" value="searchForm" />
</c:if>

<c:if test="${empty id}">
	<c:set var="id" value="default_id_paginate" />
</c:if>
<div class="dataTables_paginate paging_simple_numbers" id="${id}">
<%
	int length = 8;
	int slider = 1;
	int first = 1;
	StringBuilder sb = new StringBuilder();
	if (value.getCurrent().equals(first)) {// 如果是首页
		sb.append("<li class=\"disabled\"><a href=\"javascript:\">&#171; 上一页</a></li>\n");
	} else {
		sb.append("<li><a href=\"javascript:\" onclick=\"page("+(value.getCurrent() -1)+","+value.getPageSize()+");\">&#171; 上一页</a></li>\n");
	}
	int begin = value.getCurrent() - (length / 2);
	
	if (begin < 1) {
		begin = 1;
	}
	
	int end = begin + length - 1;
	
	
	int last =  value.getMaxPage();
	if(last < begin){
		last = begin;
	}
	if (end >= last) {
		end = last;
		begin = end - length + 1;
		if (begin < first) {
			begin = first;
		}
	}
	
	if (begin > first) {
		int i = 0;
		for (i = first; i < first + slider && i < begin; i++) {
			sb.append("<li><a href=\"javascript:\" onclick=\"page("+i+","+value.getPageSize()+"');\">"
					+ (i + 1 - first) + "</a></li>\n");
		}
		if (i < begin) {
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>\n");
		}
	}
	
	for (int i = begin; i <= end; i++) {
		if (i == value.getCurrent()) {
			sb.append("<li class=\"active\"><a href=\"javascript:\">" + (i + 1 - first)
					+ "</a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:\" onclick=\"page("+i+","+value.getPageSize()+");\">"
					+ (i + 1 - first) + "</a></li>\n");
		}
	}
	
	if (last - end > slider) {
		sb.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>\n");
		end = last - slider;
	}
	
	for (int i = end + 1; i <= last; i++) {
		sb.append("<li><a href=\"javascript:\" onclick=\"page("+i+","+value.getPageSize()+");\">"
				+ (i + 1 - first) + "</a></li>\n");
	}
	
	if (value.getCurrent() == last) {
		sb.append("<li class=\"disabled\"><a href=\"javascript:\">下一页 &#187;</a></li>\n");
	} else {
		sb.append("<li><a href=\"javascript:\" onclick=\"page("+ (value.getCurrent()+1) +","+value.getPageSize()+");\">"
				+ "下一页 &#187;</a></li>\n");
	}
	sb.append("<li class=\"disabled controls\"><a href=\"javascript:\">当前 ");
	sb.append("<input type=\"text\" value=\""+value.getCurrent()+"\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)");
	sb.append("page(this.value,"+value.getPageSize()+"');\" onclick=\"this.select();\"/> / ");
	sb.append("<input type=\"text\" value=\""+value.getPageSize()+"\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)");
	sb.append("page("+value.getCurrent()+",this.value"+"');\" onclick=\"this.select();\"/> 条，");
	sb.append("共 " + value.getTotal() + " 条"+"</a></li>\n");
	
	sb.insert(0,"<ul>\n").append("</ul>\n");
	
	sb.append("<div style=\"clear:both;\"></div>");
	
	//sb.insert(0,"<div class=\"page\">\n").append("</div>\n");

	out.print(sb.toString());
%>
</div>
<script type="text/javascript">
	$("ul",$("#${id}")).addClass("pagination").addClass("pull-right");
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#${formId}").attr("action", "${dataUrl}");
		$("#${formId}").submit();
		return false;
	}
</script>