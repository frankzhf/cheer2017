package com.cheer.assets.model;

import java.util.List;

import com.cheer.assets.domain.AssetsEntity;
import com.cheer.assets.pagination.NoneConditionPagingInput;
import com.cheer.assets.pagination.SimplePageInfo;


public class AssetsForm extends NoneConditionPagingInput{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 928745635244719480L;

	private AssetsEntity editor;
	
	private List<AssetsEntity> list;
	
	public AssetsForm(){
		this.setPageInfo(new SimplePageInfo());
		this.getPageInfo().setCurrent(1);
		//this.getPageInfo().setPageSize(Integer.parseInt(Global.getConfig("page.pageSiz")));
		this.getPageInfo().setPageSize(2);
	}
	
	public AssetsEntity getEditor() {
		return editor;
	}

	public void setEditor(AssetsEntity editor) {
		this.editor = editor;
	}

	public List<AssetsEntity> getList() {
		return list;
	}

	public void setList(List<AssetsEntity> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "AssetsForm [super=" + super.toString() + ", editor=" + editor + ", list=" + list + "]";
	}
}
