package com.jtl.vo;

/**
 * 6个最新商品的简单数据类型
 */
public class SimpleItemVo {

    private Integer itemId;
    private String itemName;
    private String itemsImg;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemsImg() {
        return itemsImg;
    }

    public void setItemsImg(String itemsImg) {
        this.itemsImg = itemsImg;
    }
}
