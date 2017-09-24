package com.cheer.ssm.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.ssm.domain.UserLog;
import com.cheer.ssm.mapper.UserLogMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class UserService {
	private transient Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private UserLogMapper userLogMapper;
	
	public List<UserLog> queryPage(int pageNo, int PageSize){
		PageHelper.startPage(pageNo, PageSize);
		List<UserLog> list = userLogMapper.list();
		Page<UserLog> pageInfo = PageHelper.offsetPage(pageNo, PageSize);
		log.info("Varible [pageInfo] -> " + pageInfo);
		return list;
	}
}
