package com.jtl.controller.rider;

import com.jtl.service.OrderService;
import com.jtl.utils.JTLJSONResult;
import com.jtl.vo.OrdersListViewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "骑手订单相关",tags = {"骑手订单相关的api接口"})
@RestController
@RequestMapping("/riderOrders")
public class RiderOrdersController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "查询骑手所有订单",notes = "查询骑手所有订单",httpMethod = "GET")
    @GetMapping("/getOrderRiderAll")
    public JTLJSONResult getOrderRiderAll(@RequestParam Integer riderId){
        List<OrdersListViewVo> list = orderService.selectRiderOrdersAll(riderId);
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "查询骑手未接单",notes = "查询骑手未接单",httpMethod = "GET")
    @GetMapping("/selectRiderWeiOrder")
    public JTLJSONResult selectRiderWeiOrder(){
        List<OrdersListViewVo> list = orderService.selectRiderWeiOrders();
        return JTLJSONResult.ok(list);
    }

    @ApiOperation(value = "查询骑手已接订单",notes = "查询骑手已接订单",httpMethod = "GET")
    @GetMapping("/getOrderYiRider")
    public JTLJSONResult getOrderYiRider(@RequestParam Integer riderId){
        List<OrdersListViewVo> list = orderService.selectRiderYiOrdersAll(riderId);
        return JTLJSONResult.ok(list);
    }

    @ApiOperation(value = "查询骑手完成订单",notes = "查询骑手完成订单",httpMethod = "GET")
    @GetMapping("/getOrderWanRider")
    public JTLJSONResult getOrderWanRider(@RequestParam Integer riderId){
        List<OrdersListViewVo> list = orderService.selectRiderWanOrdersAll(riderId);
        return JTLJSONResult.ok(list);
    }








}
