package com.jtl.service;

import com.jtl.bo.StoreBO;
import com.jtl.bo.UsersBO;
import com.jtl.pojo.Store;
import com.jtl.pojo.Users;

import java.util.List;

public interface StoreService {

    /**
     * 检索商家用户名和密码是否匹配，用于登录
     * @param username
     * @param password
     * @return
     */
    public Store queryUserForLogin(String username, String password);


    /**
     * 根据商家Id查询商家信息
     * @param storeId
     * @return
     */
    public Store queryAllView(Integer storeId);

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryStorenameIsExist(String username);

    /**
     * 创建用户
     * @param storeBO
     * @return
     */
    public Store createStore(StoreBO storeBO);


}
