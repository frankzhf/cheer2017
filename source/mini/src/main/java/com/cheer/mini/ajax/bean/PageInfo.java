package com.cheer.mini.ajax.bean;

import java.io.Serializable;

public class PageInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5775929286573369657L;

	private int pageNo;
	private int pageSize;
	private int total;
	private int count;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "PageInfo [pageNo=" + pageNo + ", pageSize=" + pageSize + ", total=" + total + ", count=" + count + "]";
	}
	
	
}
