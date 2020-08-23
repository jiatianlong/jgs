package com.jtl.mapper;

import com.jtl.pojo.WithOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WithOrderMapperCustom{

    /**
     * 查询与用户条件相关的订单
     * @param map
     * @return
     */
    public List<WithOrder> getWithOrderAll(@Param("paramsMap") Map<String,Object> map);

    /**
     * 根据用户订单状态查询用户相关订单
     * @param map
     * @return
     */
    public List<WithOrder> getWithOrderByState(@Param("paramsMap") Map<String,Object> map);



    /**
     * 查询与骑手条件相关的订单
     * @param map
     * @return
     */
    public List<WithOrder> getRiderWithOrderAll(@Param("paramsMap") Map<String,Object> map);


    /**
     * 根据用户订单状态查询用户相关订单
     * @param map
     * @return
     */
    public List<WithOrder> getRiderWithOrderByState(@Param("paramsMap") Map<String,Object> map);


    /**
     * 根据用户订单状态查询用户相关订单
     * @param map
     * @return
     */
    public List<WithOrder> getRiderWithOrderByDjd(@Param("paramsMap") Map<String,Object> map);












}