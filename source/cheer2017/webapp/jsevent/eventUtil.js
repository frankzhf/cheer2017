var EventUtil = {
	addHandler : function(element,type,handler){
		if(element.addEventListener){
			element.addEventListener(type,handler);
		}else if(element.attachEvent){
			element.attachEvent("on" + type,handler);
		}else{
			element["on"+type] = handler;
		}
	},
	removeHandler : function(element,type,handler){
		if(element.removeEventListener){
			element.removeEventListener(type,handler);
		}else if(element.disachEvent){
			element.disachEvent("on"+type,handler);
		}else{
			element["on"+type] = null;
		}
	}
}

var $ = function(id){
	return document.getElementById(id);
}