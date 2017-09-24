package com.cheer.assets.mapper;

import com.cheer.assets.domain.AssetsEntity;
import com.cheer.assets.domain.AssetsEntityExample;

import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;

import java.util.List;

@MyBatisDao
public interface AssetsEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(AssetsEntity record);

    int insertSelective(AssetsEntity record);

    List<AssetsEntity> selectByExample(AssetsEntityExample example);

    AssetsEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AssetsEntity record);

    int updateByPrimaryKey(AssetsEntity record);
}