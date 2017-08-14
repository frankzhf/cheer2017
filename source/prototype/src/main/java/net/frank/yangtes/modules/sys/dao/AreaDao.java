package net.frank.yangtes.modules.sys.dao;

import net.frank.yangtes.commons.persistence.TreeDao;
import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;
import net.frank.yangtes.modules.sys.entity.Area;

/**
 * 区域DAO接口
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
	
}
