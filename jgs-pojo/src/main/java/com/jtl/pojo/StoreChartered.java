package com.jtl.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "store_chartered")
public class StoreChartered {
    @Id
    private Integer id;

    /**
     * 商家ID
     */
    @Column(name = "store_id")
    private Integer storeId;

    /**
     * 证件照片(营业执照)
     */
    @Column(name = "business_license")
    private String businessLicense;

    /**
     * 统一社会代码
     */
    @Column(name = "credit_card")
    private String creditCard;

    /**
     * 名称(营业执照名称)
     */
    private String name;

    /**
     * 法人代表
     */
    private String representative;

    /**
     * 经营场所
     */
    private String premises;

    /**
     * 执照有效期
     */
    @Column(name = "license_time")
    private String licenseTime;

    /**
     * 注册/成立时间
     */
    @Column(name = "reg_time")
    private String regTime;

    /**
     * 发证机关
     */
    @Column(name = "org_office")
    private String orgOffice;

    /**
     * 核准机关
     */
    private String approval;

    /**
     * 经营范围
     */
    private String management;

    /**
     * 注册资本
     */
    @Column(name = "erg_capital")
    private String ergCapital;

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
     * 获取证件照片(营业执照)
     *
     * @return business_license - 证件照片(营业执照)
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 设置证件照片(营业执照)
     *
     * @param businessLicense 证件照片(营业执照)
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    /**
     * 获取统一社会代码
     *
     * @return credit_card - 统一社会代码
     */
    public String getCreditCard() {
        return creditCard;
    }

    /**
     * 设置统一社会代码
     *
     * @param creditCard 统一社会代码
     */
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * 获取名称(营业执照名称)
     *
     * @return name - 名称(营业执照名称)
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称(营业执照名称)
     *
     * @param name 名称(营业执照名称)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取法人代表
     *
     * @return representative - 法人代表
     */
    public String getRepresentative() {
        return representative;
    }

    /**
     * 设置法人代表
     *
     * @param representative 法人代表
     */
    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    /**
     * 获取经营场所
     *
     * @return premises - 经营场所
     */
    public String getPremises() {
        return premises;
    }

    /**
     * 设置经营场所
     *
     * @param premises 经营场所
     */
    public void setPremises(String premises) {
        this.premises = premises;
    }

    /**
     * 获取执照有效期
     *
     * @return license_time - 执照有效期
     */
    public String getLicenseTime() {
        return licenseTime;
    }

    /**
     * 设置执照有效期
     *
     * @param licenseTime 执照有效期
     */
    public void setLicenseTime(String licenseTime) {
        this.licenseTime = licenseTime;
    }

    /**
     * 获取注册/成立时间
     *
     * @return reg_time - 注册/成立时间
     */
    public String getRegTime() {
        return regTime;
    }

    /**
     * 设置注册/成立时间
     *
     * @param regTime 注册/成立时间
     */
    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    /**
     * 获取发证机关
     *
     * @return org_office - 发证机关
     */
    public String getOrgOffice() {
        return orgOffice;
    }

    /**
     * 设置发证机关
     *
     * @param orgOffice 发证机关
     */
    public void setOrgOffice(String orgOffice) {
        this.orgOffice = orgOffice;
    }

    /**
     * 获取核准机关
     *
     * @return approval - 核准机关
     */
    public String getApproval() {
        return approval;
    }

    /**
     * 设置核准机关
     *
     * @param approval 核准机关
     */
    public void setApproval(String approval) {
        this.approval = approval;
    }

    /**
     * 获取经营范围
     *
     * @return management - 经营范围
     */
    public String getManagement() {
        return management;
    }

    /**
     * 设置经营范围
     *
     * @param management 经营范围
     */
    public void setManagement(String management) {
        this.management = management;
    }

    /**
     * 获取注册资本
     *
     * @return erg_capital - 注册资本
     */
    public String getErgCapital() {
        return ergCapital;
    }

    /**
     * 设置注册资本
     *
     * @param ergCapital 注册资本
     */
    public void setErgCapital(String ergCapital) {
        this.ergCapital = ergCapital;
    }
}