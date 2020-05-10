package com.jtl.service;

import com.jtl.bo.SubmitOrderBo;

public interface OrderService {


    /**
     * 用于创建订单相关信息
     * @param submitOrderBo
     */
    public void createOrder(SubmitOrderBo submitOrderBo);



}
