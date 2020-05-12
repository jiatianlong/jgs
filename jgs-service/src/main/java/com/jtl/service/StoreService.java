package com.jtl.service;

import com.jtl.pojo.Store;

public interface StoreService {

    /**
     * 检索商家用户名和密码是否匹配，用于登录
     * @param username
     * @param password
     * @return
     */
    public Store queryUserForLogin(String username, String password);


}
