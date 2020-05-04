package com.jtl.controller.items;

import com.jtl.controller.BaseController;
import com.jtl.enums.YesOrNo;
import com.jtl.pojo.*;
import com.jtl.service.CarouselService;
import com.jtl.service.ItemsService;
import com.jtl.utils.JTLJSONResult;
import com.jtl.utils.PagedGridResult;
import com.jtl.vo.CommentLevelCountsVo;
import com.jtl.vo.ItemsInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品信息
 */
@Api(value = "商品信息接口",tags = {"用于商品信息展示的相关接口"})
@RestController
@RequestMapping("/items")
public class ItemsController extends BaseController {

    @Autowired
    private ItemsService itemsService;

    @ApiOperation(value = "查询商品详情",notes = "查询商品详情",httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public JTLJSONResult info(
            @ApiParam(name = "itemId",value = "商品ID",required = true)
            //路径参数
            @PathVariable Integer itemId){
        if (itemId == null){
            return JTLJSONResult.errorMsg("商品ID为空");
        }

        Items items = itemsService.queryItemById(itemId);
        List<ItemsImg> itemsImgList = itemsService.queryItemImgList(itemId);
        List<ItemsSpec> itemsSpecList = itemsService.queryItemSpecList(itemId);
        ItemsParam itemsParam =  itemsService.queryItemParamList(itemId);

        ItemsInfoVo itemsInfoVo = new ItemsInfoVo();
            itemsInfoVo.setItems(items);
            itemsInfoVo.setItemsImgList(itemsImgList);
            itemsInfoVo.setItemsSpecList(itemsSpecList);
            itemsInfoVo.setItemsParam(itemsParam);
        return JTLJSONResult.ok(itemsInfoVo);
    }


    /**
     * 查询商品的商品评级等级有几条，好评中评差评分别有几条
     * @param itemId
     * @return
     */
    @ApiOperation(value = "查询商品评价等级",notes = "查询商品评价等级",httpMethod = "GET")
    @GetMapping("/commentLevel")
    public JTLJSONResult commentLevel(
            @ApiParam(name = "itemId",value = "商品ID",required = true)
            //因为是请求参数
            @RequestParam Integer itemId){
        if (itemId == null){
            return JTLJSONResult.errorMsg("商品ID为空");
        }
        CommentLevelCountsVo countsVo = itemsService.queryCommentCounts(itemId);
        return JTLJSONResult.ok(countsVo);
    }


    /**
     * 根据商品ID查询商品的评价(分页)
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询商品评论",notes = "查询商品评论",httpMethod = "GET")
    @GetMapping("/comments")
    public JTLJSONResult comments(
            //因为是请求参数,所以使用RequestParam
            @ApiParam(name = "itemId",value = "商品ID",required = true) @RequestParam Integer itemId,
            @ApiParam(name = "level",value = "评价等级",required = false) @RequestParam Integer level,
            @ApiParam(name = "page",value = "查询下一页的第几页",required = false) @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "分页的每一页显示的条数",required = false) @RequestParam Integer pageSize){
        if (itemId == null){
            return JTLJSONResult.errorMsg("商品ID为空");
        }
        if(page == null){
            page = 1;
        }
        if(pageSize == null){
            pageSize = COMENT_PAGE_SIZE;
        }
        PagedGridResult gridResult =
                itemsService.queryPagedComments(itemId,level,page,pageSize);
        return JTLJSONResult.ok(gridResult);
    }





}
