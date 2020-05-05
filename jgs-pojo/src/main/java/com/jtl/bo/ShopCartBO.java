package com.jtl.bo;

public class ShopCartBO {

    private Integer userId;
    private Integer itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private Integer byCounts;
    private String priceDiscount;
    private String priceNormal;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }


    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getByCounts() {
        return byCounts;
    }

    public void setByCounts(Integer byCounts) {
        this.byCounts = byCounts;
    }

    public String getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(String priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public String getPriceNormal() {
        return priceNormal;
    }

    public void setPriceNormal(String priceNormal) {
        this.priceNormal = priceNormal;
    }

    public ShopCartBO(Integer userId,Integer itemId, String itemImgUrl, String itemName, String specId, String specName, Integer byCounts, String priceDiscount, String priceNormal) {
        this.userId = userId;
        this.itemId = itemId;
        this.itemImgUrl = itemImgUrl;
        this.itemName = itemName;
        this.specId = specId;
        this.specName = specName;
        this.byCounts = byCounts;
        this.priceDiscount = priceDiscount;
        this.priceNormal = priceNormal;
    }
}
