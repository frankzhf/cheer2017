package com.cheer.assets.model;

public class CategroyCnt {
	private String categroyId;
	private String bnsPre;
	private String categroyName;
	private Integer cnt;
	public String getCategroyId() {
		return categroyId;
	}
	public void setCategroyId(String categroyId) {
		this.categroyId = categroyId;
	}
	public String getBnsPre() {
		return bnsPre;
	}
	public void setBnsPre(String bnsPre) {
		this.bnsPre = bnsPre;
	}
	public String getCategroyName() {
		return categroyName;
	}
	public void setCategroyName(String categroyName) {
		this.categroyName = categroyName;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "CategroyCnt [categroyId=" + categroyId + ", bnsPre=" + bnsPre + ", categroyName=" + categroyName + ", cnt=" + cnt + "]";
	}
	
	
}
