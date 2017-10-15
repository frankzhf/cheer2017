<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>

<layout:default title="添加资产订购">
	<link href="${ctxStatic}/adminlte/plugins/datepicker/datepicker3.css" type="text/css" rel="stylesheet">
	<script src="${ctxStatic}/adminlte/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>
	<script src="${ctxStatic}/adminlte/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#inputForm").validate({
			submitHandler: function(form){
				loading('正在提交，请稍等...');
				form.submit();
			},
			errorPlacement: function(error, element) {
				renderErrorMsg(error, element);
			}
		});
		
		$("#sellDate").datepicker({
			language:"zh-CN",
			format:"yyyy-mm-dd"
		});
		
	});
	</script>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/assets">资产品表</a></li>
		<li class="active"><a href="#">添加资产订购</a></li>
	</ul>
	<br/>
	<form:form id="inputForm" modelAttribute="form" 
		action="${ctx}/assets/save" method="post" class="form-horizontal">
		<sys:message content="${message}"/>
		<form:hidden path="editor.id"/>
		<form:hidden path="editor.status"/>
		<form:hidden path="editor.createBy"/>
		<form:hidden path="pageInfo.current"/>
		<form:hidden path="pageInfo.pageSize"/>
		<input type="hidden" name="editor.createDate" 
				value="<fmt:formatDate value='${form.editor.createDate}' 
				pattern='yyyy-MM-dd HH:mm:ss'/>">
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">归属部门:</label>
				<div class="input-group">
	                <sys:treeselect id="office" name="editor.officeId" value="" labelName="extention_office_id" labelValue=""
						title="部门" url="/sys/office/treeData?type=2" cssClass="required" notAllowSelectParent="true"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">资产品类:</label>
				<div class="input-group">
					<sys:treeselect id="assets_categroy" name="editor.categoryId" value="" labelName="extention_cate_Id" labelValue=""
						title="资产品类" url="/assets/category/treeData" cssClass="required" notAllowSelectParent="true" allowClear="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">资产名称:</label>
				<div class="input-group">
					<form:input path="editor.name" htmlEscape="false" maxlength="32" class="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">资产描述:</label>
				<div class="input-group">
					<form:input path="editor.desc" htmlEscape="false" maxlength="256"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">资产购置价格</label>
				<div class="input-group">
					<form:input path="editor.sellPrice" htmlEscape="false" maxlength="32" class="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">资产购置日期</label>
				<div class="input-group">
					<form:input id="sellDate" path="editor.sellDate" htmlEscape="false" maxlength="32" class="datepicker required"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">资产多媒体记录</label>
				<div class="input-group">
					<form:hidden id="media" path="editor.media" htmlEscape="false" />
					<sys:ckfinder input="media"  type="images" uploadPath="/media" 
						selectMultiple="false" maxWidth="100" maxHeight="100"/>
				</div>
			</div>
		</div>
		<div class="box-footer">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</layout:default>