package com.jtl.controller.store;
import com.jtl.pojo.StoreShop;
import com.jtl.service.StoreShopService;
import com.jtl.utils.JTLJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "商家店铺信息",tags = {"关于商家店铺信息的相关接口"})
@RestController
@RequestMapping("/storeshop")
public class StoreShopController {

    @Autowired
    private StoreShopService storeShopService;


    @ApiOperation(value = "添加商家店铺",notes = "添加商家店铺",httpMethod = "POST")
    @PostMapping("addStoreShop")
    public JTLJSONResult addStoreShop(@RequestBody StoreShop storeShop){
        //1.添加店铺
        storeShopService.createStoreShop(storeShop);
        return JTLJSONResult.ok(storeShop);
    }

    @ApiOperation(value = "查询商家店铺信息",notes = "查询商家店铺信息",httpMethod = "POST")
    @PostMapping("getStoreViewByKey")
    public JTLJSONResult getStoreViewByKey(@RequestParam Integer storeId){
        StoreShop storeShop = storeShopService.queryView(storeId);
        return JTLJSONResult.ok(storeShop);
    }

    @ApiOperation(value = "根据商家类型查询商家信息",notes = "根据商家类型查询商家信息",httpMethod = "POST")
    @PostMapping("getTypeView")
    public JTLJSONResult getTypeView(@RequestParam String type){
        List<StoreShop> list = storeShopService.querySjsView(type);
        return JTLJSONResult.ok(list);
    }















}
