package com.cheer.ssm.mapper2;

import com.cheer.ssm.domain2.MyUser;
import com.cheer.ssm.domain2.MyUserExample;
import java.util.List;

public interface MyUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MyUser record);

    int insertSelective(MyUser record);

    List<MyUser> selectByExample(MyUserExample example);

    MyUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MyUser record);

    int updateByPrimaryKey(MyUser record);
}