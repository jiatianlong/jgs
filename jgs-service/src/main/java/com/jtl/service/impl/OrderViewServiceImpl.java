package com.jtl.service.impl;

import com.jtl.enums.OrderStatusEnum;
import com.jtl.mapper.OrderStatusMapper;
import com.jtl.mapper.OrdersMapper;
import com.jtl.mapper.OrdersMapperCustom;
import com.jtl.pojo.OrderStatus;
import com.jtl.pojo.Orders;
import com.jtl.service.OrderViewService;
import com.jtl.vo.OrdersListViewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderViewServiceImpl implements OrderViewService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrdersMapperCustom ordersMapperCustom;

    @Autowired
    private OrderStatusMapper orderStatusMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public OrdersListViewVo queryAllById(Integer id) {
        return ordersMapperCustom.queryAllById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void update(Orders orders) {
        ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateYjOrder(Orders orders) {
        ordersMapper.updateByPrimaryKeySelective(orders);

        //(后面在商家端再修改)
        //修改订单状态表
        OrderStatus waitPayOrderStatus = new OrderStatus();
        waitPayOrderStatus.setOrderId(orders.getId());
        waitPayOrderStatus.setOrderStatus(OrderStatusEnum.WAIT_RECEIVE.type);
        waitPayOrderStatus.setDeliverTime(new Date());

        orderStatusMapper.updateByPrimaryKeySelective(waitPayOrderStatus);
    }

    /**
     * 用户提交订单 订单状态为交易完成
     * @param orders
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateYes(Orders orders) {
        OrderStatus waitPayOrderStatus = new OrderStatus();
        waitPayOrderStatus.setOrderId(orders.getId());
        waitPayOrderStatus.setOrderStatus(OrderStatusEnum.SUCCESS.type);
        waitPayOrderStatus.setSuccessTime(new Date());
        orderStatusMapper.updateByPrimaryKeySelective(waitPayOrderStatus);
    }

}
