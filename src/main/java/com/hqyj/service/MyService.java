package com.hqyj.service;

import com.hqyj.pojo.Emp;
import com.hqyj.pojo.Goods;
import com.hqyj.pojo.OutStore;
import com.hqyj.pojo.Store;

import java.util.List;
import java.util.Map;

public interface MyService {
    Map<String,Object> selectAll(Store store);
    Store selectByPrimaryKey(Integer storeId);
    List<Goods> selectByStoreId (int id);
    int updateByPrimaryKeySelective(Goods record);
    int updateByPrimaryKeySelective(Store record);
    Emp selectByPrimaryKeyEmpId(Long empId);
    int insertSelective(OutStore record);
    Map<String,Object> selectAlloutStore(OutStore outStore,long empId);
    int deleteByPrimaryKey(Long outId);
}
