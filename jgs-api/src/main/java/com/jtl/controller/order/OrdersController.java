package com.jtl.controller.order;


import com.jtl.bo.AddressBO;
import com.jtl.bo.SubmitOrderBo;
import com.jtl.enums.PayMethod;
import com.jtl.pojo.UserAddress;
import com.jtl.service.UserAddressService;
import com.jtl.utils.JTLJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "订单相关",tags = {"订单相关的api接口"})
@RestController
@RequestMapping("/orders")
public class OrdersController {


    @ApiOperation(value = "用户下单",notes = "用户下单",httpMethod = "POST")
    @PostMapping("/create")
    public JTLJSONResult create(@RequestBody SubmitOrderBo submitOrderBo){

        if (submitOrderBo.getPayMethod() != PayMethod.WEIXIN.type
        && submitOrderBo.getPayMethod() != PayMethod.ALIPAY.type){
            return JTLJSONResult.errorMsg("支付方式不支持");
        }

        // 1.创建订单
        // 2.创建订单以后，移除购物车中已结算（已提交）的商品
        // 3.向支付中心发送当前订单，用于保存支付中心的订单数据


        return JTLJSONResult.ok();
    }








}
