package com.jtl.service;

import com.jtl.bo.AddressBO;
import com.jtl.pojo.UserAddress;

import java.util.List;

public interface UserAddressService {


    /**
     * 根据用户ID查询收货地址列表
     * @param userId
     * @return
     */
    public List<UserAddress> queryAll(Integer userId);


    /**
     * 根据用户ID查询默认收货地址
     * @param userId
     * @return
     */
    public List<UserAddress> queryAllIsDefault(Integer userId);


    /**
     * 添加用户收货地址
     * @param addressBO
     */
    public void addNewUserAddress(AddressBO addressBO);

    /**
     * 修改用户收货地址
     * @param addressBO
     */
    public void updateUserAddress(AddressBO addressBO);


    /**
     * 根据用户ID和收货地址ID删除对应的收货地址信息
     * @param id
     */
    public void deleteUserAddress(Integer id,Integer userId);


    /**
     * 根据用户ID和收货地址ID设置默认收货地址
     * @param id
     */
    public void updateUserAddressToBefault(Integer id,Integer userId);

    /**
     * 根据用户ID和收货地址ID查询用户地址信息
     * @param id
     */
    public UserAddress queryUserAddres(Integer id,Integer userId);



}
