package net.frank.yangtes.modules.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.frank.yangtes.commons.persistence.Page;
import net.frank.yangtes.commons.service.CrudService;
import net.frank.yangtes.commons.utils.DateUtils;
import net.frank.yangtes.modules.sys.dao.LogDao;
import net.frank.yangtes.modules.sys.entity.Log;

/**
 * 日志Service
 */
@Service
@Transactional(readOnly = true)
public class LogService extends CrudService<LogDao, Log> {

	public Page<Log> findPage(Page<Log> page, Log log) {
		
		// 设置默认时间范围，默认当前月
		if (log.getBeginDate() == null){
			log.setBeginDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate()), 1));
		}
		if (log.getEndDate() == null){
			log.setEndDate(DateUtils.addMonths(log.getBeginDate(), 1));
		}
		
		return super.findPage(page, log);
		
	}
	
}
