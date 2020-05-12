package com.jtl.service;

import com.jtl.pojo.Category;
import com.jtl.vo.NewItemsVo;

import java.util.List;

/**
 * 商品分类
 */
public interface CategoryService  {

    /**
     * 查询首页每个一级分类下的6条最新商品数据
     * @param rootId
     * @return
     */
    public List<NewItemsVo> getSixNewItemsLazy(Integer rootId);


    /**
     * 获取所有的分类
     * @return
     */
    public List<Category> queryAll();

}
