package com.jtl.bo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class CategoryBO {

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称",name = "name",example = "1",required = true)
    private String name;

    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID",name = "fatherId",example = "1",required = false)
    @Column(name = "father_id")
    private Integer fatherId;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标",name = "logo",example = "1",required = false)
    private String logo;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注",name = "note",example = "1",required = false)
    private String note;


    /**
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父ID
     *
     * @return father_id - 父ID
     */
    public Integer getFatherId() {
        return fatherId;
    }

    /**
     * 设置父ID
     *
     * @param fatherId 父ID
     */
    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    /**
     * 获取图标
     *
     * @return logo - 图标
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置图标
     *
     * @param logo 图标
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

}