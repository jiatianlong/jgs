package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "zg_area")
public class ZgArea {
    /**
     * 区域ID
     */
    @Id
    private Integer id;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 区域ID的父ID
     */
    @Column(name = "pId")
    private Integer pid;

    /**
     * 获取区域ID
     *
     * @return id - 区域ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置区域ID
     *
     * @param id 区域ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取区域名称
     *
     * @return name - 区域名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置区域名称
     *
     * @param name 区域名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取区域ID的父ID
     *
     * @return pId - 区域ID的父ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置区域ID的父ID
     *
     * @param pid 区域ID的父ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}