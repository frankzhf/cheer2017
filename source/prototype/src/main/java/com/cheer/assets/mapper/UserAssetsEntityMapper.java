package com.cheer.assets.mapper;

import com.cheer.assets.domain.UserAssetsEntity;
import com.cheer.assets.domain.UserAssetsEntityExample;

import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;

import java.util.List;

@MyBatisDao
public interface UserAssetsEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserAssetsEntity record);

    int insertSelective(UserAssetsEntity record);

    List<UserAssetsEntity> selectByExample(UserAssetsEntityExample example);

    UserAssetsEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserAssetsEntity record);

    int updateByPrimaryKey(UserAssetsEntity record);
}