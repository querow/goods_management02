package com.hqyj.pojo;

public class Store extends MyPage{
    private Integer storeId;

    private String storeName;

    private Long num;

    private Long uNum;

    private Long dNum;

    private Integer state;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getuNum() {
        return uNum;
    }

    public void setuNum(Long uNum) {
        this.uNum = uNum;
    }

    public Long getdNum() {
        return dNum;
    }

    public void setdNum(Long dNum) {
        this.dNum = dNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", num=" + num +
                ", uNum=" + uNum +
                ", dNum=" + dNum +
                ", state=" + state +
                '}';
    }
}