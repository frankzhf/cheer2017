package com.cheer.ssm.mapper2;

import com.cheer.ssm.domain2.MyStudent;
import com.cheer.ssm.domain2.MyStudentExample;
import java.util.List;

public interface MyStudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MyStudent record);

    int insertSelective(MyStudent record);

    List<MyStudent> selectByExample(MyStudentExample example);

    MyStudent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MyStudent record);

    int updateByPrimaryKey(MyStudent record);
}