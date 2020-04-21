package com.jtl.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户对象BO",description = "从客户端，用户传入的数据封装在此的entity中")
public class UsersBO {

    @ApiModelProperty(value = "用户名",name = "username",example = "jtl",required = true)
    private String username;

    @ApiModelProperty(value = "密码",name = "password",example = "123456",required = true)
    private String password;

    @ApiModelProperty(value = "确认密码",name = "password",example = "123456",required = true)
    private String cpmfirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpmfirmPassword() {
        return cpmfirmPassword;
    }

    public void setCpmfirmPassword(String cpmfirmPassword) {
        this.cpmfirmPassword = cpmfirmPassword;
    }
}
