package com.jtl.bo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class CenterUsersBO {

    @ApiModelProperty(value = "用户ID",name = "id",example = "1",required = true)
    @Id
    private String id;

    /**
     * 昵称 昵称
     */
    @ApiModelProperty(value = "昵称",name = "nickname",example = "jtl",required = false)
    private String nickname;


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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
