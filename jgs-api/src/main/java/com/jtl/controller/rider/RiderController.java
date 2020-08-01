package com.jtl.controller.rider;
import com.jtl.pojo.Rider;
import com.jtl.service.RiderService;
import com.jtl.utils.JTLJSONResult;
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

@Api(value = "骑手相关",tags = {"骑手相关的api接口"})
@RestController
@RequestMapping("/rider")
public class RiderController {

    @Autowired
    private RiderService riderService;

    @ApiOperation(value = "骑手注册",notes = "骑手注册",httpMethod = "POST")
    @PostMapping("regist")
    public JTLJSONResult regist(@RequestBody Rider rider) throws Exception {
        String riderName = rider.getRiderName();
        String password = rider.getPassword();
        //0.判断用户名和密码必须不为空
        if (StringUtils.isBlank(riderName) ||
                StringUtils.isBlank(password)  ){
            return JTLJSONResult.errorMsg("用户或密码不能为空");
        }
        //1.查询用户名是否存在
        boolean isExist = riderService.queryRiderNameIsExist(riderName);
        if (isExist){
            return JTLJSONResult.errorMsg("用户名已经存在");
        }
        //2.密码长度不能少于6为
        if (password.length() < 6){
            return JTLJSONResult.errorMsg("密码长度不能小于6");
        }
        //4.实现注册
        Rider r = riderService.createRider(rider);
        return JTLJSONResult.ok(r);
    }


    @ApiOperation(value = "骑手登录",notes = "骑手登录",httpMethod = "POST")
    @PostMapping("login")
    public JTLJSONResult login(@RequestBody Rider rider
            , HttpServletRequest request, HttpServletResponse response) throws Exception{
        String riderName = rider.getRiderName();
        String password = rider.getPassword();
        //0.判断用户名和密码必须不为空
        if (StringUtils.isBlank(riderName) ||
                StringUtils.isBlank(password) ){
            return JTLJSONResult.errorMsg("用户或密码不能为空");
        }
        //1.实现登录
        Rider r = riderService.queryRiderForLogin(riderName, MD5Utils.getMD5Str(password));
        if(r == null){
            return JTLJSONResult.errorMsg("用户或密码不正确");
        }
        //TODO 生成用户token，存入redis会话
        //TODO 用户购物车更新
        return JTLJSONResult.ok(r);
    }


    @ApiOperation(value = "补全骑手信息",notes = "补全骑手信息",httpMethod = "POST")
    @PostMapping("riderViewUpdate")
    public JTLJSONResult riderViewUpdate(@RequestBody Rider rider) throws Exception{
        Rider r = riderService.updateRider(rider);
        return JTLJSONResult.ok(r);
    }






















}
