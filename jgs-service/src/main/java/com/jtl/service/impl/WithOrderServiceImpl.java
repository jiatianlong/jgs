package com.jtl.service.impl;

import com.jtl.mapper.WithOrderMapper;
import com.jtl.mapper.WithOrderMapperCustom;
import com.jtl.pojo.WithOrder;
import com.jtl.service.WithOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WithOrderServiceImpl implements WithOrderService {

    @Autowired
    private WithOrderMapper withOrderMapper;

    @Autowired
    private WithOrderMapperCustom withOrderMapperCustom;

    /**
     * 添加用户信息
     * @param withOrder
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insert(WithOrder withOrder) {
        withOrder.setWoState("10");
        withOrder.setCreateTime(new Date());
        withOrderMapper.insert(withOrder);
    }
    /**
     * 根据ID查询所有信息
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public WithOrder selAllById(Integer id) {
        return withOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据ID修改
     * @param withOrder
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void woUpdate(WithOrder withOrder) {
        withOrderMapper.updateByPrimaryKeySelective(withOrder);
    }


    /**
     * 查询与用户相关的订单
     * @param userId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<WithOrder> getWithOrderAll(Integer userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        List<WithOrder> list = withOrderMapperCustom.getWithOrderAll(map);
        return list;
    }

    /**
     * 查询与用户相关的订单---已下单
     * @param userId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<WithOrder> getWithOrderByYxd(Integer userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("woState","10");
        map.put("userId",userId);
        List<WithOrder> list = withOrderMapperCustom.getWithOrderByState(map);
        return list;
    }

    /**
     * 查询与用户相关的订单---待送达
     * @param userId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<WithOrder> getWithOrderByDsd(Integer userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("woState","20");
        map.put("userId",userId);
        List<WithOrder> list = withOrderMapperCustom.getWithOrderByState(map);
        return list;
    }

    /**
     * 查询与用户相关的订单---已送达
     * @param userId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<WithOrder> getWithOrderByYsd(Integer userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("woState","30");
        map.put("userId",userId);
        List<WithOrder> list = withOrderMapperCustom.getWithOrderByState(map);
        return list;
    }

    /**
     * 查询与骑手相关的订单
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<WithOrder> getRiderWithOrderAll(Integer riderId) {
        Map<String,Object> map = new HashMap<>();
        map.put("woState","10");
        map.put("riderId",riderId);
        List<WithOrder> list = withOrderMapperCustom.getRiderWithOrderAll(map);
        return list;
    }


    /**
     * 骑手---待接单 10
     * @param riderId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<WithOrder> getRiderWithOrderByDjd(Integer riderId) {
        Map<String,Object> map = new HashMap<>();
        map.put("woState","10");
        map.put("riderId",riderId);
        List<WithOrder> list = withOrderMapperCustom.getRiderWithOrderByDjd(map);
        return list;
    }


    /**
     * 骑手---已接单 20
     * @param riderId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<WithOrder> getRiderWithOrderByYjd(Integer riderId) {
        Map<String,Object> map = new HashMap<>();
        map.put("woState","20");
        map.put("riderId",riderId);
        List<WithOrder> list = withOrderMapperCustom.getRiderWithOrderByState(map);
        return list;
    }

    /**
     * 骑手---已完成 30
     * @param riderId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<WithOrder> getRiderWithOrderByYwc(Integer riderId) {
        Map<String,Object> map = new HashMap<>();
        map.put("woState","30");
        map.put("riderId",riderId);
        List<WithOrder> list = withOrderMapperCustom.getRiderWithOrderByState(map);
        return list;
    }


}
