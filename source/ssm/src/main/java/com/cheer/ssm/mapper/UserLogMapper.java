package com.cheer.ssm.mapper;

import java.util.List;

import com.cheer.ssm.MyBatisDao;
import com.cheer.ssm.domain.UserLog;
import com.cheer.ssm.helper.UserLogHelper;

@MyBatisDao
public interface UserLogMapper {

	
	public List<UserLog> list();
	
	public UserLogHelper get(Long userId);
	
}
