package net.frank.yangtes.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.frank.yangtes.commons.service.CrudService;
import net.frank.yangtes.commons.utils.CacheUtils;
import net.frank.yangtes.modules.sys.dao.DictDao;
import net.frank.yangtes.modules.sys.entity.Dict;
import net.frank.yangtes.modules.sys.utils.DictUtils;

/**
 * 字典Service
 */
@Service
@Transactional(readOnly = true)
public class DictService extends CrudService<DictDao, Dict> {
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dao.findTypeList(new Dict());
	}

	@Transactional(readOnly = false)
	public void save(Dict dict) {
		super.save(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	@Transactional(readOnly = false)
	public void delete(Dict dict) {
		super.delete(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

}
