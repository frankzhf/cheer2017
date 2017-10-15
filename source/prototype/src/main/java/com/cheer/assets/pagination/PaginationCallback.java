package com.cheer.assets.pagination;

import java.util.List;

public interface PaginationCallback<T> {
	public List<T> doProcess();
}
