package com.jtl.service;

import com.jtl.pojo.*;
import com.jtl.utils.PagedGridResult;
import com.jtl.vo.CommentLevelCountsVo;
import com.jtl.vo.ItemCommentVo;

import java.util.List;

/**
 * 商品
 */
public interface ItemsService {

    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
    public Items queryItemById(Integer itemId);


    /**
     * 根据商品ID查询商品图片列表
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(Integer itemId);


    /**
     * 根据商品ID查询商品规格
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(Integer itemId);


    /**
     * 根据商品ID查询商品参数
     * @param itemId
     * @return
     */
    public ItemsParam queryItemParamList(Integer itemId);


    /**
     * 根据商品ID查询商品的评价等级数量
     * @param itemId
     */
    public CommentLevelCountsVo queryCommentCounts(Integer itemId);

    /**
     * 根据商品ID查询商品的评价(分页)
     * @param itemId
     * @param level
     * @return
     */
    public PagedGridResult queryPagedComments(Integer itemId, Integer level, Integer page, Integer pageSize);



}
