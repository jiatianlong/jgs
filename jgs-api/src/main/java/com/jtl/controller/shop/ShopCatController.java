package com.jtl.controller.shop;

import com.jtl.bo.ShopCartBO;
import com.jtl.utils.JTLJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "购物车接口controller", tags = {"购物车接口相关的api"})
@RequestMapping("shopCat")
@RestController
public class ShopCatController {



    @ApiOperation(value = "添加商品到购物车",notes = "添加商品到购物车",httpMethod = "POST")
    @PostMapping("/add")
    public JTLJSONResult add(
            @RequestBody ShopCartBO shopcartBO,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        if(shopcartBO.getUserId() == null){
            return  JTLJSONResult.errorMsg("用户ID为空");
        }
       System.out.println(shopcartBO.getUserId()+"````````````````````````"+shopcartBO);
        //TODO 前端用户在登录的情况下，添加商品到购物车，会同时在后端同步购物车到redis缓存
        return JTLJSONResult.ok(shopcartBO);
    }



    @ApiOperation(value = "从购物车中删除商品", notes = "从购物车中删除商品", httpMethod = "POST")
    @PostMapping("/del")
    public JTLJSONResult del(
            @RequestParam String userId,
            @RequestParam String itemSpecId,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)) {
            return JTLJSONResult.errorMsg("参数不能为空");
        }
        // TODO 用户在页面删除购物车中的商品数据，如果此时用户已经登录，则需要同步删除后端购物车中的商品
        return JTLJSONResult.ok();
    }

}
