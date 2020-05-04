package com.jtl.mapper;

import com.jtl.my.mapper.MyMapper;
import com.jtl.pojo.ZgArea;
import com.jtl.vo.ZgAreaVo;

import java.util.List;

/**
 * 自定义的分类mapper
 */
public interface ZgAreaMapperCustom  {

    public List<ZgAreaVo> getZgAreaList(Integer rootId);


}