package com.cheer.ssm.module;

import java.io.Serializable;
import java.util.List;

public abstract class View<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4687054443388599612L;

	private PageInfo pageInfo;
	
	private List<T> data;
	
	private T editor;

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public T getEditor() {
		return editor;
	}

	public void setEditor(T editor) {
		this.editor = editor;
	}

	@Override
	public String toString() {
		return "View [pageInfo=" + pageInfo + ", data=" + data + ", editor=" + editor + "]";
	}
	
	
}
