package com.jtl.controller.withorder;


import com.jtl.pojo.Users;
import com.jtl.pojo.WithOrder;
import com.jtl.service.WithOrderService;
import com.jtl.utils.JTLJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "用于配单信息的相关接口",tags = {"用于配单信息的相关接口"})
@RestController
@RequestMapping("/withorder")
public class WithOrderController {

    @Autowired
    private WithOrderService withOrderService;


    @ApiOperation(value = "根据ID查询配单信息",notes = "根据ID查询配单信息",httpMethod = "GET")
    @GetMapping("/selWoAllById")
    public JTLJSONResult selWoAllById(@RequestParam Integer id){
        //判断ID是否为空
        if(id == null){
            return JTLJSONResult.errorMsg("ID为空");
        }
        WithOrder withOrder = withOrderService.selAllById(id);
        return JTLJSONResult.ok(withOrder);
    }




    @ApiOperation(value = "根据用户ID查询配单信息",notes = "根据用户ID查询配单信息",httpMethod = "GET")
    @GetMapping("/getWithOrderAll")
    public JTLJSONResult getWithOrderAll(@RequestParam Integer userId){
        //判断ID是否为空
        if(userId == null){
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        List<WithOrder> list = withOrderService.getWithOrderAll(userId);
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "根据用户ID查询已下单配单信息",notes = "根据用户ID查询已下单配单信息",httpMethod = "GET")
    @GetMapping("/getWithOrderByYxd")
    public JTLJSONResult getWithOrderByYxd(@RequestParam Integer userId){
        //判断ID是否为空
        if(userId == null){
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        List<WithOrder> list = withOrderService.getWithOrderByYxd(userId);
        return JTLJSONResult.ok(list);
    }

    @ApiOperation(value = "根据用户ID查询待送达配单信息",notes = "根据用户ID查询待送达配单信息",httpMethod = "GET")
    @GetMapping("/getWithOrderByDsd")
    public JTLJSONResult getWithOrderByDsd(@RequestParam Integer userId){
        //判断ID是否为空
        if(userId == null){
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        List<WithOrder> list = withOrderService.getWithOrderByDsd(userId);
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "根据用户ID查询已送达配单信息",notes = "根据用户ID查询待已达配单信息",httpMethod = "GET")
    @GetMapping("/getWithOrderByYsd")
    public JTLJSONResult getWithOrderByYsd(@RequestParam Integer userId){
        //判断ID是否为空
        if(userId == null){
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        List<WithOrder> list = withOrderService.getWithOrderByYsd(userId);
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "查询骑手配单信息",notes = "查询骑手配单信息",httpMethod = "GET")
    @GetMapping("/getRiderWithOrderAll")
    public JTLJSONResult getRiderWithOrderAll(@RequestParam Integer riderId){
        //判断ID是否为空
        if(riderId == null){
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        List<WithOrder> list = withOrderService.getRiderWithOrderAll(riderId);
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "查询骑手配单信息---待接单",notes = "查询骑手配单信息---待接单",httpMethod = "GET")
    @GetMapping("/getRiderWithOrderByDjd")
    public JTLJSONResult getRiderWithOrderByDjd(@RequestParam Integer riderId){
        //判断ID是否为空
        if(riderId == null){
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        List<WithOrder> list = withOrderService.getRiderWithOrderByDjd(riderId);
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "查询骑手配单信息---已接单",notes = "查询骑手配单信息---已接单",httpMethod = "GET")
    @GetMapping("/getRiderWithOrderByYjd")
    public JTLJSONResult getRiderWithOrderByYjd(@RequestParam Integer riderId){
        //判断ID是否为空
        if(riderId == null){
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        List<WithOrder> list = withOrderService.getRiderWithOrderByYjd(riderId);
        return JTLJSONResult.ok(list);
    }

    @ApiOperation(value = "查询骑手配单信息---已完成",notes = "查询骑手配单信息---已完成",httpMethod = "GET")
    @GetMapping("/getRiderWithOrderByYwc")
    public JTLJSONResult getRiderWithOrderByYwc(@RequestParam Integer riderId){
        //判断ID是否为空
        if(riderId == null){
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        List<WithOrder> list = withOrderService.getRiderWithOrderByDjd(riderId);
        return JTLJSONResult.ok(list);
    }










}
