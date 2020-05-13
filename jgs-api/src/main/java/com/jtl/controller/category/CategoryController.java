package com.jtl.controller.category;

import com.jtl.bo.CategoryBO;
import com.jtl.enums.YesOrNo;
import com.jtl.pojo.Carousel;
import com.jtl.pojo.Category;
import com.jtl.service.CarouselService;
import com.jtl.service.CategoryService;
import com.jtl.utils.JTLJSONResult;
import com.jtl.vo.NewItemsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类
 */
@Api(value = "商品分类",tags = {"用于商品分类的相关接口"})
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;



    @ApiOperation(value = "查询一级分类下的6条最新商品数据",notes = "查询一级分类下的6条最新商品数据",httpMethod = "GET")
    @GetMapping("/SixNewItems/{rootId}")
    public JTLJSONResult SixNewItems(
            @ApiParam(name = "rootId",value = "一级分类ID",required = true)
            @PathVariable Integer rootId){
        if(rootId == null){
            return JTLJSONResult.errorMsg("分类不存在");
        }
        List<NewItemsVo> list = categoryService.getSixNewItemsLazy(rootId);
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "获取所有商品分类",notes = "获取所有商品分类",httpMethod = "GET")
    @GetMapping("/queryAll")
    public JTLJSONResult queryAll(){
        List<Category> list = categoryService.queryAll();
        return JTLJSONResult.ok(list);
    }

    @ApiOperation(value = "添加商品分类",notes = "添加商品分类",httpMethod = "POST")
    @PostMapping("/add")
    public JTLJSONResult add(@RequestBody CategoryBO CategoryBO){
        if (CategoryBO.getName() == null){
            JTLJSONResult.errorMsg("用户名不能为空");
        }
        categoryService.addNewCategory(CategoryBO);
        return JTLJSONResult.ok();
    }




    

}
