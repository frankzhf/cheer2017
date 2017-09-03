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
				
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			var pageInfo = {
				pageNo:1,
				pageSize:5
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
								//td.append(item.weight);
								tr.append(td);
								
								$("#studStore").append(tr);
							}
						}
						
						
						
						
						
						
					}
				},
				error : function(error){
					
				} 
			});
		});
	</script>
</layout:blank>