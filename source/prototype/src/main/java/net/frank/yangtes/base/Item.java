package net.frank.yangtes.base;

import java.io.Serializable;

/**
 * @author zhao
 * @date 2016年5月6日 上午10:29:42
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified				
 *				
 * -------------------------------------------------------------------------
 */
public class Item implements Serializable {
	
	private static final long serialVersionUID = 344988214802714961L;
	/**
	 * @serialField id
	 * <p>记录标识</p>
	 */
	private String id;
	/**
	 * @serialField selected
	 * <p>是否选中</p>
	 */
	private Boolean selected = Boolean.FALSE;
	
	/**
	 * <p>Title: getId</p>
	 * <p>Description:获取ID</p>
	 * @return String
	 */
	public String getId() {
		return id;
	}
	/**
	 * <p>Title: setId</p>
	 * <p>Description:设置ID</p>
	 * @param String
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * <p>Title: getSelected</p>
	 * <p>Description:获取选中状态</p>
	 * @return Boolean
	 */
	public Boolean getSelected() {
		return selected;
	}
	/**
	 * <p>Title: setSelected</p>
	 * <p>Description:设置选中状态</p>
	 * @param Boolean
	 */
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	/**
	 * <p>Title: toString</p>
	 * <p>Description:返加对象的字符串内容</p>
	 * @return String
	 */
	@Override
	public String toString() {
		return "Item [id=" + id + ", selected=" + selected + "]";
	}
}

