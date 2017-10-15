package com.cheer.assets.pagination;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PaginationUtil{
	public static <T> PagingOutput<T> processPaging(PagingInput pagingInput, PaginationCallback<T> callback){
		if(pagingInput!=null && pagingInput.getPageInfo()!=null){
			if(pagingInput.getPageInfo().getCurrent() == null){
				pagingInput.getPageInfo().setCurrent(1);
			}
			if(pagingInput.getPageInfo().getPageSize() == null || pagingInput.getPageInfo().getPageSize() == 0){
				pagingInput.getPageInfo().setPageSize(10);
			}
			PageHelper.startPage(pagingInput.getPageInfo().getCurrent(), pagingInput.getPageInfo().getPageSize());
		}
		if(pagingInput!=null && pagingInput.getOrder()!=null){
			String orderBy = null;
			if(StringUtils.isNotBlank(pagingInput.getOrder().getColumnName())){
				orderBy = pagingInput.getOrder().getColumnName();
				if(StringUtils.isNotBlank(pagingInput.getOrder().getSortValue())){
					orderBy += (" " + pagingInput.getOrder().getSortValue());
				}
				
			}
			if(StringUtils.isNotBlank(orderBy)){
				PageHelper.orderBy(orderBy);
			}	
		}
		List<T> realList = callback.doProcess();
		PagingOutput<T> rt = new  PagingOutput<T>();
		if(pagingInput!=null && pagingInput.getPageInfo()!=null){
			PageInfo<?> _pageInfo = new PageInfo<>(realList);
			SimplePageInfo simplePageInfo = new SimplePageInfo();
			simplePageInfo.setCurrent(_pageInfo.getPageNum());
			simplePageInfo.setPageSize(_pageInfo.getPageSize());
			simplePageInfo.setMaxPage(_pageInfo.getPages());
			simplePageInfo.setTotal(_pageInfo.getTotal());
			rt.setPageInfo(simplePageInfo);
		}
		List<T> data = new ArrayList<T>();
		if(realList!=null && !realList.isEmpty()){
			for(int i=0;i<realList.size();i++){
				T item = realList.get(i);
				data.add(item);
			}
		}
		rt.setList(data);
		return rt;
	}	
}