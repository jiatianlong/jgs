package com.jtl.controller.user;


import com.jtl.bo.AddressBO;
import com.jtl.bo.CenterUsersBO;
import com.jtl.bo.UsersBO;
import com.jtl.controller.BaseController;
import com.jtl.pojo.UserAddress;
import com.jtl.pojo.UserOrUserAddress;
import com.jtl.pojo.Users;
import com.jtl.service.UserAddressService;
import com.jtl.service.UserService;
import com.jtl.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@Api(value = "用户信息",tags = {"关于用户信息的相关接口"})
@RestController
@RequestMapping("/passport")
public class UsersController extends BaseController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserAddressService userAddressService;

    @ApiOperation(value = "根据用户ID查询用户信息",notes = "根据用户ID查询用户信息",httpMethod = "GET")
    @GetMapping("/queryUserCont")
    public JTLJSONResult queryUserCont(@RequestParam Integer id){
        //判断ID是否为空
        if(id == null){
           return JTLJSONResult.errorMsg("用户ID为空");
        }
        Users users = userService.queryUserCont(id);
        return JTLJSONResult.ok(users);
    }

    @ApiOperation(value = "修改用户信息",notes = "修改用户信息",httpMethod = "POST")
    @PostMapping("/updateUser")
    public JTLJSONResult updateUser(@RequestBody CenterUsersBO centerUsersBO) throws Exception {
        userService.updateUsers(centerUsersBO);
        return JTLJSONResult.ok();
    }


    @ApiOperation(value = "用户头像修改", notes = "用户头像修改", httpMethod = "POST")
    @PostMapping("uploadFace")
    public JTLJSONResult uploadFace(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "file", value = "用户头像", required = true)
                    MultipartFile file,
            HttpServletRequest request, HttpServletResponse response) {


        // 上传的头像最终保存的位置
        String finalFacePath=null;
        // 定义头像保存的地址
       String fileSpace = IMAGE_USER_FACE_LOCATION;
       /* String fileSpace = fileUpload.getImageUserFaceLocation();*/
        // 在路径上为每一个用户增加一个userid，用于区分不同用户上传
        String uploadPathPrefix = File.separator + userId;
        // 开始文件上传
        if (file != null) {
            FileOutputStream fileOutputStream = null;
            try {
                // 获得文件上传的文件名称
                String fileName = file.getOriginalFilename();

                if (StringUtils.isNotBlank(fileName)) {

                    // 文件重命名  imooc-face.png -> ["imooc-face", "png"]
                    String fileNameArr[] = fileName.split("\\.");

                    // 获取文件的后缀名
                    String suffix = fileNameArr[fileNameArr.length - 1];

                    if (!suffix.equalsIgnoreCase("png") &&
                            !suffix.equalsIgnoreCase("jpg") &&
                            !suffix.equalsIgnoreCase("jpeg") ) {
                        return JTLJSONResult.errorMsg("图片格式不正确！");
                    }

                    // face-{userid}.png
                    // 文件名称重组 覆盖式上传，增量式：额外拼接当前时间
                    String newFileName = "face-" + userId + "." + suffix;

                    // 上传的头像最终保存的位置
                    finalFacePath = fileSpace + uploadPathPrefix + File.separator + newFileName;
                    // 用于提供给web服务访问的地址
                    uploadPathPrefix += ("/" + newFileName);

                    File outFile = new File(finalFacePath);
                    if (outFile.getParentFile() != null) {
                        // 创建文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    // 文件输出保存到目录
                    fileOutputStream = new FileOutputStream(outFile);
                    InputStream inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            return JTLJSONResult.errorMsg("文件不能为空！");
        }

        // 更新用户头像到数据库
        userService.updateUserFace(userId, finalFacePath);
        // TODO 后续要改，增加令牌token，会整合进redis，分布式会话
        return JTLJSONResult.ok(finalFacePath);
    }



    @ApiOperation(value = "修改用户信息",notes = "修改用户信息",httpMethod = "POST")
    @PostMapping("/updateUserOrAddAddress")
    public JTLJSONResult updateUserOrAddAddress(@RequestBody UserOrUserAddress userOrUserAddress) throws Exception {
        //userService.updateUsers(centerUsersBO);

        //修改用户信息
        Users users = new Users();
        users.setId(userOrUserAddress.getId());
        users.setNickname(userOrUserAddress.getNickName());
        users.setRealname(userOrUserAddress.getRealName());
        users.setMobile(userOrUserAddress.getMobile());
        users.setEmail(userOrUserAddress.getEmail());
        userService.update(users);
        //添加用户地址
        AddressBO addressBO = new AddressBO();
        addressBO.setUserId(Integer.valueOf(userOrUserAddress.getId()));
        addressBO.setReceiver(userOrUserAddress.getRealName());
        addressBO.setMobile(userOrUserAddress.getMobile());
        addressBO.setProvince(userOrUserAddress.getProvince());
        addressBO.setCity(userOrUserAddress.getCity());
        addressBO.setDistrict(userOrUserAddress.getDistrict());
        addressBO.setDetail(userOrUserAddress.getDetail());
        userAddressService.addNewUserAddress(addressBO);

        return JTLJSONResult.ok();


    }




    /*@ApiOperation(value = "用户登录",notes = "用户登录",httpMethod = "POST")
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
        Users users = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        if(users == null){
            return JTLJSONResult.errorMsg("用户或密码不正确");
        }

        //设置cookie
        CookieUtils.setCookie(request,response,"user",
                JsonUtils.objectToJson(users),true);
        //TODO 生成用户token，存入redis会话
        //TODO 用户购物车更新
        return JTLJSONResult.ok(users);
    }*/








}
