package com.jtl.vo;

import java.util.List;

/**
 * 最新商品vo
 */
public class NewItemsVo {

    private Integer rootId;
    private String rootName;
    private String rootNote;
    private String rootLogo;

    private List<SimpleItemVo> simpleItemVoList;

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getRootNote() {
        return rootNote;
    }

    public void setRootNote(String rootNote) {
        this.rootNote = rootNote;
    }

    public String getRootLogo() {
        return rootLogo;
    }

    public void setRootLogo(String rootLogo) {
        this.rootLogo = rootLogo;
    }

    public List<SimpleItemVo> getSimpleItemVoList() {
        return simpleItemVoList;
    }

    public void setSimpleItemVoList(List<SimpleItemVo> simpleItemVoList) {
        this.simpleItemVoList = simpleItemVoList;
    }
}
