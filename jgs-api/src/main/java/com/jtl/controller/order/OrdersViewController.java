package com.jtl.controller.order;


import com.jtl.enums.OrderStatusEnum;
import com.jtl.pojo.OrderStatus;
import com.jtl.pojo.Orders;
import com.jtl.service.OrderViewService;
import com.jtl.utils.JTLJSONResult;
import com.jtl.vo.OrdersListViewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(value = "订单相关",tags = {"订单相关的api接口"})
@RestController
@RequestMapping("/ordersView")
public class OrdersViewController {

    @Autowired
    private OrderViewService orderViewService;


    @ApiOperation(value = "根据ID查询订单信息",notes = "根据ID查询订单信息",httpMethod = "GET")
    @GetMapping("/queryAllById")
    public JTLJSONResult queryAllById(@RequestParam Integer orderId){
        OrdersListViewVo orders = new OrdersListViewVo();
        orders = orderViewService.queryAllById(orderId);
        return JTLJSONResult.ok(orders);
    }

    @ApiOperation(value = "根据ID修改订单信息",notes = "根据ID修改订单信息",httpMethod = "POST")
    @PostMapping("/update")
    public JTLJSONResult update(@RequestBody Orders orders){
        orderViewService.update(orders);
        return JTLJSONResult.ok();
    }

    @ApiOperation(value = "根据ID修改订单为已接单",notes = "根据ID修改订单为已接单",httpMethod = "POST")
    @PostMapping("/orderYjUpdate")
    public JTLJSONResult orderYjUpdate(@RequestBody Orders orders){
        orderViewService.updateYjOrder(orders);
        return JTLJSONResult.ok();
    }

    @ApiOperation(value = "根据ID修改订单为已发货",notes = "根据ID修改订单为已发货",httpMethod = "POST")
    @PostMapping("/updateFh")
    public JTLJSONResult updateFh(@RequestBody Orders orders){
        orderViewService.updateFh(orders);
        return JTLJSONResult.ok();
    }

    @ApiOperation(value = "根据ID修改订单为已送达",notes = "根据ID修改订单为已送达",httpMethod = "POST")
    @PostMapping("/orderWcUpdate")
    public JTLJSONResult orderWcUpdate(@RequestBody Orders orders){
        orderViewService.update(orders);
        return JTLJSONResult.ok();
    }

    @ApiOperation(value = "根据ID修改订单为已送达",notes = "根据ID修改订单为已送达",httpMethod = "POST")
    @PostMapping("/orderSucessUpdate")
    public JTLJSONResult orderSucessUpdate(@RequestBody Orders orders){
        orderViewService.updateYes(orders);
        return JTLJSONResult.ok();
    }





}
