package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "order_status")
public class OrderStatus {
    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 订单状态
     */
    @Column(name = "order_status")
    private String orderStatus;

    /**
     * 订单创建时间
     */
    @Column(name = "created_time")
    private String createdTime;

    /**
     * 支付成功时间
     */
    @Column(name = "pay_time")
    private String payTime;

    /**
     * 发货时间
     */
    @Column(name = "deliver_time")
    private String deliverTime;

    /**
     * 交易成功时间
     */
    @Column(name = "success_time")
    private String successTime;

    /**
     * 交易关闭时间
     */
    @Column(name = "close_time")
    private String closeTime;

    /**
     * 留言时间
     */
    @Column(name = "comment_time")
    private String commentTime;

    /**
     * 获取订单ID
     *
     * @return order_id - 订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID
     *
     * @param orderId 订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取订单状态
     *
     * @return order_status - 订单状态
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态
     *
     * @param orderStatus 订单状态
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取订单创建时间
     *
     * @return created_time - 订单创建时间
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置订单创建时间
     *
     * @param createdTime 订单创建时间
     */
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取支付成功时间
     *
     * @return pay_time - 支付成功时间
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * 设置支付成功时间
     *
     * @param payTime 支付成功时间
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取发货时间
     *
     * @return deliver_time - 发货时间
     */
    public String getDeliverTime() {
        return deliverTime;
    }

    /**
     * 设置发货时间
     *
     * @param deliverTime 发货时间
     */
    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }

    /**
     * 获取交易成功时间
     *
     * @return success_time - 交易成功时间
     */
    public String getSuccessTime() {
        return successTime;
    }

    /**
     * 设置交易成功时间
     *
     * @param successTime 交易成功时间
     */
    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    /**
     * 获取交易关闭时间
     *
     * @return close_time - 交易关闭时间
     */
    public String getCloseTime() {
        return closeTime;
    }

    /**
     * 设置交易关闭时间
     *
     * @param closeTime 交易关闭时间
     */
    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * 获取留言时间
     *
     * @return comment_time - 留言时间
     */
    public String getCommentTime() {
        return commentTime;
    }

    /**
     * 设置留言时间
     *
     * @param commentTime 留言时间
     */
    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }
}