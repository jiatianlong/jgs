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


    /**
     * 搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult secrchItems(String keywords,
                                       String sort,
                                       Integer page,
                                       Integer pageSize);
    /**
     * 根据二级分类ID搜索商品列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult secrchItemsByTwoCat(Integer catId,
                                       String sort,
                                       Integer page,
                                       Integer pageSize);


}
