package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Orders {
    @Id
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 商家ID
     */
    @Column(name = "store_id")
    private Integer storeId;

    /**
     * 收货人
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 收货人手机号
     */
    @Column(name = "receiver_mobile")
    private String receiverMobile;

    /**
     * 收货人地址
     */
    @Column(name = "receiver_address")
    private String receiverAddress;

    /**
     * 发货地址
     */
    @Column(name = "shipping_address")
    private String shippingAddress;

    /**
     * 订单总价格
     */
    @Column(name = "total_amount")
    private Double totalAmount;

    /**
     * 实际支付价格
     */
    @Column(name = "real_pay_amount")
    private Double realPayAmount;

    /**
     * 运费
     */
    @Column(name = "post_amount")
    private Integer postAmount;

    /**
     * 支付方式
     */
    @Column(name = "pay_method")
    private Integer payMethod;

    /**
     * 买家留言
     */
    @Column(name = "left_msg")
    private String leftMsg;


    /**
     * 是否配送
     */
    private String isDelivery;

    /**
     * 拓展字段
     */
    private String extand;

    /**
     * 买家是否评价
     */
    @Column(name = "is_comment")
    private Integer isComment;

    /**
     * 逻辑删除 0删除 1未删除 
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 骑手ID
     */
    @Column(name = "rider_id")
    private Integer riderId;

    /**
     * 订单接单状态 0未接单，1已接单，2已送达
     */
    @Column(name = "order_type_rider")
    private Integer orderTypeRider;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    public String getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(String isDelivery) {
        this.isDelivery = isDelivery;
    }

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
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取商家ID
     *
     * @return store_id - 商家ID
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * 设置商家ID
     *
     * @param storeId 商家ID
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取收货人
     *
     * @return receiver_name - 收货人
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置收货人
     *
     * @param receiverName 收货人
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取收货人手机号
     *
     * @return receiver_mobile - 收货人手机号
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * 设置收货人手机号
     *
     * @param receiverMobile 收货人手机号
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    /**
     * 获取收货人地址
     *
     * @return receiver_address - 收货人地址
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * 设置收货人地址
     *
     * @param receiverAddress 收货人地址
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * 获取发货地址
     *
     * @return shipping_address - 发货地址
     */
    public String getShippingAddress() {
        return shippingAddress;
    }

    /**
     * 设置发货地址
     *
     * @param shippingAddress 发货地址
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * 获取订单总价格
     *
     * @return total_amount - 订单总价格
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置订单总价格
     *
     * @param totalAmount 订单总价格
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取实际支付价格
     *
     * @return real_pay_amount - 实际支付价格
     */
    public Double getRealPayAmount() {
        return realPayAmount;
    }

    /**
     * 设置实际支付价格
     *
     * @param realPayAmount 实际支付价格
     */
    public void setRealPayAmount(Double realPayAmount) {
        this.realPayAmount = realPayAmount;
    }

    /**
     * 获取运费
     *
     * @return post_amount - 运费
     */
    public Integer getPostAmount() {
        return postAmount;
    }

    /**
     * 设置运费
     *
     * @param postAmount 运费
     */
    public void setPostAmount(Integer postAmount) {
        this.postAmount = postAmount;
    }

    /**
     * 获取支付方式
     *
     * @return pay_method - 支付方式
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * 设置支付方式
     *
     * @param payMethod 支付方式
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * 获取买家留言
     *
     * @return left_msg - 买家留言
     */
    public String getLeftMsg() {
        return leftMsg;
    }

    /**
     * 设置买家留言
     *
     * @param leftMsg 买家留言
     */
    public void setLeftMsg(String leftMsg) {
        this.leftMsg = leftMsg;
    }

    /**
     * 获取拓展字段
     *
     * @return extand - 拓展字段
     */
    public String getExtand() {
        return extand;
    }

    /**
     * 设置拓展字段
     *
     * @param extand 拓展字段
     */
    public void setExtand(String extand) {
        this.extand = extand;
    }

    /**
     * 获取买家是否评价
     *
     * @return is_comment - 买家是否评价
     */
    public Integer getIsComment() {
        return isComment;
    }

    /**
     * 设置买家是否评价
     *
     * @param isComment 买家是否评价
     */
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    /**
     * 获取逻辑删除 0删除 1未删除 
     *
     * @return is_delete - 逻辑删除 0删除 1未删除 
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置逻辑删除 0删除 1未删除 
     *
     * @param isDelete 逻辑删除 0删除 1未删除 
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
     * 获取订单接单状态 0未接单，1已接单，2已送达
     *
     * @return order_type_rider - 订单接单状态 0未接单，1已接单，2已送达
     */
    public Integer getOrderTypeRider() {
        return orderTypeRider;
    }

    /**
     * 设置订单接单状态 0未接单，1已接单，2已送达
     *
     * @param orderTypeRider 订单接单状态 0未接单，1已接单，2已送达
     */
    public void setOrderTypeRider(Integer orderTypeRider) {
        this.orderTypeRider = orderTypeRider;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}