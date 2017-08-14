<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="id" type="java.lang.String" required="true" description="编号"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="隐藏域名称（ID）"%>
<%@ attribute name="value" type="java.lang.String" required="true" description="隐藏域值（ID）"%>
<%@ attribute name="labelName" type="java.lang.String" required="true" description="输入框名称（Name）"%>
<%@ attribute name="title" type="java.lang.String" required="true" description="选择框标题"%>
<%@ attribute name="scope" type="java.lang.String" required="false" %>
<%@ attribute name="notAllowSelectParent" type="java.lang.Boolean" required="false" description="不允许选择父节点"%>
<%@ attribute name="cssClass" type="java.lang.String" required="false" description="css样式"%>
<%@ attribute name="cssStyle" type="java.lang.String" required="false" description="css样式"%>
<%@ attribute name="dataMsgRequired" type="java.lang.String" required="false" description=""%>
<%@ attribute name="disabled" type="java.lang.Boolean" required="false" description="能否编辑"%>

<c:if test="${empty disabled}">
	<c:set var="disabled" value="false" />
</c:if>
<c:if test="${empty scope}">
	<c:set var="scope" value="4" />
</c:if>

<c:if test="${disabled}">
	<input id="${id}Id" name="${name}" class="${cssClass}" type="hidden" value="${value}"/>
	<input id="${id}Name" name="${labelName}" ${allowInput?'':'readonly="readonly"'} type="text" value="" data-msg-required="${dataMsgRequired}"
		style="${cssStyle}"/>
<script type="text/javascript">
	$(function(){
		if(null!=$("#${id}Id").val() 
				&& ''!=$("#${id}Id").val() ){
			$.get(
				"${ctx}/dialog/area/get?areaId=" + $("#${id}Id").val(),
				function(data){
					if("未定义的地区"!= data.name){
						$("#${id}Name").val(data.name);
					}else{
						$("#${id}Name").val("");
					}
				}
			);
		}
	});
</script>
</c:if>
<c:if test="${!disabled}">

<div class="input-append">
	<input id="${id}Id" name="${name}" class="${cssClass}" type="hidden" value="${value}"/>
	<input id="${id}Name" name="${labelName}" ${allowInput?'':'readonly="readonly"'} type="text" value="" data-msg-required="${dataMsgRequired}"
		style="${cssStyle}"/>
		<a id="${id}Button" href="javascript:" class="btn ${disabled} ${hideBtn ? 'hide' : ''}" style="${smallBtn?'padding:4px 2px;':''}">&nbsp;<i class="icon-search"></i>&nbsp;</a>&nbsp;&nbsp;
</div>
<script type="text/javascript">
	$(function(){
		if(null!=$("#${id}Id").val() 
				&& ''!=$("#${id}Id").val() ){
			$.get(
				"${ctx}/dialog/area/get?areaId=" + $("#${id}Id").val(),
				function(data){
					if("未定义的地区"!= data.name){
						$("#${id}Name").val(data.name);
					}else{
						$("#${id}Name").val("");
					}
				}
			);
		}
		$("#${id}Button, #${id}Name").click(function(){
			if(null!=$("#${id}Id").val() 
					&& ''!=$("#${id}Id").val() ){
				$.get(
					"${ctx}/dialog/area/get?areaId=" + $("#${id}Id").val(),
					function(data){
						if("未定义的地区"!= data.name){
							$("#${id}Name").val(data.name);
						}else{
							$("#${id}Name").val("");
						}
					}
				);
			}
			if ($("#${id}Button").hasClass("disabled")){
				return true;
			}
			// 正常打开	
			top.$.jBox.open("iframe:${ctx}/dialog/areaselect?scope=${scope}&selectId=" + $("#${id}Id").val(), "选择${title}", 300, 420, {
				ajaxData:{selectIds: $("#${id}Id").val()},buttons:{"确定":"ok", "清除":"clear","关闭":true},
				submit:function(v, h, f){
					if (v=="ok"){
						var tree = h.find("iframe")[0].contentWindow.tree;//h.find("iframe").contents();
						var ids = [], names = [], nodes = [];
						nodes = tree.getSelectedNodes();
						for(var i=0; i<nodes.length; i++) {
							if (nodes[i].level == 0){
								top.$.jBox.tip("不能选择根节点（"+nodes[i].name+"）请重新选择。");
								return false;
							}//<c:if test="${notAllowSelectParent}">
							if (nodes[i].isParent){
								top.$.jBox.tip("不能选择父节点（"+nodes[i].name+"）请重新选择。");
								return false;
							}//</c:if>
							if (nodes[i].name =='市辖区' || nodes[i].name=='县'){
								top.$.jBox.tip("不能选择的节点（"+nodes[i].name+"）请重新选择。");
								return false;
							}
							if(typeof ${id}TreeselectFilter == 'function'){
								if( ! ${id}TreeselectFilter(nodes[i])){
									top.$.jBox.tip("不能选择的节点（"+nodes[i].name+"）请重新选择。");
									return false;
								};
							}
							ids.push(nodes[i].id);
							names.push(nodes[i].name);
							break; 
						}
						$("#${id}Id").val(ids.join(",").replace(/u_/ig,""));
						$("#${id}Name").val(names.join(","));
					}
					else if (v=="clear"){
						$("#${id}Id").val("");
						$("#${id}Name").val("");
	                }
					if(typeof ${id}TreeselectCallBack == 'function'){
						${id}TreeselectCallBack(v, h, f);
					}
				}, loaded:function(h){
					$(".jbox-content", top.document).css("overflow-y","hidden");
				}
			});
		});
	});
</script>
</c:if>