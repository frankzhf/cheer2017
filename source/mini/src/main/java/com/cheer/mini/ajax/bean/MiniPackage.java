package com.cheer.mini.ajax.bean;

import java.io.Serializable;

public class MiniPackage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1070624730346975831L;
	/***
	{ 
		status:200,
		data:{
			$data
		},
		message:"errorMsg"
		
		if(status == 200){
			render data
		}else{
			show errorMsg
		}
	}
	***/
	
	public static final int SUCCESS = 200;
	public static final int FAILURE = 500;
	
	private int status = SUCCESS;
	
	private Object data;
	
	private String message;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void as500(String msg){
		setStatus(FAILURE);
		setMessage(msg);
	}
	/***
	{ 
		status:200,
		data:{
			pageInfo:{
				pageNo:1,
				pageSize:5,
				total:100,
				count:20
			},
			records:[{
				"id":'adfakdaifhaueyqwerqorey8qryhjdnvnzlv',
				"name":"张三",
				"age":22,
				"heigth":166,
				"weight":65
			},{
				
			}...
				
			]
		},
		message:"errorMsg"
		
		if(status == 200){
			render table
		}else{
			show errorMsg
		}
	}
	***/

	@Override
	public String toString() {
		return "MiniPackage [status=" + status + ", data=" + data + ", message=" + message + "]";
	}
}