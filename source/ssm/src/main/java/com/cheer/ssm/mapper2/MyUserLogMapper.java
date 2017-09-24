package com.cheer.ssm.mapper2;

import com.cheer.ssm.domain2.MyUserLog;
import com.cheer.ssm.domain2.MyUserLogExample;
import java.util.List;

public interface MyUserLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MyUserLog record);

    int insertSelective(MyUserLog record);

    List<MyUserLog> selectByExample(MyUserLogExample example);

    MyUserLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MyUserLog record);

    int updateByPrimaryKey(MyUserLog record);
}