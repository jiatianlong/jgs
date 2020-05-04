package com.jtl.service;

import com.jtl.pojo.Carousel;

import java.util.List;

public interface CarouselService {

    /**
     * 查询所有轮播图
     * @param isShow
     * @return
     */
    public List<Carousel> queryAll(Integer isShow);

}
