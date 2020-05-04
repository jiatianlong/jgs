package com.jtl.mapper;

import com.jtl.my.mapper.MyMapper;
import com.jtl.pojo.Category;
import com.jtl.vo.NewItemsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom {
    /**
     * 查询首页每个一级分类下的6条最新商品数据
     * @param map
     * @return
     * 作为参数所传进去的MAP
     */
    public List<NewItemsVo> getSixNewItemsLazy(@Param("paramsMap") Map<String,Object> map);

}