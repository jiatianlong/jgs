package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "items_param")
public class ItemsParam {
    @Id
    private Integer id;

    /**
     * 商品ID
     */
    @Column(name = "item_id")
    private Integer itemId;

    /**
     * 场地
     */
    @Column(name = "produc_place")
    private String producPlace;

    /**
     * 保质期
     */
    @Column(name = "foot_period")
    private String footPeriod;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 生产厂名
     */
    @Column(name = "factory_name")
    private String factoryName;

    /**
     * 生产地址
     */
    @Column(name = "factory_address")
    private String factoryAddress;

    /**
     * 包装方式
     */
    @Column(name = "packaging_method")
    private String packagingMethod;

    /**
     * 重量
     */
    private String weight;

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
     * 获取场地
     *
     * @return produc_place - 场地
     */
    public String getProducPlace() {
        return producPlace;
    }

    /**
     * 设置场地
     *
     * @param producPlace 场地
     */
    public void setProducPlace(String producPlace) {
        this.producPlace = producPlace;
    }

    /**
     * 获取保质期
     *
     * @return foot_period - 保质期
     */
    public String getFootPeriod() {
        return footPeriod;
    }

    /**
     * 设置保质期
     *
     * @param footPeriod 保质期
     */
    public void setFootPeriod(String footPeriod) {
        this.footPeriod = footPeriod;
    }

    /**
     * 获取品牌
     *
     * @return brand - 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置品牌
     *
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取生产厂名
     *
     * @return factory_name - 生产厂名
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * 设置生产厂名
     *
     * @param factoryName 生产厂名
     */
    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    /**
     * 获取生产地址
     *
     * @return factory_address - 生产地址
     */
    public String getFactoryAddress() {
        return factoryAddress;
    }

    /**
     * 设置生产地址
     *
     * @param factoryAddress 生产地址
     */
    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    /**
     * 获取包装方式
     *
     * @return packaging_method - 包装方式
     */
    public String getPackagingMethod() {
        return packagingMethod;
    }

    /**
     * 设置包装方式
     *
     * @param packagingMethod 包装方式
     */
    public void setPackagingMethod(String packagingMethod) {
        this.packagingMethod = packagingMethod;
    }

    /**
     * 获取重量
     *
     * @return weight - 重量
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 设置重量
     *
     * @param weight 重量
     */
    public void setWeight(String weight) {
        this.weight = weight;
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