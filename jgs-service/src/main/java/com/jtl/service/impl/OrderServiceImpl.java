package com.jtl.service.impl;

import com.jtl.bo.SubmitOrderBo;
import com.jtl.enums.OrderStatusEnum;
import com.jtl.enums.YesOrNo;
import com.jtl.mapper.*;
import com.jtl.pojo.*;
import com.jtl.service.ItemsService;
import com.jtl.service.OrderService;
import com.jtl.service.UserAddressService;
import com.jtl.service.UserService;
import com.jtl.vo.OrdersListViewVo;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrdersMapperCustom ordersMapperCustom;

    @Autowired
    private OrderItemsMapper orderItemsMapper;

    @Autowired
    private OrderStatusMapper orderStatusMapper;

    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private UserService userService;

    /**
     * 订单创建
     * @param submitOrderBo
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void createOrder(SubmitOrderBo submitOrderBo) {
        //用户ID
        Integer userId = submitOrderBo.getUserId();
        //商家ID
        Integer storeId = submitOrderBo.getStoreId();
        //地址ID
        Integer addressId = submitOrderBo.getAddressId();
        // 商品规格ID
        String itemSpeIds = submitOrderBo.getItemSpeIds();
        //支付方式
        Integer payMethod = submitOrderBo.getPayMethod();
        //商品数量
        Integer itemNumber = submitOrderBo.getItemNumber();
        //商品价格
        String itemPriceSum = submitOrderBo.getItemPriceSum();
        //买家留言
        String leftMsg = submitOrderBo.getLeftMsg();
        //包邮费用设置为0
        Integer postAmount = 0;

        //用户信息
        Users users = userService.queryUserCont(userId);
        //用户默认地址
        UserAddress userAddress = userAddressService.queryUserAddres(addressId,userId);


        //1.新订单数据保存
        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setStoreId(storeId);
        orders.setReceiverName(users.getRealname());
        orders.setReceiverMobile(users.getMobile());
        //地址相关信息
        orders.setReceiverName(userAddress.getReceiver());
        orders.setReceiverMobile(userAddress.getMobile());
        orders.setReceiverAddress(userAddress.getProvince()+""+
                                    userAddress.getCity()+""+
                                    userAddress.getDistrict()+""+
                                    userAddress.getDetail());
        //订单状态
        orders.setOrderTypeRider(0);
        //订单总价格
        orders.setTotalAmount(Double.valueOf(itemPriceSum));
        //
        orders.setRealPayAmount(Double.valueOf(itemPriceSum));
        //邮费
        orders.setPostAmount(postAmount);
        //支付方式
        orders.setPayMethod(payMethod);
        //用户备注
        orders.setLeftMsg(leftMsg);
        //是否被评价过
        orders.setIsComment(YesOrNo.NO.type);
        //是否配送
        orders.setIsDelivery("NO");
        //是否被删除
        orders.setIsDelete(YesOrNo.NO.type);
        //创建时间
        orders.setCreatedTime(new Date());
        //更新时间
        orders.setUpdatedTime(new Date());
        //保存订单
        ordersMapper.insertUseGeneratedKeys(orders);


        Integer orderId = orders.getId();
        //2.循环根据itemSpeIds保存订单商品信息表，应为购买商品的时候，是按照的商品的规格中价格来计算的，所以这里包括多个
        String itemSpecIdArr[] = itemSpeIds.split(",");
        double totalAmout = 0 ; //商品原价累计
        double realPayAmout = 0; //优惠后的实际支付价格累计
        for (String itemSpecId : itemSpecIdArr){
            //TODO 整合redis后，商品购买的数量重新从redis的购物车中获取

            //商品数量

            //2.1根据规格ID,查询规格的集体信息，主要获取价格
            ItemsSpec itemsSpec = itemsService.queryItemSpecById(Integer.valueOf(itemSpecId));
            totalAmout += itemsSpec.getPriceNormal() * itemNumber;
            realPayAmout += itemsSpec.getPriceDiscount() * itemNumber;

            //2.2根据商品id，获得商品信息及商品图片
            Integer itemId = itemsSpec.getItemId();
            Items items = itemsService.queryItemById(itemId);
            String imgUrl = itemsService.queryItemMainImgById(itemId);

            //2.3循环保存子订单数到数据库
            OrderItems subOrderItem = new OrderItems();
            subOrderItem.setOrderId(orderId);
            subOrderItem.setItemId(itemId);
            subOrderItem.setItemImg(imgUrl);
            subOrderItem.setItemName(items.getItemName());
            subOrderItem.setBuyCounts(itemNumber);
            subOrderItem.setItemSpecId(Integer.valueOf(itemSpecId));
            subOrderItem.setItemSpecName(itemsSpec.getName());
            //此处放实际支付价格
            subOrderItem.setPrice(itemsSpec.getPriceDiscount());
            orderItemsMapper.insert(subOrderItem);

            //2.4在用户提交订单以后，规格表中需要扣除库存
           itemsService.decreaseItemSpecStock(itemSpecId, itemNumber);
        }

        //3.保存订单状态表
        OrderStatus waitPayOrderStatus = new OrderStatus();
        waitPayOrderStatus.setOrderId(orderId);
        waitPayOrderStatus.setOrderStatus(OrderStatusEnum.WAIT_DELIVER.type);
        waitPayOrderStatus.setCreatedTime(new Date());
        orderStatusMapper.insert(waitPayOrderStatus);
    }




    /**
     * 查询当天订单
     * @param nowtime
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Orders> getOrderListView(String nowtime,Integer storeId) {
        List<Orders> list = ordersMapperCustom.getOrderList(nowtime,storeId);
        return list;
    }

    /**
     * 查询所有订单
     * @param storeId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Orders> getOrderAll(Integer storeId) {
        List<Orders> list = ordersMapperCustom.getOrderAll(storeId);
        return list;
    }

    /**
     * 查询今日成交金额
     * @param storeId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Orders> selTodayMonry(Integer storeId,String nowtime) {
        List<Orders> orders = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("storeId",storeId);
        map.put("nowtime",nowtime);
        orders = ordersMapperCustom.selTodayMonry(map);
        return orders;
    }

    /**
     * 根据条件查询商家订单信息及内容
     * @param storeId
     * @param orderStatus
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<OrdersListViewVo> selectOrdersByFactor(Integer storeId,Integer orderStatus) {
        Map<String,Object> map = new HashMap<>();
        map.put("storeId",storeId);
        map.put("orderStatus",orderStatus);
        List<OrdersListViewVo> list = ordersMapperCustom.selectOrdersByFactor(map);
        return list;
    }


    /**
     * 根据条件查询用户订单信息及内容
     * @param userId
     * @param orderStatus
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<OrdersListViewVo> selectOrdersUserByFactor(Integer userId, Integer orderStatus) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("orderStatus",orderStatus);
        List<OrdersListViewVo> list = ordersMapperCustom.selectOrdersUserByFactor(map);
        return list;
    }

    /**
     * 查询骑手订单
     * @param riderId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<OrdersListViewVo> selectRiderOrdersAll(Integer riderId) {
        Map<String,Object> map = new HashMap<>();
        map.put("isDelivery","YES");
        map.put("riderId",riderId);
        List<OrdersListViewVo> list = ordersMapperCustom.selectRiderOrdersAll(map);
        return list;
    }

    /**
     * 查询骑手未接单
     * @param
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<OrdersListViewVo> selectRiderWeiOrders() {
        Map<String,Object> map = new HashMap<>();
        map.put("orderTypeRider",0);
        List<OrdersListViewVo> list = ordersMapperCustom.selectRiderWeiOrders(map);
        return list;
    }

    /**
     * 查询骑手已接单
     * @param riderId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<OrdersListViewVo> selectRiderYiOrdersAll(Integer riderId) {
        Map<String,Object> map = new HashMap<>();
        map.put("riderId",riderId);
        map.put("orderTypeRider",1);
        List<OrdersListViewVo> list = ordersMapperCustom.selectRiderYiWanOrdersAll(map);
        return list;
    }

    /**
     * 查询骑手已完成接单
     * @param riderId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<OrdersListViewVo> selectRiderWanOrdersAll(Integer riderId) {
        Map<String,Object> map = new HashMap<>();
        map.put("riderId",riderId);
        map.put("orderTypeRider",2);
        List<OrdersListViewVo> list = ordersMapperCustom.selectRiderYiWanOrdersAll(map);
        return list;
    }


}
