package com.cheer.assets.pagination;

import java.io.Serializable;

public class SimplePageInfo implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3789357001543001367L;

	private Integer current;
	
	private Integer pageSize;
	
	private Integer maxPage;
	
	private Long total;

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "SimplePageInfo [current=" + current + ", pageSize=" + pageSize + ", maxPage=" + maxPage
				+ ", total=" + total + "]";
	}
	
	
	
	
}
