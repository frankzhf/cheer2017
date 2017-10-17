package com.cheer.assets.mapper;

import com.cheer.assets.domain.AssetsTransferRecordEntity;
import com.cheer.assets.domain.AssetsTransferRecordEntityExample;
import com.cheer.assets.model.AssetsTransferExt;

import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;

import java.util.List;

@MyBatisDao
public interface AssetsTransferRecordEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(AssetsTransferRecordEntity record);

    int insertSelective(AssetsTransferRecordEntity record);

    List<AssetsTransferRecordEntity> selectByExample(AssetsTransferRecordEntityExample example);

    AssetsTransferRecordEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AssetsTransferRecordEntity record);

    int updateByPrimaryKey(AssetsTransferRecordEntity record);
    
    List<AssetsTransferExt> findForAssetsId(String assetsId);
}