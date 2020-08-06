package com.hqyj.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OutStore extends MyPage{
    private Long outId;

    private String goodsId;

    private Long empId;

    private String outDate;

    private Long outNum;

    public Long getOutId() {
        return outId;
    }

    public void setOutId(Long outId) {
        this.outId = outId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        SimpleDateFormat sd = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

        this.outDate = sd.format(outDate);
    }

    public Long getOutNum() {
        return outNum;
    }

    public void setOutNum(Long outNum) {
        this.outNum = outNum;
    }


    @Override
    public String toString() {
        return "OutStore{" +
                "outId=" + outId +
                ", goodsId='" + goodsId + '\'' +
                ", empId=" + empId +
                ", outDate=" + outDate +
                ", outNum=" + outNum +
                '}';
    }
}