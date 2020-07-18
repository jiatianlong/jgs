package com.jtl.controller.store;

import com.jtl.pojo.StoreChartered;
import com.jtl.pojo.StoreShop;
import com.jtl.service.StoreCharteredService;
import com.jtl.service.StoreShopService;
import com.jtl.utils.JTLJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "商家营业执照信息",tags = {"关于商家营业执照信息的相关接口"})
@RestController
@RequestMapping("/storeChartered")
public class StoreCharteredController {

    @Autowired
    private StoreCharteredService storeCharteredService;

    @ApiOperation(value = "添加商家营业执照信息",notes = "添加商家营业执照信息",httpMethod = "POST")
    @PostMapping("addStoreChartered")
    public JTLJSONResult addStoreChartered(@RequestBody StoreChartered storeChartered){
        storeCharteredService.createStoreChartered(storeChartered);
        return JTLJSONResult.ok(storeChartered);
    }


    @ApiOperation(value = "查询商家营业执照信息",notes = "查询商家营业执照信息",httpMethod = "POST")
    @PostMapping("queryStoreCharteredViewByKey")
    public JTLJSONResult queryStoreCharteredViewByKey(@RequestParam String storeId){
        StoreChartered storeChartered = storeCharteredService.queryStoreCharteredView(Integer.valueOf(storeId));
        return JTLJSONResult.ok(storeChartered);
    }








}
