package com.cheer.assets.model;

import com.cheer.assets.domain.AssetsTransferRecordEntity;

public class AssetsTransferExt extends AssetsTransferRecordEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5166769452946361728L;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "AssetsTransferExt [super=" + 
				super.toString() + ",userName=" + userName + "]";
	}
	
	
	
	
}
