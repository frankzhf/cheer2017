package com.cheer.assets.pagination;

import java.io.Serializable;

public class PaginationOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8350334181376094746L;
	public static final String SORT_VALUE_DESC = "desc";
	public static final String SORT_VALUE_ASC = "asc";
	
	private String columnName;
	
	private String sortValue;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getSortValue() {
		return sortValue;
	}

	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
	}

	@Override
	public String toString() {
		return "PaginationOrder [columnName=" + columnName + ", sortValue=" + sortValue + "]";
	}
}
