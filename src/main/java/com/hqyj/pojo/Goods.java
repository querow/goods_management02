package com.hqyj.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private String goodsId;

    private String name;

    private Integer typeId;

    private Integer producerId;

    private BigDecimal cost;

    private Integer storeId;

    private Date produceDate;

    private Date expireDate;

    private Long gNum;

    private Integer state;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getProducerId() {
        return producerId;
    }

    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Long getgNum() {
        return gNum;
    }

    public void setgNum(Long gNum) {
        this.gNum = gNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId='" + goodsId + '\'' +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", producerId=" + producerId +
                ", cost=" + cost +
                ", storeId=" + storeId +
                ", produceDate=" + produceDate +
                ", expireDate=" + expireDate +
                ", gNum=" + gNum +
                ", state=" + state +
                '}';
    }
}