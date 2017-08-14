package net.frank.yangtes.base;

import net.frank.yangtes.commons.config.Global;
import net.frank.yangtes.commons.persistence.Page;

/**
 * @author zhao
 * @date 2016年4月25日下午5:56:36
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified				
 *				
 * -------------------------------------------------------------------------
 */

public abstract class AbstractCondition<T> {
	
	public AbstractCondition(){
		this.page = new Page<T>(1, DEFAULT_PAGE_SIZE);
	}
	
	/**
	 * @serialField DEFAULT_PAGE_SIZE
	 * <p>设置默认的分页大小</p>
	 */
	private static final Integer DEFAULT_PAGE_SIZE = Integer.valueOf(Global.getConfig("page.pageSize"));
	
	/**
	 * @serialField page
	 * <p>分页信息及结果</p>
	 */
	protected Page<T> page;
	
	/**
     * <p>Title: getPage</p>
     * <p>Description:获取分页信息及结果</p>
     * @return Page<T>
     */
	public Page<T> getPage() {
		if (page == null) {
			page = new Page<T>(1, DEFAULT_PAGE_SIZE);
		}
		return page;
	}
	/**
     * <p>Title: setPage</p>
     * <p>Description:设置分页信息及结果</p>
     * @param Page<T>
     */
	public void setPage(Page<T> page) {
		this.page = page;
	}
	
	
	/**
     * <p>Title: toString</p>
     * <p>Description:返回对像的字符串描述</p>
     * @return String
     */
	@Override
	public String toString() {
		return "AbstractCondition [page=" + getPage().getPageNo() + "|" + getPage().getPageSize() + "|"
				+ getPage().getCount() + "]";
	}
	
	/**
     * <p>Title: getDbName</p>
     * <p>Description:获取数据库类型</p>
     * @return String
     */
	public String getDbName() {
		return Global.getConfig("jdbc.type");
	}

	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";
}
