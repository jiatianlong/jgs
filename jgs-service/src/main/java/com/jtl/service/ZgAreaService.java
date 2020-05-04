package com.jtl.service;

import com.jtl.pojo.ZgArea;
import com.jtl.vo.ZgAreaVo;

import java.util.List;

public interface ZgAreaService {

    /**
     * 查询所有一级分类
     * @return
     */
    List<ZgArea> queryAllRootLevelArea();

    /**
     * 根据一级分类ID查询子分类信息
     * @param rootId
     * @return
     */
    List<ZgAreaVo> getZgAreaList(Integer rootId);





}
