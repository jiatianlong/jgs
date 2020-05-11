package com.jtl.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Users {
    /**
     * 主键id 用户id
     */
    @ApiModelProperty(value = "用户ID",name = "id",example = "1",required = true)
    @Id
    private String id;

    /**
     * 用户名 用户名
     */
    @ApiModelProperty(value = "用户名",name = "username",example = "jtl",required = false)
    private String username;

    /**
     * 密码 密码
     */
    @ApiModelProperty(value = "密码",name = "password",example = "123456",required = false)
    private String password;

    /**
     * 昵称 昵称
     */
    @ApiModelProperty(value = "昵称",name = "nickname",example = "jtl",required = false)
    private String nickname;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名",name = "realname",example = "jtl",required = false)
    private String realname;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像",name = "face",example = "图片地址",required = false)
    private String face;

    /**
     * 手机号 手机号
     */
    @ApiModelProperty(value = "手机号",name = "mobile",example = "13309470000",required = false)
    private String mobile;

    /**
     * 邮箱地址 邮箱地址
     */
    @ApiModelProperty(value = "邮箱地址",name = "email",example = "13309470000@163.com",required = false)
    private String email;

    /**
     * 性别 性别 1:男  0:女  2:保密
     */
    @ApiModelProperty(value = "邮箱地址",name = "sex",example = "1/2/0",required = false)
    private Integer sex;

    /**
     * 生日 生日
     */
    @ApiModelProperty(value = "生日",name = "birthday",example = "2020-01-01",required = false)
    private Date birthday;

    /**
     * 创建时间 创建时间
     */
    @ApiModelProperty(value = "创建时间",name = "createdTime",example = "2020-01-01",required = false)
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 更新时间 更新时间
     */
    @ApiModelProperty(value = "更新时间",name = "updatedTime",example = "2020-01-01",required = false)
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 获取主键id 用户id
     *
     * @return id - 主键id 用户id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id 用户id
     *
     * @param id 主键id 用户id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户名 用户名
     *
     * @return username - 用户名 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名 用户名
     *
     * @param username 用户名 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码 密码
     *
     * @return password - 密码 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码 密码
     *
     * @param password 密码 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称 昵称
     *
     * @return nickname - 昵称 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称 昵称
     *
     * @param nickname 昵称 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取真实姓名
     *
     * @return realname - 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实姓名
     *
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取头像
     *
     * @return face - 头像
     */
    public String getFace() {
        return face;
    }

    /**
     * 设置头像
     *
     * @param face 头像
     */
    public void setFace(String face) {
        this.face = face;
    }

    /**
     * 获取手机号 手机号
     *
     * @return mobile - 手机号 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号 手机号
     *
     * @param mobile 手机号 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取邮箱地址 邮箱地址
     *
     * @return email - 邮箱地址 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址 邮箱地址
     *
     * @param email 邮箱地址 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取性别 性别 1:男  0:女  2:保密
     *
     * @return sex - 性别 性别 1:男  0:女  2:保密
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别 性别 1:男  0:女  2:保密
     *
     * @param sex 性别 性别 1:男  0:女  2:保密
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取生日 生日
     *
     * @return birthday - 生日 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日 生日
     *
     * @param birthday 生日 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取创建时间 创建时间
     *
     * @return created_time - 创建时间 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间 创建时间
     *
     * @param createdTime 创建时间 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新时间 更新时间
     *
     * @return updated_time - 更新时间 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间 更新时间
     *
     * @param updatedTime 更新时间 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}