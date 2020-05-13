package com.jtl.bo;

import io.swagger.annotations.ApiModelProperty;

public class ItemsBO {

    @ApiModelProperty(value = "商家ID",name = "storeId",example = "商家ID",required = true)
    private int storeId;
    @ApiModelProperty(value = "商品名称",name = "itemName",example = "商品名称",required = true)
    private String itemName;
    @ApiModelProperty(value = "分类ID",name = "catId",example = "0,1,2",required = true)
    private String catId;
    @ApiModelProperty(value = "图片地址",name = "itemImgPath",example = "图片地址",required = true)
    private String itemImgPath;
    @ApiModelProperty(value = "上架状态",name = "onOffStatus",example = "0,1",required = true)
    private String onOffStatus;
    @ApiModelProperty(value = "商品描述",name = "content",example = "商品描述",required = true)
    private String content;
    @ApiModelProperty(value = "库存",name = "itemskc",example = "100",required = true)
    private String itemskc;
    @ApiModelProperty(value = "价格",name = "itemsPrice",example = "100.25",required = true)
    private double itemsPrice;
    @ApiModelProperty(value = "品牌",name = "brand",example = "xxx",required = true)
    private String brand;


    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getItemImgPath() {
        return itemImgPath;
    }

    public void setItemImgPath(String itemImgPath) {
        this.itemImgPath = itemImgPath;
    }

    public String getOnOffStatus() {
        return onOffStatus;
    }

    public void setOnOffStatus(String onOffStatus) {
        this.onOffStatus = onOffStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getItemskc() {
        return itemskc;
    }

    public void setItemskc(String itemskc) {
        this.itemskc = itemskc;
    }

    public double getItemsPrice() {
        return itemsPrice;
    }

    public void setItemsPrice(double itemsPrice) {
        this.itemsPrice = itemsPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
