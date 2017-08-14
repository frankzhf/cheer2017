package net.frank.yangtes.modules.sys.dao;

import net.frank.yangtes.commons.persistence.CrudDao;
import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;
import net.frank.yangtes.modules.sys.entity.Log;

/**
 * 日志DAO接口
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

}
