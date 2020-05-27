package com.jtl.mapper;

import com.jtl.pojo.ItemsComments;
import com.jtl.vo.ItemCommentVo;
import com.jtl.vo.SearchItemsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {


    public List<ItemCommentVo> queryItemComments(@Param("paramsMap") Map<String,Object> map);

    public List<SearchItemsVo> secrchItems(@Param("paramsMap") Map<String,Object> map);

    public List<SearchItemsVo> secrchItemsByTwoCat(@Param("paramsMap") Map<String,Object> map);

    public List<SearchItemsVo> secrchItemsByCatId(@Param("catId")Integer catId);

    public int decreaseItemSpecStock(@Param("specId") String specId,
                                     @Param("pendingCounts") int pendingCounts);



}