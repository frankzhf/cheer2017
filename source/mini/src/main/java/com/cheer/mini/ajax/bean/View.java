package com.cheer.mini.ajax.bean;

import java.io.Serializable;
import java.util.List;

public abstract class View<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2391727077693308133L;

	private PageInfo pageInfo;
	
	private List<T> records;

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "View [pageInfo=" + pageInfo + ", records=" + records + "]";
	}
	
	
	
	
}
