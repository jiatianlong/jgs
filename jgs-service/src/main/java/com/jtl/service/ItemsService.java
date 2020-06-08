package com.jtl.service;

import com.jtl.bo.ItemsBO;
import com.jtl.bo.ItemsOrSpecOrImgBO;
import com.jtl.pojo.*;
import com.jtl.utils.PagedGridResult;
import com.jtl.vo.CommentLevelCountsVo;
import com.jtl.vo.ItemCommentVo;
import com.jtl.vo.SearchItemsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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


    /**
     * 根据商品规格ID获取规格对象具体信息
     * @return
     */
    public ItemsSpec queryItemSpecById(Integer id);

    /**
     * 根据商品ID获取商品主图url
     * @return
     */
    public String queryItemMainImgById(Integer id);

    /**
     * 减少库存
     * @param specId
     * @param buyCounts
     */
    public void decreaseItemSpecStock(String specId, int buyCounts);


    /**
     * 查询所有商品,显示的时候默认显示规格第一个
     * @return
     */
    public List<ItemsOrSpecOrImgBO> qreryAllList();


    /**
     * 根据商家ID查询商品
     * @return
     */
    public List<ItemsOrSpecOrImgBO> queryItemsByStore(Integer storeId);


    /**
     * 添加商品
     */
    public void addNewItems(ItemsBO itemsBO);



    /**
     * 根据商家ID查询商品规格
     * @return
     */
    public List<ItemsSpec> queryItemsSpec(Integer itemId);


    /**
     * 根据
     * @param catId
     * @return
     */
    public List<SearchItemsVo> secrchItemsByCatId(Integer catId);


    /**
     * 添加商品
     */
    public void addNewSpecItems(ItemsSpec itemsSpec);

    /**
     * 修改商品参数
     * @param itemsParam
     */
    public void editItemParam(ItemsParam itemsParam);

}
