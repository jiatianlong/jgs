package com.jtl.vo;

import com.jtl.pojo.ZgArea;

import java.util.List;

/**
 * 二级分类vo
 */
public class ZgAreaVo {

    Integer id;
    String name;
    Integer pId;
    /**
     * 三级分类VO list
     */
    private List<ZgAreaGoryVo> zgGoryList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public List<ZgAreaGoryVo> getZgGoryList() {
        return zgGoryList;
    }

    public void setZgGoryList(List<ZgAreaGoryVo> zgGoryList) {
        this.zgGoryList = zgGoryList;
    }
}
