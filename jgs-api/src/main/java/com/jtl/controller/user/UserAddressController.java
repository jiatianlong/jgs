package com.jtl.controller.user;

import com.jtl.bo.AddressBO;
import com.jtl.pojo.UserAddress;
import com.jtl.service.UserAddressService;
import com.jtl.utils.JTLJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(value = "用户收货地址相关",tags = {"用户收货地址相关的相关接口"})
@RestController
@RequestMapping("/address")
public class UserAddressController {

    /**
     * 用户在订单页面，可以针对收货地址做出如下操作
     * 1.查询用户所有的收获地址列表
     * 2.新增收货地址
     * 3.删除收货地址
     * 4.修改收货地址
     * 5.设置默认地址
     */


    @Autowired
    private UserAddressService userAddressService;

    @ApiOperation(value = "根据用户ID查询默认收货地址列表",notes = "根据用户ID查询默认收货地址列表",httpMethod = "POST")
    @PostMapping("/queryAllIsDefault")
    public JTLJSONResult queryAllIsDefault(@RequestParam Integer userId){
        if(userId == null){
            JTLJSONResult.errorMsg("用户ID为空");
        }
        List<UserAddress> list = userAddressService.queryAll(userId);
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "根据用户ID查询收货地址列表",notes = "根据用户ID查询收货地址列表",httpMethod = "POST")
    @PostMapping("/list")
    public JTLJSONResult usernameIsExist(@RequestParam Integer userId){
        if(userId == null){
            JTLJSONResult.errorMsg("用户ID为空");
        }
        List<UserAddress> list = userAddressService.queryAll(userId);
        return JTLJSONResult.ok(list);
    }


    @ApiOperation(value = "用户新增收货地址",notes = "用户新增收货地址",httpMethod = "POST")
    @PostMapping("/add")
    public JTLJSONResult add(@RequestBody AddressBO addressBO){
        //应该要一个字段一个字段判断是否为空
        if(addressBO == null){
            JTLJSONResult.errorMsg("数据为空");
        }
        userAddressService.addNewUserAddress(addressBO);
        return JTLJSONResult.ok();
    }


    @ApiOperation(value = "修改用户收货地址",notes = "修改用户收货地址",httpMethod = "POST")
    @PostMapping("/update")
    public JTLJSONResult update(@RequestBody AddressBO addressBO){
        if(addressBO.getId() == null){
            JTLJSONResult.errorMsg("地址ID为空");
        }
        //应该要一个字段一个字段判断是否为空
        if(addressBO == null){
            JTLJSONResult.errorMsg("数据为空");
        }
        userAddressService.updateUserAddress(addressBO);
        return JTLJSONResult.ok();
    }

    @ApiOperation(value = "删除用户收货地址",notes = "删除用户收货地址",httpMethod = "POST")
    @PostMapping("/delete")
    public JTLJSONResult delete(@RequestParam Integer id,@RequestParam Integer userId){

        if(id == null){
            return JTLJSONResult.errorMsg("地址ID为空");
        }
        if(userId == null){
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        userAddressService.deleteUserAddress(id,userId);
        return JTLJSONResult.ok();
    }

    @ApiOperation(value = "根据用户ID和收货地址ID设置默认收货地址",notes = "根据用户ID和收货地址ID设置默认收货地址",httpMethod = "POST")
    @PostMapping("/setDefalut")
    public JTLJSONResult setDefalut(@RequestParam Integer id,@RequestParam Integer userId){
        if(id == null){
            return JTLJSONResult.errorMsg("地址ID为空");
        }
        if(userId == null){
            return JTLJSONResult.errorMsg("用户ID为空");
        }
        userAddressService.updateUserAddressToBefault(id, userId);
        return JTLJSONResult.ok();
    }








}
