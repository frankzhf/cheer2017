<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<layout:default title="修改密码" bodyId="">
	<script type="text/javascript">
		$(document).ready(
				function() {
					$("#oldPassword").focus();
					$("#inputForm").validate(
							{
								rules : {},
								messages : {
									confirmNewPassword : {
										equalTo : "输入与上面相同的密码"
									}
								},
								submitHandler : function(form) {
									loading('正在提交，请稍等...');
									form.submit();
								},
								errorContainer : "#messageBox",
								errorPlacement : function(error, element) {
									$("#messageBox").text("输入有误，请先更正。");
									if (element.is(":checkbox")
											|| element.is(":radio")
											|| element.parent().is(
													".input-append")) {
										error.appendTo(element.parent()
												.parent());
									} else {
										error.insertAfter(element);
									}
									element.parent().parent().addClass(
											"has-error");
								}
							});
				});
	</script>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/user/info">个人信息</a></li>
		<li class="active"><a href="${ctx}/sys/user/modifyPwd">修改密码</a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="user"
		action="${ctx}/sys/user/modifyPwd" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">旧密码:</label>
				<div class="col-sm-10">
					<input id="oldPassword" name="oldPassword" type="password" value=""
						maxlength="50" minlength="3" class="required" /> <span
						class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">新密码:</label>
				<div class="col-sm-10">
					<input id="newPassword" name="newPassword" type="password" value=""
						maxlength="50" minlength="3" class="required" /> <span
						class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">确认新密码:</label>
				<div class="col-sm-10">
					<input id="confirmNewPassword" name="confirmNewPassword"
						type="password" value="" maxlength="50" minlength="3"
						class="required" equalTo="#newPassword" /> <span
						class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
		</div>
		<div class="box-footer">
			<input id="btnSubmit" class="btn btn-primary" type="submit"
				value="保 存" />
		</div>
	</form:form>
</layout:default>
