package com.cheer.assets.pagination;

public class NoneConditionPagingInput extends PagingInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2895984258610881614L;

}


class UserSearchConditionPagingInput extends PagingInput{
	
	private String loginName;
	
	private String userName;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}