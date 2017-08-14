/***
 
 var responseJson = HttpGet("http://localhost:5000/huashan/student/list")
 
 */

var responseJson = {
	status : 200,
	data :{
		pageInfo: {
			current : 1,
			pageSize : 25
		},
		list :[
			{
				name:"张三",
				age:17,
				height:156,
				weigh:44
			},
			{
				name:"李四",
				age:16,
				height:152,
				weigh:41
			},
			{
				name:"王五",
				age:18,
				height:161,
				weigh:52
			},
			{
				name:"赵六",
				age:15,
				height:145,
				weigh:38
			},
			{
				name:"田七",
				age:17,
				height:166,
				weigh:51
			}
		]
	}
};
window.onload = function(){
	if(responseJson.status == 200){
		if(responseJson.data){
			if(responseJson.data.list){
				var _list = responseJson.data.list;
				var _tbody = document.getElementById("records");
				function wrapRecord(student){
					var _tr = document.createElement("tr");
					var _td = document.createElement("td");
					var _txt = document.createTextNode(student.name);
					_td.appendChild(_txt);
					_tr.appendChild(_td);
					
					_td = document.createElement("td");
					_txt = document.createTextNode(student.age);
					_td.appendChild(_txt);
					_tr.appendChild(_td);
					
					_td = document.createElement("td");
					_txt = document.createTextNode(student.height);
					_td.appendChild(_txt);
					_tr.appendChild(_td);
					
					_td = document.createElement("td");
					_txt = document.createTextNode(student.weigh);
					_td.appendChild(_txt);
					_tr.appendChild(_td);
					return _tr;
				}
				for(var index=0;index<_list.length;index++){
					var student = _list[index];
					var tr = wrapRecord(student);
					_tbody.appendChild(tr);
				}
			}
		}
	}else{
		console.log("服务端请求不成功！");
	}
}
