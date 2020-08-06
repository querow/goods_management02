package com.hqyj.controller;


import com.hqyj.pojo.Emp;
import com.hqyj.pojo.Goods;
import com.hqyj.pojo.OutStore;
import com.hqyj.pojo.Store;
import com.hqyj.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("store")
@Controller
public class MyController{

    @Autowired
    private MyService service;

    @RequestMapping("index.do")
    public String index(){
        return "index";
    }
    @RequestMapping("storeList.do")
    public String storeList(){
        return "admin-list";
    }

    @RequestMapping("outStoreList.do")
    public String outStoreList(){
        return "admin-listoutstore";
    }

    @RequestMapping("edit.do")
    public String edit(Store store, ModelMap map){
        Integer storeId = store.getStoreId();
        Store store1 = service.selectByPrimaryKey(storeId);
        System.out.println(store1);
        map.addAttribute("store",store1);
        return null;
    }
    @RequestMapping("outStore.do")
    public String outStore(long outNumber,Integer id){
        Store store = service.selectByPrimaryKey(id);
        store.setNum(store.getNum()-outNumber);
        service.updateByPrimaryKeySelective(store);
        List<Goods> goodsList = service.selectByStoreId(id);
        outGoods(outNumber,goodsList);
        return "admin-edit";
    }
    private int outGoods(long outNumber,List<Goods> goodsList){
        //模拟从session中获取emp
        Emp emp = service.selectByPrimaryKeyEmpId((long) 1);
        int update = 0;
        for(int i=0;i<goodsList.size();i++){
            if(goodsList.get(i).getState()==0){
                if(outNumber>goodsList.get(i).getgNum()){
                    outNumber-=goodsList.get(i).getgNum();
                    insertOutStore(goodsList.get(i).getGoodsId(),emp.getEmpId(),goodsList.get(i).getgNum());
                    goodsList.get(i).setgNum((long) 0);
                    goodsList.get(i).setState(1);
                    update += service.updateByPrimaryKeySelective(goodsList.get(i));
                }else{
                    goodsList.get(i).setgNum(goodsList.get(i).getgNum()-outNumber);
                    insertOutStore(goodsList.get(i).getGoodsId(),emp.getEmpId(),outNumber);
                    outNumber=0;
                    if(goodsList.get(i).getgNum()==0){
                        goodsList.get(i).setState(1);
                    }
                    update += service.updateByPrimaryKeySelective(goodsList.get(i));
                    break;
                }
            }
        }
        return update;
    }
    private int insertOutStore(String goodsId,Long empId,long outNum){
        OutStore outStore = new OutStore();
        outStore.setGoodsId(goodsId);
        outStore.setEmpId(empId);
        outStore.setOutDate(new Date());
        outStore.setOutNum(outNum);
        int insert = service.insertSelective(outStore);
        return insert;
    }
    @RequestMapping("deleteOutStore.do")
    public String deleteOutStore(long outId){
        int delete = service.deleteByPrimaryKey(outId);
        return "admin-listoutstore";
    }
    @RequestMapping("selectAll.ajax")
    @ResponseBody
    public Map<String,Object> selectAll(Store store){
            Map<String,Object> storeMap = service.selectAll(store);
        return storeMap;
    }

    @RequestMapping("selectAlloutStore.ajax")
    @ResponseBody
    public Map<String,Object> selectAlloutStore(OutStore outStore){
        //模拟从session中获取emp
        Emp emp = service.selectByPrimaryKeyEmpId((long) 1);
        Map<String,Object> outStoreMap = service.selectAlloutStore(outStore,emp.getEmpId());
        return outStoreMap;
    }


}
