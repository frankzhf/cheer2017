package com.cheer.ssm.module;

import java.io.Serializable;

public class PageInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7941634807015392779L;
	//页数
	private int pageNo;
	//页记录数
	private int pageSize;
	//总共记录数
	private int total;
	//总共页数
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
