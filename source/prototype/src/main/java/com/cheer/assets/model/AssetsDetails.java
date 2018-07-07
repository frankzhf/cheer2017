package com.cheer.assets.model;

import java.util.List;

import com.cheer.assets.domain.AssetsEntity;
import com.cheer.assets.domain.AssetsFinanceRecordEntity;

public class AssetsDetails extends AssetsEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8973707410499333978L;

	private List<AssetsFinanceRecordEntity> financeRecordList;
	
	private List<AssetsTransferExt> transferRecordList;

	public List<AssetsFinanceRecordEntity> getFinanceRecordList() {
		return financeRecordList;
	}

	public void setFinanceRecordList(List<AssetsFinanceRecordEntity> financeRecordList) {
		this.financeRecordList = financeRecordList;
	}

	public List<AssetsTransferExt> getTransferRecordList() {
		return transferRecordList;
	}

	public void setTransferRecordList(List<AssetsTransferExt> transferRecordList) {
		this.transferRecordList = transferRecordList;
	}
	
	public String getLastBorrower(){
		if(getTransferRecordList()!=null 
				&& !getTransferRecordList().isEmpty()){
			return getTransferRecordList().get(0).getUserName();
		}
		return "&nbsp;";
	}

	@Override
	public String toString() {
		return "AssetsDetails [super= " +super.toString() 
			+  ",financeRecordList=" + financeRecordList 
			+ ", transferRecordList=" + transferRecordList + "]";
	}
}
