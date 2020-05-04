package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Items {
    @Id
    private Integer id;

    /**
     * 店铺ID
     */
    @Column(name = "store_shop_id")
    private Integer storeShopId;

    /**
     * 商品名称
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 商品品牌
     */
    private String brand;

    /**
     * 商品分类
     */
    @Column(name = "cat_id")
    private Integer catId;

    /**
     * 商品一级分类
     */
    @Column(name = "root_cat_id")
    private Integer rootCatId;

    /**
     * 累计销售
     */
    @Column(name = "sell_counts")
    private String sellCounts;

    /**
     * 上架状态
     */
    @Column(name = "on_off_status")
    private String onOffStatus;

    /**
     * 商品内容
     */
    private String content;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private String createdTime;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private String updatedTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取店铺ID
     *
     * @return store_shop_id - 店铺ID
     */
    public Integer getStoreShopId() {
        return storeShopId;
    }

    /**
     * 设置店铺ID
     *
     * @param storeShopId 店铺ID
     */
    public void setStoreShopId(Integer storeShopId) {
        this.storeShopId = storeShopId;
    }

    /**
     * 获取商品名称
     *
     * @return item_name - 商品名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置商品名称
     *
     * @param itemName 商品名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 获取商品品牌
     *
     * @return brand - 商品品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置商品品牌
     *
     * @param brand 商品品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取商品分类
     *
     * @return cat_id - 商品分类
     */
    public Integer getCatId() {
        return catId;
    }

    /**
     * 设置商品分类
     *
     * @param catId 商品分类
     */
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    /**
     * 获取商品一级分类
     *
     * @return root_cat_id - 商品一级分类
     */
    public Integer getRootCatId() {
        return rootCatId;
    }

    /**
     * 设置商品一级分类
     *
     * @param rootCatId 商品一级分类
     */
    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    /**
     * 获取累计销售
     *
     * @return sell_counts - 累计销售
     */
    public String getSellCounts() {
        return sellCounts;
    }

    /**
     * 设置累计销售
     *
     * @param sellCounts 累计销售
     */
    public void setSellCounts(String sellCounts) {
        this.sellCounts = sellCounts;
    }

    /**
     * 获取上架状态
     *
     * @return on_off_status - 上架状态
     */
    public String getOnOffStatus() {
        return onOffStatus;
    }

    /**
     * 设置上架状态
     *
     * @param onOffStatus 上架状态
     */
    public void setOnOffStatus(String onOffStatus) {
        this.onOffStatus = onOffStatus;
    }

    /**
     * 获取商品内容
     *
     * @return content - 商品内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置商品内容
     *
     * @param content 商品内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新时间
     *
     * @return updated_time - 更新时间
     */
    public String getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}