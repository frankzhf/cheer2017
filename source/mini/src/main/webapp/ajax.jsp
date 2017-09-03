
<html>

<body>
	<script type="text/javascript">
	
	var xmlRequest = new XMLHttpRequest();//非IE
	//var xmlRequest = new ActiveXObject(“Microsoft.XMLHTTP"); //IE
	//后续处理通过方法回调来实现
	xmlRequest.open("get","/mini-2017/student/list",false) 
	//xmlRequest.setRequestHeader(“Content-type”,”application/x-www-form-urlencoded");//如果是post方式，需要加
	xmlRequest.send(); //参数的格式 $name=$value(&name=$value)+
	/***
	xmlRequest.onreadystatechange=function(){
		if(xmlRequest.readyState == 4 && xmlRequest.status==200){
			//处理xmlRequest.responseText
		}else if(xmlRequest.status!=200){
			//处理错误
		}
	};
	***/
	var respone = xmlRequest.responseText;
	
	
	xmlRequest.open("get","/mini-2017/student/delete",true) 
	//xmlRequest.setRequestHeader(“Content-type”,”application/x-www-form-urlencoded");//如果是post方式，需要加
	xmlRequest.send("id=adfsafdasdfasdfasf"); //参数的格式 $name=$value(&name=$value)+
	xmlRequest.onreadystatechange=function(){
		if(xmlRequest.readyState == 4 && xmlRequest.status==200){
			//处理xmlRequest.responseText
		}else if(xmlRequest.status!=200){
			//处理错误
		}
	};
	
	
	</script>
</body>


</html>