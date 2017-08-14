<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="object" type="com.heinqi.yangtes.jee.commons.persistence.Page" required="true"
	description="分页对象"%>
<%@ attribute name="id" type="java.lang.String" required="false"
	description="元素ID"%>


<c:if test="${empty id}">
	<c:set var="id" value="default_id_paginate" />
</c:if>

	
<div class="dataTables_paginate paging_simple_numbers" id="${id}">
	${object}
</div>

<script type="text/javascript">
$(function(){
	$("ul",$("#${id}")).addClass("pagination").addClass("pull-right");
})
</script>
