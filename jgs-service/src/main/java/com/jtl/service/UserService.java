package com.jtl.service;

import com.jtl.bo.UsersBO;
import com.jtl.pojo.Users;

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

}
