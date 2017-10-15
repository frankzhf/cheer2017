package com.cheer.assets.mapper;

import com.cheer.assets.domain.AssetsCategroyEntity;
import com.cheer.assets.domain.AssetsCategroyEntityExample;
import com.cheer.assets.model.CategroyCnt;

import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;

import java.util.List;



@MyBatisDao
public interface AssetsCategroyEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(AssetsCategroyEntity record);

    int insertSelective(AssetsCategroyEntity record);

    List<AssetsCategroyEntity> selectByExample(AssetsCategroyEntityExample example);

    AssetsCategroyEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AssetsCategroyEntity record);

    int updateByPrimaryKey(AssetsCategroyEntity record);
    
    CategroyCnt preparePreCnt(String categroyId);
}