package com.cheer.assets.pagination;

import java.io.Serializable;

public abstract class PagingInput implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1162160613619784585L;

	private SimplePageInfo pageInfo;
	
	private PaginationOrder order;

	public SimplePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(SimplePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	public PaginationOrder getOrder() {
		return order;
	}

	public void setOrder(PaginationOrder order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "PagingInput [pageInfo=" + pageInfo + ", order " + order +"]";
	}
}
