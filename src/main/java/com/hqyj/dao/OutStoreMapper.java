package com.hqyj.dao;

import com.hqyj.pojo.OutStore;

import java.util.List;

public interface OutStoreMapper {
    int deleteByPrimaryKey(Long outId);

    int insert(OutStore record);

    int insertSelective(OutStore record);

    OutStore selectByPrimaryKey(Long outId);

    int updateByPrimaryKeySelective(OutStore record);

    int updateByPrimaryKey(OutStore record);

    List<OutStore> selectAlloutStore(long empId);

}