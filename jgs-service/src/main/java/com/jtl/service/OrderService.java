package com.jtl.service;

import com.jtl.bo.SubmitOrderBo;
import com.jtl.pojo.Orders;
import com.jtl.vo.OrdersListViewVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {


    /**
     * 用于创建订单相关信息
     * @param submitOrderBo
     */
    public void createOrder(SubmitOrderBo submitOrderBo);


    /**
     * 查询当天日期订单
     * @return
     */
    public List<Orders> getOrderListView(String nowtime,Integer storeId);

    /**
     * 查询所有订单
     * @param storeId
     * @return
     */
    public List<Orders> getOrderAll(Integer storeId);

    /**
     * 查询今日成交金额
     * @param storeId
     * @return
     */
    public List<Orders> selTodayMonry(Integer storeId,String nowtime);

    /**
     * 根据条件查询商家订单信息及内容
     * @param storeId
     * @param orderStatus
     * @return
     */
    public List<OrdersListViewVo> selectOrdersByFactor(Integer storeId,Integer orderStatus);


    /**
     * 根据条件查询用户订单信息及内容
     * @param userId
     * @param orderStatus
     * @return
     */
    public List<OrdersListViewVo> selectOrdersUserByFactor(Integer userId,Integer orderStatus);

}
