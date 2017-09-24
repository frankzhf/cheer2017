package com.cheer.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cheer.ssm.MyBatisDao;
import com.cheer.ssm.domain.User;
import com.cheer.ssm.helper.UserHelper;

@MyBatisDao
public interface UserMapper {
	
	public User findForUserName(String userName);
	
	public User get(Long userId);
	
	public void insert(@Param("user") User user);
	
	public void update(@Param("user") User user);
	
	public void delete(@Param("user") User user);
	
	public List<User> find(@Param("user") User user);
	
	public UserHelper findHelper(Long userId);
}
