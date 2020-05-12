package com.jtl.controller.store;

import com.jtl.bo.UsersBO;
import com.jtl.pojo.Store;
import com.jtl.pojo.Users;
import com.jtl.service.StoreService;
import com.jtl.utils.CookieUtils;
import com.jtl.utils.JTLJSONResult;
import com.jtl.utils.JsonUtils;
import com.jtl.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "商家信息",tags = {"关于商家信息的相关接口"})
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @ApiOperation(value = "商家登录",notes = "商家登录",httpMethod = "POST")
    @PostMapping("login")
    public JTLJSONResult login(@RequestBody UsersBO usersBO
            , HttpServletRequest request, HttpServletResponse response) throws Exception{
        String username = usersBO.getUsername();
        String password = usersBO.getPassword();

        //0.判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ){
            return JTLJSONResult.errorMsg("用户或密码不能为空");
        }
        //1.实现登录
        Store stores = storeService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        if(stores == null){
            return JTLJSONResult.errorMsg("用户或密码不正确");
        }

        //TODO 生成用户token，存入redis会话
        //TODO 用户购物车更新
        return JTLJSONResult.ok(stores);
    }


}
