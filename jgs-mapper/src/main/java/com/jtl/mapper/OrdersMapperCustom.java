package com.jtl.mapper;

import com.jtl.pojo.Orders;
import com.jtl.vo.OrdersListViewVo;
import com.jtl.vo.ZgAreaVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 自定义的分类mapper
 */
public interface OrdersMapperCustom {

    /**
     * 根据商家ID和日期查询订单数
     * @param nowtime
     * @param storeId
     * @return
     */
    public List<Orders> getOrderList(String nowtime,Integer storeId);


    /**
     * 查询所有订单
     * @param storeId
     * @return
     */
    public List<Orders> getOrderAll(Integer storeId);

    /**
     * 今日成交金额
     * @param map
     * @return
     */
    public List<Orders> selTodayMonry(@Param("paramsMap") Map<String,Object> map);


    /**
     * 根据商家ID和订单状态查询信息
     * @param map
     * @return
     */
    public List<OrdersListViewVo> selectOrdersByFactor(@Param("paramsMap") Map<String,Object> map);


    /**
     * 根据商家ID和订单状态查询信息
     * @param map
     * @return
     */
    public List<OrdersListViewVo> selectOrdersUserByFactor(@Param("paramsMap") Map<String,Object> map);




}