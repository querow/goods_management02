package com.hqyj.dao;

import com.hqyj.pojo.InStore;

public interface InStoreMapper {
    int deleteByPrimaryKey(Long inId);

    int insert(InStore record);

    int insertSelective(InStore record);

    InStore selectByPrimaryKey(Long inId);

    int updateByPrimaryKeySelective(InStore record);

    int updateByPrimaryKey(InStore record);
}