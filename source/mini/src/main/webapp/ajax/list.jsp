<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<layout:blank title="Ajax -- 学生列表">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered">
				<tr>
					<th>标识</th>
					<th>姓名</th>
					<th>年龄</th>
					<th>身高</th>
					<th>体重</th>
					<th>操作</th>
				</tr>
				<tbody id="studStore">
					
				</tbody>
				<tr>
					<td colspan="6">
						<input id="btnFirst" type="button" value="|&lt;&lt;">
						<input id="btnPrev" type="button" value="&lt;&lt;">
						<input id="btnNext" type="button" value="&gt;&gt;">
						<input id="btnLast" type="button" value="&gt;&gt;|">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			page(1,3);
		});
		function page(pageNo,pageSize){	
			var pageInfo = {
				pageNo:pageNo,
				pageSize:pageSize
			};
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/student/ajax/list",
				contextType:"json",
				data : pageInfo,
				dataType: "json", 
				success: function(response){
					if(response.status == 200){
						console.log(response);
						$("#studStore").empty();
						if(response.data.records){
							for(var item in response.data.records){
								var tr = $("<tr></tr>");
								var td = $("<td></td>");
								td.append(response.data.records[item].id);
								tr.append(td);
								td = $("<td></td>");
								td.append(response.data.records[item].name);
								tr.append(td);
								td = $("<td></td>");
								td.append(response.data.records[item].age);
								tr.append(td);
								td = $("<td></td>");
								td.append(response.data.records[item].heigth);
								tr.append(td);
								td = $("<td></td>");
								td.append(response.data.records[item].weight);
								tr.append(td);
								td = $("<td>&nbsp;</td>");
								tr.append(td);
								$("#studStore").append(tr);
							}
						}
						if(response.data.pageInfo){
							var pageInfo = response.data.pageInfo;
							if(pageInfo.pageNo == 1){
								$("#btnFirst").attr("disabled","disabled");
								$("#btnPrev").attr("disabled","disabled");
							}else{
								if($("#btnFirst").attr("disabled")=="disabled" ){
									$("#btnFirst").removeAttr("disabled");
								}else{
									$("#btnFirst").unbind("click");
								}
								$("#btnFirst").click(function(){
									page(1,pageInfo.pageSize);
								});
								if($("#btnPrev").attr("disabled")=="disabled" ){
									$("#btnPrev").removeAttr("disabled");
								}else{
									$("#btnPrev").unbind("click");
								}
								$("#btnPrev").click(function(){
									page(pageInfo.pageNo-1,pageInfo.pageSize);
								});
								
							}
							if(pageInfo.pageNo == pageInfo.count){
								$("#btnNext").attr("disabled","disabled");
								$("#btnLast").attr("disabled","disabled");
							}else{
								if($("#btnNext").attr("disabled")=="disabled" ){
									$("#btnNext").removeAttr("disabled");
								}else{
									$("#btnNext").unbind("click");
								}
								$("#btnNext").click(function(){
									page(pageInfo.pageNo+1,pageInfo.pageSize);
								});
								if($("#btnLast").attr("disabled")=="disabled" ){
									$("#btnLast").removeAttr("disabled");
								}else{
									$("#btnLast").unbind("click");
								}
								$("#btnLast").click(function(){
									page(pageInfo.count,pageInfo.pageSize);
								});
							}
						}
					}
				},
				error : function(error){
					
				} 
			});
		}
		
		
	</script>
</layout:blank>