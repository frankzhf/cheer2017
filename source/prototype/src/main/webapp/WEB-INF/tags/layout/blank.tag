<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" type="java.lang.String" required="false" description="页面标题"%>
<%@ attribute name="bodyId" type="java.lang.String" required="false"%>

<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<c:if test="${empty title}">
	<c:set var="title" value="${fns:getConfig('productName')}" />
</c:if>
<c:if test="${empty bodyId}">
	<c:set var="bodyId" value="container" />
</c:if>

<!DOCTYPE html>
<html>
<head>
	<title>${title}</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta name="author" content="http://www.heinqi.com/"/>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10" />
	<meta http-equiv="Expires" content="0">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-store">
	<script src="${ctxStatic}/adminlte/plugins/jQuery/jquery-1.10.2.min.js"></script>
	<link href="${ctxStatic}/bootstrap/2.3.1/awesome/font-awesome.min.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="${ctxStatic}/fontawesome/css/font-awesome.css">
	<link rel="stylesheet" href="${ctxStatic}/adminlte/ionicons.min.css">
	<link rel="stylesheet" href="${ctxStatic}/adminlte/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="${ctxStatic}/adminlte/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet" href="${ctxStatic}/adminlte/dist/css/AdminLTE.min.css">
	<link rel="stylesheet" href="${ctxStatic}/adminlte/dist/css/skins/_all-skins.min.css">
	<script src="${ctxStatic}/adminlte/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ctxStatic}/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="${ctxStatic}/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="${ctxStatic}/adminlte/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="${ctxStatic}/adminlte/plugins/fastclick/fastclick.min.js"></script>
	<script src="${ctxStatic}/adminlte/dist/js/app.min.js"></script>
	<script src="${ctxStatic}/jquery-validation/1.15.0/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-validation/1.15.0/localization/messages_zh.js" type="text/javascript"></script>
	<script src="${ctxStatic}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
	<script src="${ctxStatic}/common/mustache.min.js" type="text/javascript"></script>
	<link href="${ctxStatic}/common/yangtes.css" type="text/css" rel="stylesheet" />
	<script src="${ctxStatic}/common/yangtes.js" type="text/javascript"></script>
	<script type="text/javascript">var ctx = '${ctx}', ctxStatic='${ctxStatic}';</script>
</head>
<body id="${bodyId}">
	<jsp:doBody />
</body>
</html>