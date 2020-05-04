package com.jtl.controller.zgarea;

import com.jtl.pojo.ZgArea;
import com.jtl.service.ZgAreaService;
import com.jtl.utils.JTLJSONResult;
import com.jtl.vo.ZgAreaVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 省市县
 */
@Api(value = "省市县",tags = {"用于查询省市县的相关接口"})
@RestController
@RequestMapping("/zgarea")
public class ZgAreaController {

    @Autowired
    private ZgAreaService zgAreaService;

    @ApiOperation(value = "获取所有省份名称",notes = "获取所有省份名称",httpMethod = "GET")
    @GetMapping("/areaRoot")
    public JTLJSONResult areaRoot(){
        List<ZgArea> list = zgAreaService.queryAllRootLevelArea();
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "根据一级分类ID查询子分类",notes = "根据省份ID获取市区县",httpMethod = "GET")
    @GetMapping("/zgRoot/{rootId}")
    public JTLJSONResult zgRoot(
            @ApiParam(name = "rootId",value = "一级分类ID",required = true)
            @PathVariable Integer rootId){
        if(rootId == null){
            return JTLJSONResult.errorMsg("分类不存在");
        }
        List<ZgAreaVo> list = zgAreaService.getZgAreaList(rootId);
        return JTLJSONResult.ok(list);
    }





}
