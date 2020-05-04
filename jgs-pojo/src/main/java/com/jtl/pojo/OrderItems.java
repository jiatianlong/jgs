package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "order_items")
public class OrderItems {
    @Id
    private Integer id;

    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 商品ID
     */
    @Column(name = "item_id")
    private Integer itemId;

    /**
     * 商品图标
     */
    @Column(name = "item_img")
    private String itemImg;

    /**
     * 商品名称
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 规格ID
     */
    @Column(name = "item_spec_id")
    private Integer itemSpecId;

    /**
     * 规格名称
     */
    @Column(name = "item_spec_name")
    private String itemSpecName;

    /**
     * 成交价格
     */
    private Double price;

    /**
     * 购买数量
     */
    @Column(name = "buy_counts")
    private Integer buyCounts;

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
     * 获取订单ID
     *
     * @return order_id - 订单ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID
     *
     * @param orderId 订单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
     * 获取商品图标
     *
     * @return item_img - 商品图标
     */
    public String getItemImg() {
        return itemImg;
    }

    /**
     * 设置商品图标
     *
     * @param itemImg 商品图标
     */
    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
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
     * 获取规格ID
     *
     * @return item_spec_id - 规格ID
     */
    public Integer getItemSpecId() {
        return itemSpecId;
    }

    /**
     * 设置规格ID
     *
     * @param itemSpecId 规格ID
     */
    public void setItemSpecId(Integer itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    /**
     * 获取规格名称
     *
     * @return item_spec_name - 规格名称
     */
    public String getItemSpecName() {
        return itemSpecName;
    }

    /**
     * 设置规格名称
     *
     * @param itemSpecName 规格名称
     */
    public void setItemSpecName(String itemSpecName) {
        this.itemSpecName = itemSpecName;
    }

    /**
     * 获取成交价格
     *
     * @return price - 成交价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置成交价格
     *
     * @param price 成交价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取购买数量
     *
     * @return buy_counts - 购买数量
     */
    public Integer getBuyCounts() {
        return buyCounts;
    }

    /**
     * 设置购买数量
     *
     * @param buyCounts 购买数量
     */
    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }
}