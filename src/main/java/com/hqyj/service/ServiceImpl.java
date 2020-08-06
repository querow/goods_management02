package com.hqyj.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.EmpMapper;
import com.hqyj.dao.GoodsMapper;
import com.hqyj.dao.OutStoreMapper;
import com.hqyj.dao.StoreMapper;
import com.hqyj.pojo.Emp;
import com.hqyj.pojo.Goods;
import com.hqyj.pojo.OutStore;
import com.hqyj.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceImpl implements MyService{

    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private OutStoreMapper outStoreMapper;

    @Override
    public Map<String,Object> selectAll(Store store) {
        PageHelper.startPage(store.getPage(),store.getRow());
        List<Store> storeList = storeMapper.selectAll(store);

        PageInfo<Store> pageInfo = new PageInfo<>(storeList);
        HashMap<String,Object> map = new HashMap<>();
        map.put("list",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        map.put("prePage",pageInfo.getPrePage());
        map.put("nextPage",pageInfo.getNextPage());
        map.put("firstPage",pageInfo.getNavigateFirstPage());
        map.put("endPage",pageInfo.getLastPage());
        map.put("pageSize",pageInfo.getPageSize());
        map.put("nowPage",pageInfo.getPageNum());
        map.put("pages",pageInfo.getPages());
        map.put("navigatepageNums",pageInfo.getNavigatepageNums());
        return map;
    }

    @Override
    public Store selectByPrimaryKey(Integer storeId) {
        return storeMapper.selectByPrimaryKey(storeId);
    }

    @Override
    public List<Goods> selectByStoreId(int id) {
        return goodsMapper.selectByStoreId(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Store record) {
        return storeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Emp selectByPrimaryKeyEmpId(Long empId) {
        return empMapper.selectByPrimaryKey(empId);
    }

    @Override
    public int insertSelective(OutStore record) {
        return outStoreMapper.insertSelective(record);
    }

    @Override
    public Map<String, Object> selectAlloutStore(OutStore outStore,long empId) {
        PageHelper.startPage(outStore.getPage(),outStore.getRow());
        List<OutStore> outStoreList = outStoreMapper.selectAlloutStore(empId);
        PageInfo<OutStore> pageInfo = new PageInfo<>(outStoreList);
        HashMap<String,Object> map = new HashMap<>();
        map.put("list",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        map.put("prePage",pageInfo.getPrePage());
        map.put("nextPage",pageInfo.getNextPage());
        map.put("firstPage",pageInfo.getNavigateFirstPage());
        map.put("endPage",pageInfo.getLastPage());
        map.put("pageSize",pageInfo.getPageSize());
        map.put("nowPage",pageInfo.getPageNum());
        map.put("pages",pageInfo.getPages());
        map.put("navigatepageNums",pageInfo.getNavigatepageNums());
        return map;
    }

    @Override
    public int deleteByPrimaryKey(Long outId) {
        return outStoreMapper.deleteByPrimaryKey(outId);
    }

}
