package net.frank.yangtes.base;

import java.util.List;

import net.frank.yangtes.commons.persistence.DataEntity;


/**
 * @author zhao
 * @date 2016年5月3日上午10:12:07
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified				
 *				
 * -------------------------------------------------------------------------
 */
public class AbstractForm<T extends DataEntity<T>,D extends AbstractCondition<?>>{
	
	/**
	 * @serialField condition
	 * <p>查询条件</p>
	 */
	protected D condition;
	/**
	 * @serialField dataEntity
	 * <p>操作记录</p>
	 */
	protected T dataEntity;
	
	/**
	 * @serialField items
	 * <p>选中记录集</p>
	 */
	private List<Item> items;
	
	
	/**
     * <p>Title: AbstractForm</p>
     * <p>Description:默认构造方法</p>
     */
	public AbstractForm(){
		setDataEntity(null);
	}
	
	/**
     * <p>Title: getCondition</p>
     * <p>Description:获取查询条件</p>
     * @return D
     */
	public D getCondition() {
		return condition;
	}
	
	/**
     * <p>Title: setCondition</p>
     * <p>Description:设置查询条件</p>
     * @param D
     */
	public void setCondition(D condition) {
		this.condition = condition;
	}
	
	/**
     * <p>Title: getDataEntity</p>
     * <p>Description:获取操作记录</p>
     * @return T
     */
	public T getDataEntity() {
		return dataEntity;
	}
	
	/**
     * <p>Title: setDataEntity</p>
     * <p>Description:设置操作记录</p>
     * @param T
     */
	public void setDataEntity(T dataEntity) {
		this.dataEntity = dataEntity;
	}
	
	
	/**
     * <p>Title: getItems</p>
     * <p>Description:获取选择对象</p>
     * @return List<Item>
     */
	
	public List<Item> getItems() {
		return items;
	}
	
	/**
     * <p>Title: setItems</p>
     * <p>Description:设置选择对象</p>
     * @param List<Item>
     */
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	/**
     * <p>Title: toString</p>
     * <p>Description:</p>
     * @return String
     */
	@Override
	public String toString() {
		return "AbstractForm [condition=" + condition + ", dataEntity=" + dataEntity + ", items=" + items + "]";
	}
	
	
}

