package com.jtl.service;

import com.jtl.pojo.WithOrder;

import java.util.List;

public interface WithOrderService {

    /**
     * 添加订单信息
     */
    public void insert(WithOrder withOrder);

    /**
     * 根据ID查询所有信息
     * @param id
     * @return
     */
    public WithOrder selAllById(Integer id);

    /**
     * 查询与用户相关的订单
     */
    public List<WithOrder> getWithOrderAll(Integer userId);

    /**
     * 根据订单状态查询用户相关订单---已下单 10
     * @param userId
     * @return
     */
    public List<WithOrder> getWithOrderByYxd(Integer userId);

    /**
     * 根据订单状态查询用户相关订单---待送达 20
     * @param userId
     * @return
     */
    public List<WithOrder> getWithOrderByDsd(Integer userId);


    /**
     * 根据订单状态查询用户相关订单---带送达 30
     * @param userId
     * @return
     */
    public List<WithOrder> getWithOrderByYsd(Integer userId);



    /**
     * 查询与骑手相关的订单
     */
    public List<WithOrder> getRiderWithOrderAll(Integer riderId);

    /**
     * 骑手---待接单 10
     * @param riderId
     * @return
     */
    public List<WithOrder> getRiderWithOrderByDjd(Integer riderId);


    /**
     * 骑手---已接单 20
     * @param riderId
     * @return
     */
    public List<WithOrder> getRiderWithOrderByYjd(Integer riderId);



    /**
     * 骑手---已完成 30
     * @param riderId
     * @return
     */
    public List<WithOrder> getRiderWithOrderByYwc(Integer riderId);




}
