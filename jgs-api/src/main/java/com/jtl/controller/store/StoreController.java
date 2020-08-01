package com.jtl.controller.store;

import com.jtl.bo.StoreBO;
import com.jtl.bo.UsersBO;
import com.jtl.pojo.Store;
import com.jtl.service.StoreService;
import com.jtl.utils.JTLJSONResult;
import com.jtl.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

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


    @ApiOperation(value = "根据商家ID信息",notes = "根据商家ID信息",httpMethod = "GET")
    @GetMapping("/queryStoreView")
    public JTLJSONResult queryStoreView(@RequestParam Integer storeId){
        if(storeId == null){
            JTLJSONResult.errorMsg("商家ID为空");
        }
        Store store = storeService.queryAllView(storeId);
        return JTLJSONResult.ok(store);
    }

    @ApiOperation(value = "商家注册",notes = "商家注册",httpMethod = "POST")
    @PostMapping("regist")
    public JTLJSONResult regist(@RequestBody StoreBO storeBO){
        String username = storeBO.getUsername();
        String password = storeBO.getPassword();
        String confirmPassword = storeBO.getConfirmPassword();

        //0.判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPassword) ){
            return JTLJSONResult.errorMsg("用户或密码不能为空");
        }
        //1.查询用户名是否存在
        boolean isExist = storeService.queryStorenameIsExist(username);
        if (isExist){
            return JTLJSONResult.errorMsg("用户名已经存在");
        }

        //2.密码长度不能少于6为
        if (password.length() < 6){
            return JTLJSONResult.errorMsg("密码长度不能小于6");
        }

        //3.判断两次密码是否一致
        if (!password.equals(confirmPassword)){
            return JTLJSONResult.errorMsg("两次密码输入不一致");
        }
        //4.实现注册
        Store store = storeService.createStore(storeBO);
        return JTLJSONResult.ok(store);
    }


    @ApiOperation(value = "商家信息注册",notes = "商家信息注册",httpMethod = "POST")
    @PostMapping("update")
    public JTLJSONResult update(@RequestBody Store store){
        store.setUpdatedTime(new Date());
        storeService.update(store);
        Store a = storeService.queryAllView(store.getId());
        return JTLJSONResult.ok(a);
    }


}
