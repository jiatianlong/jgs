package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "store_shop")
public class StoreShop {
    @Id
    private Integer id;

    /**
     * 商家ID
     */
    @Column(name = "store_id")
    private Integer storeId;

    /**
     * 经营种类
     */
    private String type;

    /**
     * 店铺地址
     */
    private String address;

    /**
     * 详细地址
     */
    private String detailedadd;

    /**
     * logo
     */
    @Column(name = "logo_face")
    private String logoFace;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 店铺环境图
     */
    private String evface;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 电话
     */
    private String phone;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private String createdTime;

    /**
     * 更改信息
     */
    @Column(name = "updated_time")
    private String updatedTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商家ID
     *
     * @return store_id - 商家ID
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * 设置商家ID
     *
     * @param storeId 商家ID
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取经营种类
     *
     * @return type - 经营种类
     */
    public String getType() {
        return type;
    }

    /**
     * 设置经营种类
     *
     * @param type 经营种类
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取店铺地址
     *
     * @return address - 店铺地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置店铺地址
     *
     * @param address 店铺地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取详细地址
     *
     * @return detailedadd - 详细地址
     */
    public String getDetailedadd() {
        return detailedadd;
    }

    /**
     * 设置详细地址
     *
     * @param detailedadd 详细地址
     */
    public void setDetailedadd(String detailedadd) {
        this.detailedadd = detailedadd;
    }

    /**
     * 获取logo
     *
     * @return logo_face - logo
     */
    public String getLogoFace() {
        return logoFace;
    }

    /**
     * 设置logo
     *
     * @param logoFace logo
     */
    public void setLogoFace(String logoFace) {
        this.logoFace = logoFace;
    }

    /**
     * 获取店铺名称
     *
     * @return name - 店铺名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置店铺名称
     *
     * @param name 店铺名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取店铺环境图
     *
     * @return evface - 店铺环境图
     */
    public String getEvface() {
        return evface;
    }

    /**
     * 设置店铺环境图
     *
     * @param evface 店铺环境图
     */
    public void setEvface(String evface) {
        this.evface = evface;
    }

    /**
     * 获取联系人
     *
     * @return contacts - 联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置联系人
     *
     * @param contacts 联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更改信息
     *
     * @return updated_time - 更改信息
     */
    public String getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更改信息
     *
     * @param updatedTime 更改信息
     */
    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}