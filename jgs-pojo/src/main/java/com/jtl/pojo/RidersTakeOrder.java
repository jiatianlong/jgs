package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "riders_take_order")
public class RidersTakeOrder {
    @Id
    private Integer id;

    /**
     * 骑手ID
     */
    @Column(name = "rider_id")
    private Integer riderId;

    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 送达状态
     */
    @Column(name = "ser_states")
    private String serStates;

    /**
     * 接单时间
     */
    @Column(name = "receipt_time")
    private String receiptTime;

    /**
     * 订单交付时间
     */
    @Column(name = "deliver_time")
    private String deliverTime;

    /**
     * 送货距离
     */
    private String ranger;

    /**
     * 运费
     */
    private String freight;

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
     * 获取骑手ID
     *
     * @return rider_id - 骑手ID
     */
    public Integer getRiderId() {
        return riderId;
    }

    /**
     * 设置骑手ID
     *
     * @param riderId 骑手ID
     */
    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
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
     * 获取送达状态
     *
     * @return ser_states - 送达状态
     */
    public String getSerStates() {
        return serStates;
    }

    /**
     * 设置送达状态
     *
     * @param serStates 送达状态
     */
    public void setSerStates(String serStates) {
        this.serStates = serStates;
    }

    /**
     * 获取接单时间
     *
     * @return receipt_time - 接单时间
     */
    public String getReceiptTime() {
        return receiptTime;
    }

    /**
     * 设置接单时间
     *
     * @param receiptTime 接单时间
     */
    public void setReceiptTime(String receiptTime) {
        this.receiptTime = receiptTime;
    }

    /**
     * 获取订单交付时间
     *
     * @return deliver_time - 订单交付时间
     */
    public String getDeliverTime() {
        return deliverTime;
    }

    /**
     * 设置订单交付时间
     *
     * @param deliverTime 订单交付时间
     */
    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }

    /**
     * 获取送货距离
     *
     * @return ranger - 送货距离
     */
    public String getRanger() {
        return ranger;
    }

    /**
     * 设置送货距离
     *
     * @param ranger 送货距离
     */
    public void setRanger(String ranger) {
        this.ranger = ranger;
    }

    /**
     * 获取运费
     *
     * @return freight - 运费
     */
    public String getFreight() {
        return freight;
    }

    /**
     * 设置运费
     *
     * @param freight 运费
     */
    public void setFreight(String freight) {
        this.freight = freight;
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