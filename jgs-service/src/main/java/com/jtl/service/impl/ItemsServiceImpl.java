package com.jtl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jtl.bo.ItemsBO;
import com.jtl.bo.ItemsOrSpecOrImgBO;
import com.jtl.enums.CommentLevel;
import com.jtl.enums.YesOrNo;
import com.jtl.mapper.*;
import com.jtl.pojo.*;
import com.jtl.service.ItemsService;
import com.jtl.utils.DesensitizationUtil;
import com.jtl.utils.PagedGridResult;
import com.jtl.vo.CommentLevelCountsVo;
import com.jtl.vo.ItemCommentVo;
import com.jtl.vo.SearchItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private ItemsImgMapper itemsImgMapper;

    @Autowired
    private ItemsSpecMapper itemsSpecMapper;

    @Autowired
    private ItemsParamMapper itemsParamMapper;

    @Autowired
    private ItemsCommentsMapper itemsCommentsMapper;

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;
    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Items queryItemById(Integer itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }


    /**
     * 根据商品ID查询商品图片列表
     * @param itemId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsImg> queryItemImgList(Integer itemId) {
        Example itemsImgExp = new Example(ItemsImg.class);
        Example.Criteria criteria = itemsImgExp.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsImgMapper.selectByExample(itemsImgExp);
    }

    /**
     * 根据商品ID查询商品规格
     * @param itemId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsSpec> queryItemSpecList(Integer itemId) {
        Example itemsSpecExp = new Example(ItemsSpec.class);
        Example.Criteria criteria = itemsSpecExp.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsSpecMapper.selectByExample(itemsSpecExp);
    }

    /**
     * 根据商品ID查询商品参数
     * @param itemId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsParam queryItemParamList(Integer itemId) {

        Example itemsParamExp = new Example(ItemsParam.class);
        Example.Criteria criteria = itemsParamExp.createCriteria();
        criteria.andEqualTo("itemId",itemId);

        return itemsParamMapper.selectOneByExample(itemsParamExp);
    }


    /**
     * 根据商品ID查询商品的评价等级数量
     * @param itemId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CommentLevelCountsVo queryCommentCounts(Integer itemId) {

        //Integer totalCounts = getCommentCounts()

        Integer goodCounts = getCommentCounts(itemId, CommentLevel.GOOD.type);
        Integer normalCounts = getCommentCounts(itemId, CommentLevel.NORMAL.type);
        Integer badCounts = getCommentCounts(itemId, CommentLevel.BAD.type);
        Integer totalCounts = goodCounts + normalCounts + badCounts;

        CommentLevelCountsVo countsVo = new CommentLevelCountsVo();
        countsVo.setTotalCounts(totalCounts);
        countsVo.setGoodCounts(goodCounts);
        countsVo.setNormalCounts(normalCounts);
        countsVo.setBadCounts(badCounts);
        return countsVo;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    Integer getCommentCounts(Integer itemId,Integer level){
        ItemsComments condition = new ItemsComments();
        condition.setItemId(itemId);
        if(level != null){
            condition.setCommentLevel(level);
        }
        return itemsCommentsMapper.selectCount(condition);
    }

    /**
     * 根据商品ID查询商品的评价(分页)
     * @param itemId
     * @param level
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryPagedComments(Integer itemId,
                                                  Integer level,
                                                  Integer page,
                                                  Integer pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("itemId",itemId);
        map.put("level",level);
        //mybatis-pagehelper
        /**
         * page:第几页
         * pageSize:每页显示条数
         */
        PageHelper.startPage(page,pageSize);
        List<ItemCommentVo> list = itemsMapperCustom.queryItemComments(map);
        //进行匿名加工
        for(ItemCommentVo vo:list){
            vo.setNickName(DesensitizationUtil.commonDisplay(vo.getNickName()));
        }


        return setterPagedGrid(list,page);
    }



    private PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }

    /**
     * 搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult secrchItems(String keywords, String sort,
                                       Integer page, Integer pageSize) {
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("keywords",keywords);
        paramsMap.put("sort",sort);
        PageHelper.startPage(page,pageSize);
        List<SearchItemsVo> list =itemsMapperCustom.secrchItems(paramsMap);
        return setterPagedGrid(list,page);
    }


    /**
     * 根据二级分类ID搜索商品列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult secrchItemsByTwoCat(Integer catId, String sort, Integer page, Integer pageSize) {
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("catId",catId);
        paramsMap.put("sort",sort);
        PageHelper.startPage(page,pageSize);
        List<SearchItemsVo> list =itemsMapperCustom.secrchItems(paramsMap);
        return setterPagedGrid(list,page);
    }

    /**
     * 根据商品规格ID获取规格对象具体信息
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsSpec queryItemSpecById(Integer id) {
        return itemsSpecMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public String queryItemMainImgById(Integer id) {
        ItemsImg itemsImg = new ItemsImg();
        itemsImg.setItemId(id);
        itemsImg.setIsMain(YesOrNo.YES.type);
        ItemsImg result =itemsImgMapper.selectOne(itemsImg);
        return result != null ? result.getUrl() : "";
    }

    /**
     * 减少库存
     * @param specId
     * @param buyCounts
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void decreaseItemSpecStock(String specId, int buyCounts) {

        // synchronized 不推荐使用，集群下无用，性能低下
        // 锁数据库: 不推荐，导致数据库性能低下
        // 分布式锁 zookeeper redis

        // lockUtil.getLock(); -- 加锁

        // 1. 查询库存
//        int stock = 10;

        // 2. 判断库存，是否能够减少到0以下
//        if (stock - buyCounts < 0) {
        // 提示用户库存不够
//            10 - 3 -3 - 5 = -1
//        }

        // lockUtil.unLock(); -- 解锁


        int result = itemsMapperCustom.decreaseItemSpecStock(specId, buyCounts);
        if (result != 1) {
            throw new RuntimeException("订单创建失败，原因：库存不足!");
        }
    }

    /**
     * 查询所有商品,显示的时候默认显示规格第一个
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsOrSpecOrImgBO> qreryAllList() {
        Example example = new Example(Items.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("onOffStatus",1);
        List<Items> list = itemsMapper.selectByExample(example);

        List<ItemsOrSpecOrImgBO> items = new ArrayList<>();


        Integer id;
        String itemName;
        //商品内容
        String itemContent;
        //销量
        String sellCounts;
        //商品优惠价格
        double priceDiscount;
        //图片地址
        String url;

        for (int i = 0;i<list.size();i++){
            id = list.get(i).getId();
            itemName = list.get(i).getItemName();
            itemContent = list.get(i).getContent();
            sellCounts = list.get(i).getSellCounts();
            List<ItemsSpec> specs = this.queryItemSpecList(id);
            priceDiscount = specs.get(0).getPriceDiscount();
            url = specs.get(0).getUrl();
            items.add(new ItemsOrSpecOrImgBO(id,itemName,itemContent,sellCounts,priceDiscount,url));
        }
        return items;
    }

    /**
     * 根据商家ID查询商品
     * @param storeId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsOrSpecOrImgBO> queryItemsByStore(Integer storeId) {

        Example example = new Example(Items.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("storeShopId",storeId);
        criteria.andEqualTo("onOffStatus",1);
        //查询商家所拥有的上架的商品
        List<Items> list = itemsMapper.selectByExample(example);

        List<ItemsOrSpecOrImgBO> items = new ArrayList<>();

        //商品ID
        Integer id;
        //商品名称
        String itemName;
        //商品内容
        String itemContent;
        //销量
        String sellCounts;
        //商品优惠价格
        double priceDiscount;
        //图片地址
        String url;

        for (int i = 0;i<list.size();i++){
            id = list.get(i).getId();
            itemName = list.get(i).getItemName();
            itemContent = list.get(i).getContent();
            sellCounts = list.get(i).getSellCounts();
            List<ItemsSpec> specs = this.queryItemSpecList(id);
            priceDiscount = specs.get(0).getPriceDiscount();
            url = specs.get(0).getUrl();
            items.add(new ItemsOrSpecOrImgBO(id,itemName,itemContent,sellCounts,priceDiscount,url));
        }

        return items;
    }


    /**
     * 添加商品
     * @param itemsBO
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addNewItems(ItemsBO itemsBO) {

        //商品信息表添加信息
        Items items = new Items();
        items.setStoreShopId(itemsBO.getStoreId());
        items.setItemName(itemsBO.getItemName());
        items.setBrand(itemsBO.getBrand());
        items.setCatId(Integer.valueOf(itemsBO.getCatId()));
        items.setSellCounts("1");
        items.setOnOffStatus(itemsBO.getOnOffStatus());
        items.setContent(itemsBO.getContent());
        items.setCreatedTime(new Date());

        itemsMapper.insertUseGeneratedKeys(items);

        //商品Id
        int itemsId = items.getId();

        //商品规格表添加信息
        ItemsSpec itemsSpec = new ItemsSpec();
        itemsSpec.setItemId(itemsId);
        itemsSpec.setName(itemsBO.getItemName());
        itemsSpec.setStock(Integer.valueOf(itemsBO.getItemskc()));
        //优惠价
        itemsSpec.setPriceDiscount(itemsBO.getItemsPrice());
        //原价
        itemsSpec.setPriceNormal(itemsBO.getItemsPrice());
        itemsSpec.setUrl(itemsBO.getItemImgPath());
        itemsSpec.setCreatedTime(new Date());
        itemsSpecMapper.insert(itemsSpec);

        //商品图片表添加信息
        ItemsImg itemsImg = new ItemsImg();
        itemsImg.setItemId(itemsId);
        itemsImg.setUrl(itemsBO.getItemImgPath());
        itemsImg.setSort(1);
        itemsImg.setIsMain(1);
        itemsImg.setCreatedTime(new Date());
        itemsImgMapper.insert(itemsImg);
    }


}
