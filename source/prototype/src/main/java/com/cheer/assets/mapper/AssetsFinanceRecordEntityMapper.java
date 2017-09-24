package com.cheer.assets.mapper;

import com.cheer.assets.domain.AssetsFinanceRecordEntity;
import com.cheer.assets.domain.AssetsFinanceRecordEntityExample;

import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;

import java.util.List;

@MyBatisDao
public interface AssetsFinanceRecordEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(AssetsFinanceRecordEntity record);

    int insertSelective(AssetsFinanceRecordEntity record);

    List<AssetsFinanceRecordEntity> selectByExample(AssetsFinanceRecordEntityExample example);

    AssetsFinanceRecordEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AssetsFinanceRecordEntity record);

    int updateByPrimaryKey(AssetsFinanceRecordEntity record);
}