package net.frank.cheer.demo.ch17;

import java.util.Date;
import java.util.List;

public class GenTypeDesignTest {
	public static void main(String[] args){
		
		
		ListView<User> userListView = new ListView<User>();
		
		
		ListView<Product> productListView = new ListView<Product>();
		
		
		ListView<Order> orderListView = new ListView<Order>();
		
		
		//ListView<Log> logListView = new ListView<Log>();
		
		
	}
	
	//1. Maintain User List
	//2. Maintain Product List
	//3. Order List
	
	
	
	
	
	
	
	
	
}

class Log{
	
}


class ListView<T extends DataEntity>{
	private List<T> data;
	private Page page;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
}

class Page{
	private int current;
	private int pageSize;
	private int total;
	private int countPage;
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
}


class User extends DataEntity{
	
}

class Product extends DataEntity{
	
}

class Order extends DataEntity{
	
}

class DataEntity{
	private User createUser;
	private Date createDate;
	private User updateUser;
	private Date updateDate;
	private boolean delected;
	private int version;
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public User getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public boolean isDelected() {
		return delected;
	}
	public void setDelected(boolean delected) {
		this.delected = delected;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
}