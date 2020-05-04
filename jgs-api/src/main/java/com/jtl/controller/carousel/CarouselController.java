package com.jtl.controller.carousel;

import com.jtl.enums.YesOrNo;
import com.jtl.pojo.Carousel;
import com.jtl.service.CarouselService;
import com.jtl.utils.CookieUtils;
import com.jtl.utils.JTLJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 轮播图
 */
@Api(value = "轮播图",tags = {"用于app轮播图的相关接口"})
@RestController
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "获取app展示所有轮播图片",notes = "获取app展示所有轮播图片",httpMethod = "GET")
    @GetMapping("/carousel")
    public JTLJSONResult carousel(){
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        return JTLJSONResult.ok(list);
    }



}
