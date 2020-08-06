package com.hqyj.dao;

import com.hqyj.pojo.Emp;

public interface EmpMapper {
    int deleteByPrimaryKey(Long empId);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Long empId);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}