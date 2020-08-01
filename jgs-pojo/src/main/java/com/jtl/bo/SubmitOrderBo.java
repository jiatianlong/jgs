package com.jtl.bo;


/**
 * 用于创建订单的BO
 */
public class SubmitOrderBo {

    //用户ID
    private Integer userId;
    //商家ID
    private Integer storeId;
    //地址ID
    private Integer addressId;
    // 商品规格ID
    private String itemSpeIds;
    // 总价格
    private String itemPriceSum;
    // 支付方式
    private Integer payMethod;
    //商品数量
    private Integer itemNumber;
    //买家留言
    private String leftMsg;

    public String getItemPriceSum() {
        return itemPriceSum;
    }

    public void setItemPriceSum(String itemPriceSum) {
        this.itemPriceSum = itemPriceSum;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getItemSpeIds() {
        return itemSpeIds;
    }

    public void setItemSpeIds(String itemSpeIds) {
        this.itemSpeIds = itemSpeIds;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public String getLeftMsg() {
        return leftMsg;
    }

    public void setLeftMsg(String leftMsg) {
        this.leftMsg = leftMsg;
    }

    public SubmitOrderBo(Integer userId, Integer storeId, Integer addressId, String itemSpeIds, Integer payMethod, String leftMsg) {
        this.userId = userId;
        this.storeId = storeId;
        this.addressId = addressId;
        this.itemSpeIds = itemSpeIds;
        this.payMethod = payMethod;
        this.leftMsg = leftMsg;
    }
}
