package com.jtl.controller.order;
import com.jtl.bo.SubmitOrderBo;
import com.jtl.enums.PayMethod;
import com.jtl.pojo.Orders;
import com.jtl.service.OrderService;
import com.jtl.utils.JTLJSONResult;
import com.jtl.vo.OrdersHomeInformationVo;
import com.jtl.vo.OrdersListViewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Api(value = "商家用户订单相关",tags = {"商家用户订单相关的api接口"})
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "用户下单",notes = "用户下单",httpMethod = "POST")
    @PostMapping("/create")
    public JTLJSONResult create(@RequestBody SubmitOrderBo submitOrderBo){

        if (submitOrderBo.getPayMethod() != PayMethod.WEIXIN.type
        && submitOrderBo.getPayMethod() != PayMethod.ALIPAY.type){
            return JTLJSONResult.errorMsg("支付方式不支持");
        }

        // 1.创建订单
        orderService.createOrder(submitOrderBo);

        // 2.创建订单以后，移除购物车中已结算（已提交）的商品
        // 3.向支付中心发送当前订单，用于保存支付中心的订单数据
        return JTLJSONResult.ok();
    }


    @ApiOperation(value = "查询商家订单信息总览",notes = "查询商家订单信息总览",httpMethod = "GET")
    @GetMapping("/getorderListView")
    public JTLJSONResult getorderListView(@RequestParam Integer storeId){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date t = new Date();
        //今日日期
        String todaytime = df.format(t);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(t);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        t = (Date) calendar.getTime();
        //昨日日期
        String zrtime = df.format(t);

        List<Orders> list = new ArrayList<>();
        List<Orders> allList = new ArrayList<>();
        List<OrdersListViewVo> orListType = new ArrayList<>();
        List<Orders> zrlist = new ArrayList<>();
        OrdersHomeInformationVo vo = new OrdersHomeInformationVo();
        if (storeId != null){
           //今日订单
           list = orderService.getOrderListView(todaytime,storeId);
           //今日订单数
           String todayListSize =String.valueOf(list.size());
           //待发货订单
           orListType = orderService.selectOrdersByFactor(storeId,20);
           //待发货订单数
           String dfhOrdersSize = String.valueOf(orListType.size());
           //历史订单
           allList = orderService.getOrderAll(storeId);
           //历史订单数
           String lishiOrdersSize = String.valueOf(allList.size());

           //今日成交金额
           List<Orders> ordersList= orderService.selTodayMonry(storeId,todaytime);
           double todMoney = 0;
           for (int i = 0; i < ordersList.size();i++){
               todMoney+= ordersList.get(i).getRealPayAmount();
           }
           //昨日订单数
           zrlist = orderService.getOrderListView(zrtime,storeId);
           String zrordslistSize = String.valueOf(zrlist.size());
           vo.setTodayList(todayListSize);
           vo.setDfhOrders(dfhOrdersSize);
           vo.setLishiOrders(lishiOrdersSize);
           vo.setTodayMoney(todMoney);
           vo.setZrordslist(zrordslistSize);
        }else{
            return JTLJSONResult.errorMsg("商家ID为空");
        }
        return JTLJSONResult.ok(vo);
    }


    @ApiOperation(value = "查询商家所有订单信息",notes = "查询商家所有订单信息",httpMethod = "GET")
    @GetMapping("/getOrderAll")
    public JTLJSONResult getOrderAll(@RequestParam Integer storeId){
        List<OrdersListViewVo> orListType = orderService.selectOrdersByFactor(storeId,null);
        return JTLJSONResult.ok(orListType);
    }


    @ApiOperation(value = "查询商家待发货订单信息",notes = "查询商家待发货订单信息",httpMethod = "GET")
    @GetMapping("/getorderdfh")
    public JTLJSONResult getorderdfh(@RequestParam Integer storeId){
        List<OrdersListViewVo> orListType = new ArrayList<>();
        if (storeId != null){
            //待发货订单
            orListType = orderService.selectOrdersByFactor(storeId,20);
        }else{
            return JTLJSONResult.errorMsg("商家ID为空");
        }
        return JTLJSONResult.ok(orListType);
    }

    @ApiOperation(value = "查询商家已发货,用户待收货订单信息",notes = "查询商家已发货,用户待收货订单信息",httpMethod = "GET")
    @GetMapping("/getorderyfh")
    public JTLJSONResult getorderyfh(@RequestParam Integer storeId){
        List<OrdersListViewVo> orListType = new ArrayList<>();
        if (storeId != null){
            //商家已发货,用户待收货
            orListType = orderService.selectOrdersByFactor(storeId,30);
        }else{
            return JTLJSONResult.errorMsg("商家ID为空");
        }
        return JTLJSONResult.ok(orListType);
    }


    @ApiOperation(value = "查询商家订单交易成功信息(用户已收货)",notes = "查询商家订单交易成功信息(用户已收货)",httpMethod = "GET")
    @GetMapping("/getorderysh")
    public JTLJSONResult getorderysh(@RequestParam Integer storeId){
        List<OrdersListViewVo> orListType = new ArrayList<>();
        if (storeId != null){
            //已完成 交易完成
            orListType = orderService.selectOrdersByFactor(storeId,40);
        }else{
            return JTLJSONResult.errorMsg("商家ID为空");
        }
        return JTLJSONResult.ok(orListType);
    }




    @ApiOperation(value = "查询用户所有订单信息",notes = "查询用户所有订单信息",httpMethod = "GET")
    @GetMapping("/getOrderUserAll")
    public JTLJSONResult getOrderUserAll(@RequestParam Integer userId){
        List<OrdersListViewVo> orListType = orderService.selectOrdersUserByFactor(userId,null);
        return JTLJSONResult.ok(orListType);
    }

    @ApiOperation(value = "查询用户待发货订单信息",notes = "查询用户待发货订单信息",httpMethod = "GET")
    @GetMapping("/getorderUserdfh")
    public JTLJSONResult getorderUserdfh(@RequestParam Integer userId){
        List<OrdersListViewVo> orListType = new ArrayList<>();
        if (userId != null){
            //待发货订单
            orListType = orderService.selectOrdersUserByFactor(userId,20);
        }else{
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        return JTLJSONResult.ok(orListType);
    }


    @ApiOperation(value = "查询用户待收货订单信息",notes = "查询用户待收货订单信息",httpMethod = "GET")
    @GetMapping("/getorderUsersyfh")
    public JTLJSONResult getorderUsersyfh(@RequestParam Integer userId){
        List<OrdersListViewVo> orListType = new ArrayList<>();
        if (userId != null){
            //商家已发货,用户待收货
            orListType = orderService.selectOrdersUserByFactor(userId,30);
        }else{
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        return JTLJSONResult.ok(orListType);
    }


    @ApiOperation(value = "查询商家订单交易成功信息(用户已收货)",notes = "查询用户订单交易成功信息(用户已收货)",httpMethod = "GET")
    @GetMapping("/getorderUserysh")
    public JTLJSONResult getorderUserysh(@RequestParam Integer userId){
        List<OrdersListViewVo> orListType = new ArrayList<>();
        if (userId != null){
            //已完成 交易完成
            orListType = orderService.selectOrdersUserByFactor(userId,40);
        }else{
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        return JTLJSONResult.ok(orListType);
    }










}
