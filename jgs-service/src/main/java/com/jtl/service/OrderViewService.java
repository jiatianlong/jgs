package com.jtl.service;

import com.jtl.pojo.OrderStatus;
import com.jtl.pojo.Orders;
import com.jtl.vo.OrdersListViewVo;

public interface OrderViewService {

    /**
     * 根据ID查询订单信息
     * @param id
     * @return
     */
    public OrdersListViewVo queryAllById(Integer id);

    /**
     * 修改信息
     * @param orders
     */
    public void update(Orders orders);

    /**
     * 修改为已接订单
     * @param orders
     */
    public void updateYjOrder(Orders orders);

    /**
     * 修改订单为交易完成
     * @param orders
     * @return
     */
    public void updateYes(Orders orders);

}
