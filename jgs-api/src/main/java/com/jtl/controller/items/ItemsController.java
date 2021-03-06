package com.jtl.controller.items;
import com.jtl.bo.ItemsBO;
import com.jtl.bo.ItemsOrSpecOrImgBO;
import com.jtl.controller.BaseController;
import com.jtl.pojo.*;
import com.jtl.service.ItemsService;
import com.jtl.utils.JTLJSONResult;
import com.jtl.utils.PagedGridResult;
import com.jtl.vo.CommentLevelCountsVo;
import com.jtl.vo.ItemsInfoVo;
import com.jtl.vo.SearchItemsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 商品信息
 */
@Api(value = "商品信息接口",tags = {"用于商品信息的相关接口"})
@RestController
@RequestMapping("/items")
public class ItemsController extends BaseController {

    @Autowired
    private ItemsService itemsService;



    @ApiOperation(value = "商家新增商品",notes = "商家新增商品",httpMethod = "POST")
    @PostMapping("/add")
    public JTLJSONResult add(@RequestBody ItemsBO itemsBO){
        //应该要一个字段一个字段判断是否为空
        if(itemsBO == null){
            JTLJSONResult.errorMsg("数据为空");
        }
        itemsService.addNewItems(itemsBO);
        return JTLJSONResult.ok();
    }

    @ApiOperation(value = "查询所有商品",notes = "查询所有商品,关联商品表和商品规格表",httpMethod = "GET")
    @GetMapping("/qreryAllList")
    public JTLJSONResult qreryAllList(){
        List<ItemsOrSpecOrImgBO> items = itemsService.qreryAllList();
        return JTLJSONResult.ok(items);
    }


    @ApiOperation(value = "根据商家ID查询商品",notes = "根据商家ID查询商品,关联商品表和商品规格表",httpMethod = "POST")
    @PostMapping("/qreryAllByStoreId")
    public JTLJSONResult qreryAllByStoreId(
            @ApiParam(name = "storeId",value = "商家ID",required = true)
            @RequestParam Integer storeId){
        List<ItemsOrSpecOrImgBO> items = itemsService.queryItemsByStore(storeId);
        return JTLJSONResult.ok(items);
    }


    @ApiOperation(value = "查询商品详情",notes = "查询商品详情",httpMethod = "GET")
    @GetMapping("/info")
    public JTLJSONResult info(
            @ApiParam(name = "itemId",value = "商品ID",required = true)
            //路径参数
            @RequestParam Integer itemId){
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


    @ApiOperation(value = "搜索商品列表",notes = "根据商品名称关键字(销量，价格)搜索商品列表",httpMethod = "GET")
    @GetMapping("/search")
    public JTLJSONResult search(
            //因为是请求参数,所以使用RequestParam
            @ApiParam(name = "keywords",value = "商品关键字",required = false) @RequestParam String keywords,
            @ApiParam(name = "sort",value = "排序,k:默认，代表默认排序,根据name,c:根据销量排序,p:根据价格排序",required = false) @RequestParam String sort,
            @ApiParam(name = "page",value = "查询下一页的第几页",required = false) @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "分页的每一页显示的条数",required = false) @RequestParam Integer pageSize){
/*
        if (keywords == null){
            return JTLJSONResult.errorMsg(null);
        }*/

        if(page == null){
            page = 1;
        }
        if(pageSize == null){
            pageSize = PAGE_SIZE;
        }
        PagedGridResult gridResult = itemsService.secrchItems(keywords,sort,page,pageSize);
        return JTLJSONResult.ok(gridResult);
    }


    @ApiOperation(value = "根据二级分类ID搜索商品列表",notes = "根据商品根据二级分类ID搜索关键字(销量，价格)搜索商品列表",httpMethod = "GET")
    @GetMapping("/searchByTwoCat")
    public JTLJSONResult searchByTwoCat(
            //因为是请求参数,所以使用RequestParam
            @ApiParam(name = "catId",value = "商品关键字",required = true) @RequestParam Integer catId,
            @ApiParam(name = "sort",value = "排序,k:默认，代表默认排序,根据name,c:根据销量排序,p:根据价格排序",required = false) @RequestParam String sort,
            @ApiParam(name = "page",value = "查询下一页的第几页",required = false) @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "分页的每一页显示的条数",required = false) @RequestParam Integer pageSize){
        if (catId == null){
            return JTLJSONResult.errorMsg("商品二级分类ID为空");
        }
        if(page == null){
            page = 1;
        }
        if(pageSize == null){
            pageSize = PAGE_SIZE;
        }
        PagedGridResult gridResult =
                itemsService.secrchItemsByTwoCat(catId,sort,page,pageSize);
        return JTLJSONResult.ok(gridResult);
    }


    /**
     * 根据商品ID查询商品规格，以及商家ID
     * @param itemId
     * @return
     */
    @ApiOperation(value = "根据商品ID查询商品规格",notes = "根据商品ID查询商品规格",httpMethod = "GET")
    @GetMapping("/queryItemsSpec")
    public JTLJSONResult queryItemsSpec(
            @ApiParam(name = "itemId",value = "商品ID",required = true)
            //因为是请求参数
            @RequestParam Integer itemId){
        if (itemId == null){
            return JTLJSONResult.errorMsg("商品ID为空");
        }
        List<ItemsSpec> list =itemsService.queryItemsSpec(itemId);
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "根据分类ID查询商品",notes = "根据商品ID查询商品",httpMethod = "GET")
    @GetMapping("/queryItemsByCatId")
    public JTLJSONResult queryItemsByCatId(
            @ApiParam(name = "catId",value = "catId",required = true)
            //因为是请求参数
            @RequestParam Integer catId){
        if (catId == null){
            return JTLJSONResult.errorMsg("分类ID为空");
        }
        List<SearchItemsVo> list =itemsService.secrchItemsByCatId(catId);
        return JTLJSONResult.ok(list);
    }



    @ApiOperation(value = "商家新增商品规格",notes = "商家新增商品规格",httpMethod = "POST")
    @PostMapping("/specAdd")
    public JTLJSONResult specAdd(@RequestBody ItemsSpec itemsSpec){
        //应该要一个字段一个字段判断是否为空
        if(itemsSpec == null){
            JTLJSONResult.errorMsg("数据为空");
        }
        itemsSpec.setCreatedTime(new Date());
        itemsSpec.setUpdatedTime(new Date());
        itemsService.addNewSpecItems(itemsSpec);
        return JTLJSONResult.ok();
    }

    @ApiOperation(value = "根据商品ID修改商品参数",notes = "根据商品ID修改商品参数",httpMethod = "POST")
    @PostMapping("/editItemParam")
    public JTLJSONResult editItemParam(@RequestBody ItemsParam itemsParam){
        //应该要一个字段一个字段判断是否为空
        if(itemsParam == null){
            JTLJSONResult.errorMsg("数据为空");
        }

        ItemsParam cs =  itemsService.queryItemParamList(itemsParam.getItemId());

        if (cs != null){
            itemsParam.setUpdatedTime(new Date());
            itemsService.editItemParam(itemsParam);
        }else {
            itemsParam.setExtend("无");
            itemsParam.setCreatedTime(new Date());
            itemsParam.setUpdatedTime(new Date());
            itemsService.addNewItemsParams(itemsParam);
        }

        return JTLJSONResult.ok();
    }




}
