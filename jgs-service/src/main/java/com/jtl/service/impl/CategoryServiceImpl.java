package com.jtl.service.impl;

import com.jtl.mapper.CategoryMapper;
import com.jtl.mapper.CategoryMapperCustom;
import com.jtl.pojo.Category;
import com.jtl.service.CategoryService;
import com.jtl.vo.NewItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 查询一级分类下的6条最新商品数据
     * @param rootId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<NewItemsVo> getSixNewItemsLazy(Integer rootId) {
        Map<String,Object> map  = new HashMap<>();
        map.put("rootId",rootId);
        return categoryMapperCustom.getSixNewItemsLazy(map);
    }

    /**
     * 获取所有商品分类
     * @return
     */
    @Override
    public List<Category> queryAll() {
        return categoryMapper.selectAll();
    }

}
