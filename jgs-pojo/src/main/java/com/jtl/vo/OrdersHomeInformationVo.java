package com.jtl.vo;

/**
 *  商家信息展示首页的信息
 */
public class OrdersHomeInformationVo {

    //今日订单数
    private String todayList;
    //待发货订单
    private String dfhOrders;
    //历史订单
    private String lishiOrders;
    //今日订单金额
    private Double todayMoney;
    //昨日订单数
    private String zrordslist;

    public String getTodayList() {
        return todayList;
    }

    public void setTodayList(String todayList) {
        this.todayList = todayList;
    }

    public String getDfhOrders() {
        return dfhOrders;
    }

    public void setDfhOrders(String dfhOrders) {
        this.dfhOrders = dfhOrders;
    }

    public String getLishiOrders() {
        return lishiOrders;
    }

    public void setLishiOrders(String lishiOrders) {
        this.lishiOrders = lishiOrders;
    }

    public Double getTodayMoney() {
        return todayMoney;
    }

    public void setTodayMoney(Double todayMoney) {
        this.todayMoney = todayMoney;
    }

    public String getZrordslist() {
        return zrordslist;
    }

    public void setZrordslist(String zrordslist) {
        this.zrordslist = zrordslist;
    }
}
