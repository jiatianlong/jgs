package com.jtl.service;

import com.jtl.bo.CenterUsersBO;
import com.jtl.bo.UsersBO;
import com.jtl.pojo.Users;
import org.apache.catalina.User;

public interface UserService {

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameIsExist(String username);


    /**
     * 创建用户
     * @param usersBO
     * @return
     */
    public Users createUser(UsersBO usersBO);


    /**
     * 检索用户名和密码是否匹配，用于登录
     * @param username
     * @param password
     * @return
     */
    public Users queryUserForLogin(String username,String password);


    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    public Users queryUserCont(Integer id);


    /**
     * 修改用户信息
     * @param centerUsersBO
     * @return
     */
    public void updateUsers(CenterUsersBO centerUsersBO);

    /**
     * 用户头像更新
     * @param userId
     * @param faceUrl
     * @return
     */
    public void updateUserFace(String userId, String faceUrl);


}
