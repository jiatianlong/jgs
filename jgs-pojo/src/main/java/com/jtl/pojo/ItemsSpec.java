package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "items_spec")
public class ItemsSpec {
    @Id
    private Integer id;

    /**
     * 商品ID
     */
    @Column(name = "item_id")
    private Integer itemId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 折扣力度
     */
    private Integer discounts;

    /**
     * 优惠价
     */
    @Column(name = "price_discount")
    private Double priceDiscount;

    /**
     * 原价
     */
    @Column(name = "price_normal")
    private Double priceNormal;

    /**
     * 图片
     */
    private String url;

    /**
     * 拓展字段
     */
    private String extend;

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
     * 获取商品ID
     *
     * @return item_id - 商品ID
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * 设置商品ID
     *
     * @param itemId 商品ID
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取折扣力度
     *
     * @return discounts - 折扣力度
     */
    public Integer getDiscounts() {
        return discounts;
    }

    /**
     * 设置折扣力度
     *
     * @param discounts 折扣力度
     */
    public void setDiscounts(Integer discounts) {
        this.discounts = discounts;
    }

    /**
     * 获取优惠价
     *
     * @return price_discount - 优惠价
     */
    public Double getPriceDiscount() {
        return priceDiscount;
    }

    /**
     * 设置优惠价
     *
     * @param priceDiscount 优惠价
     */
    public void setPriceDiscount(Double priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    /**
     * 获取原价
     *
     * @return price_normal - 原价
     */
    public Double getPriceNormal() {
        return priceNormal;
    }

    /**
     * 设置原价
     *
     * @param priceNormal 原价
     */
    public void setPriceNormal(Double priceNormal) {
        this.priceNormal = priceNormal;
    }

    /**
     * 获取图片
     *
     * @return url - 图片
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片
     *
     * @param url 图片
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取拓展字段
     *
     * @return extend - 拓展字段
     */
    public String getExtend() {
        return extend;
    }

    /**
     * 设置拓展字段
     *
     * @param extend 拓展字段
     */
    public void setExtend(String extend) {
        this.extend = extend;
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