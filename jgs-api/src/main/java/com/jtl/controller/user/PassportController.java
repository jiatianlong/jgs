package com.jtl.controller.user;


import com.jtl.bo.UsersBO;
import com.jtl.pojo.Users;
import com.jtl.service.UserService;
import com.jtl.utils.JTLJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "注册登录",tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("/passport")
public class PassportController {


    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在",notes = "用户名是否存在",httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public JTLJSONResult usernameIsExist(@RequestParam String username){

        //判断用户名是否为空
        if(StringUtils.isBlank(username)){
           return JTLJSONResult.errorMsg("用户名不能为空");
        }
        //查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist){
            return JTLJSONResult.errorMsg("用户名已经存在");
        }
        //请求成功，用户名没有重复
        return JTLJSONResult.ok();
    }


    @ApiOperation(value = "用户注册",notes = "用户注册",httpMethod = "POST")
    @PostMapping("regist")
    public JTLJSONResult regist(@RequestBody UsersBO usersBO){
        String username = usersBO.getUsername();
        String password = usersBO.getPassword();
        String confirmPwd = usersBO.getCpmfirmPassword();

        //0.判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd) ){
            return JTLJSONResult.errorMsg("用户或密码不能为空");
        }
        //1.查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist){
            return JTLJSONResult.errorMsg("用户名已经存在");
        }

        //2.密码长度不能少于6为
        if (password.length() < 6){
            return JTLJSONResult.errorMsg("密码长度不能小于6");
        }

        //3.判断两次密码是否一致
        if (!password.equals(confirmPwd)){
            return JTLJSONResult.errorMsg("两次密码输入不一致");
        }
        //4.实现注册
        Users users = userService.createUser(usersBO);
        return JTLJSONResult.ok(users);
    }

}
