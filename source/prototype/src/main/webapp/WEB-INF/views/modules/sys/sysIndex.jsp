<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=${ctxStatic}edge">
<title>${fns:getConfig('productName')}</title>
<script src="${ctxStatic}/adminlte/plugins/jQuery/jquery-1.10.2.min.js"></script>
<link href="${ctxStatic}/bootstrap/2.3.1/awesome/font-awesome.min.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet"
	href="${ctxStatic}/fontawesome/css/font-awesome.css">
<link rel="stylesheet" href="${ctxStatic}/adminlte/ionicons.min.css">
<link rel="stylesheet"
	href="${ctxStatic}/adminlte/bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="${ctxStatic}/adminlte/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${ctxStatic}/adminlte/dist/css/AdminLTE.min.css">
<link rel="stylesheet"
	href="${ctxStatic}/adminlte/dist/css/skins/_all-skins.min.css">
<script src="${ctxStatic}/adminlte/bootstrap/js/bootstrap.min.js"></script>
<script
	src="${ctxStatic}/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script
	src="${ctxStatic}/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
	src="${ctxStatic}/adminlte/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${ctxStatic}/adminlte/plugins/fastclick/fastclick.min.js"></script>
<script src="${ctxStatic}/adminlte/dist/js/app.min.js"></script>

<script src="${ctxStatic}/ng/underscore-min.js"></script>
<script src="${ctxStatic}/ng/bootstrap-typeahead.js"></script>
<script src="${ctxStatic}/artdialog/dialog-min.js"></script>
<script src="${ctxStatic}/artdialog/dialog-plus-min.js"></script>
<link href="${ctxStatic}/artdialog/ui-dialog.css" rel="stylesheet" />
<script
	src="${ctxStatic}/jquery-validation/1.15.0/jquery.validate.min.js"
	type="text/javascript"></script>
<script
	src="${ctxStatic}/jquery-validation/1.15.0/localization/messages_zh.js"
	type="text/javascript"></script>
<script src="${ctxStatic}/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${ctxStatic}/common/mustache.min.js" type="text/javascript"></script>
<link href="${ctxStatic}/common/yangtes.css" type="text/css"
	rel="stylesheet" />
<script src="${ctxStatic}/common/yangtes.js" type="text/javascript"></script>
<script type="text/javascript">var ctx = '${ctx}', ctxStatic='${ctxStatic}';</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<a href="#" class="logo"> <span class="logo-mini">${fns:getConfig('productName')}</span>
				<span class="logo-lg"><b>${fns:getConfig('productName')}</b></span>
			</a>
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> </a>

				<div>
					<ul class="nav navbar-nav">
						<c:set var="firstMenu" value="true" />
						<c:if test="${!empty param.parentId}">
							<c:set var="firstMenuId" value="${param.parentId}" />
							<c:set var="firstMenu" value="false" />
						</c:if>

						<c:forEach items="${fns:getMenuList()}" var="menu"
							varStatus="idxStatus">
							<c:if test="${menu.parent.id eq '1'&&menu.isShow eq '1'}">
								<li class=" ${menu.id eq param.parentId ? ' active' : ''}">
									<c:if test="${empty menu.href}">
										<a href="?parentId=${menu.id}" data-id="${menu.id}">${menu.name}</a>
									</c:if> <c:if test="${not empty menu.href}">
										<a
											href="${fn:indexOf(menu.href, '://') eq -1 ? ctx : ''}${menu.href}"
											data-id="${menu.id}" target="mainFrame">${menu.name}</a>
									</c:if>
								</li>
								<c:if test="${firstMenu}">
									<c:set var="firstMenuId" value="${menu.id}" />
								</c:if>
								<c:set var="firstMenu" value="false" />
							</c:if>
						</c:forEach>
					</ul>
				</div>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<%--<c:set var="oaNotifyRemindInterval" value="${fns:getConfig('oa.notify.remind.interval')}"/>--%>

						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <span
								class="hidden-xs">您好, ${fns:getUser().name}</span>
						</a>
							<ul class="dropdown-menu">
								<li class="user-header">
									<p>
										${fns:getUser().name}
										<%--<small>Member since Nov. 2012</small>--%>
									</p>
									<div class="text-center col-xs-12">
										<img src="${fns:getUser().photo}" />
									</div>

								</li>
								<!-- Menu Body
								<li class="user-body">
									<div class="col-xs-6 text-center">
										<a href="${ctx}/sys/user/modifyPwd" target="mainFrame">修改密码</a>
									</div>
									<div class="col-xs-6 text-center">
										<a href="${ctx}/oa/oaNotify/self" target="mainFrame">我的通知</a>
									</div>
								</li>  -->
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-right">
										<a class="btn btn-default btn-flat"
											href="${ctx}/sys/user/info" target="mainFrame">个人信息</a> <a
											class="btn btn-default btn-flat"
											href="${ctx}/sys/user/modifyPwd" target="mainFrame">修改密码</a>
										<a class="btn btn-default btn-flat" href="${ctx}/logout"
											title="退出登录">退出</a>
									</div>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		<aside class="main-sidebar">
			<section class="sidebar">
				<ul class="sidebar-menu">
					<c:set var="firstUrl" value="" />
					<c:forEach items="${fns:getMenuList()}" var="menu"
						varStatus="idxStatus">
						<c:if test="${menu.parent.id eq firstMenuId &&menu.isShow eq '1'}">
							<c:if test="${firstUrl==''}">
								<li class="treeview active">
							</c:if>
							<c:if test="${firstUrl!=''}">
								<li class="treeview">
							</c:if>
							<a href="#"> <i class="fa fa-dashboard"></i> <span>${menu.name}</span>
								<i class="fa fa-angle-left pull-right"></i>
							</a>
							<ul class="treeview-menu">
								<c:forEach var="vo" items="${fns:getMenuList()}">
									<c:if test="${vo.parent.id eq menu.id &&vo.isShow eq '1'}">
										<c:if test="${firstUrl==''}">
											<li class="active">
										</c:if>
										<c:if test="${firstUrl!=''}">
											<li>
										</c:if>
										<a
											href="${fn:indexOf(vo.href, '://') eq -1 ? ctx : ''}${vo.href}"
											data-id="${vo.id}" target="mainFrame"><i
											class="fa fa-circle-o"></i> ${vo.name}</a>
										</li>
										<c:if test="${firstUrl==''}">
											<c:set var="firstUrl"
												value="${fn:indexOf(vo.href, '://') eq -1 ? ctx : ''}${vo.href}"></c:set>
										</c:if>
									</c:if>
								</c:forEach>
							</ul>
							</li>
						</c:if>
					</c:forEach>
				</ul>
			</section>
		</aside>
		<div class="content-wrapper">
			<section class="content">
				<iframe id="mainFrame" name="mainFrame" src="${firstUrl}"
					style="overflow: auto;" scrolling="yes" frameborder="no"
					width="100%"></iframe>
			</section>
		</div>
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> ${fns:getConfig('version')}
			</div>
			<strong>Copyright &copy; 2016
				${fns:getConfig('copyrightYear')} <a
				href="${pageContext.request.contextPath}${fns:getFrontPath()}">${fns:getConfig('productName')}</a>-
				Powered By <a href="${fns:getConfig('orgSite')}" target="_blank">${fns:getConfig('orgName')}</a>
			</strong> All rights reserved.
		</footer>
	</div>
	
	<script type="text/javascript">
	function changeFrameHeight(){
	    var ifm= document.getElementById("mainFrame");
	    console.log("clientHeight :" + $(window).height());
	    console.log("main-header height :" + $(".main-header").height());
	    console.log("main-footer height :" + $(".main-footer").height());
	    var _conetntHeight = $(window).height()-$(".main-header").height()-$(".main-footer").height();
	    console.log("mainFrame height :" + _conetntHeight);
	    ifm.height=_conetntHeight-5;
	    
	}
	window.onresize=function(){  
	     changeFrameHeight(); 
	}
	changeFrameHeight();
	</script>
	
</body>
</html>