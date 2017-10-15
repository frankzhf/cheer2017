package com.cheer.assets.pagination;

import java.io.Serializable;
import java.util.List;

public class PagingOutput<T> implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3138879391046978357L;


	private SimplePageInfo pageInfo;
	
	
	private List<T> list;


	public SimplePageInfo getPageInfo() {
		return pageInfo;
	}


	public void setPageInfo(SimplePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}


	public List<T> getList() {
		return list;
	}


	public void setList(List<T> list) {
		this.list = list;
	}


	@Override
	public String toString() {
		return "PagingOutput [pageInfo=" + pageInfo + ", list=" + list + "]";
	}
	
}
