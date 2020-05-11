package com.jtl.bo;

import io.swagger.annotations.ApiModelProperty;

public class ItemsOrSpecOrImgBO {

    //ID
    private Integer id;

    //商品名称
    private String itemName;

    //商品内容
    private String itemContent;

    //商品优惠价格
    private Double priceDiscount;

    //图片地址
    private String url;

    //累计销售
    private String sellCounts;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public Double getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Double priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSellCounts() {
        return sellCounts;
    }

    public void setSellCounts(String sellCounts) {
        this.sellCounts = sellCounts;
    }

    public ItemsOrSpecOrImgBO(Integer id, String itemName, String itemContent, String sellCounts, double priceDiscount, String url) {
        this.id = id;
        this.itemName = itemName;
        this.itemContent = itemContent;
        this.sellCounts = sellCounts;
        this.priceDiscount = priceDiscount;
        this.url = url;
    }



}
