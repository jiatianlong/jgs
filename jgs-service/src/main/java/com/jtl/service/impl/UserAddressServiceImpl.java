package com.jtl.service.impl;

import com.jtl.bo.AddressBO;
import com.jtl.enums.YesOrNo;
import com.jtl.mapper.UserAddressMapper;
import com.jtl.pojo.UserAddress;
import com.jtl.service.UserAddressService;
import com.jtl.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;


    /**
     * 根据用户ID查询收货地址列表
     * @param userId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserAddress> queryAll(Integer userId) {
        UserAddress ua = new UserAddress();
        ua.setUserId(userId);
        return userAddressMapper.select(ua);
    }

    @Override
    public List<UserAddress> queryAllIsDefault(Integer userId) {
        UserAddress us = new UserAddress();
        us.setUserId(userId);
        us.setIsDefault(1);
        return userAddressMapper.select(us);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addNewUserAddress(AddressBO addressBO) {

        //1.判断当前用户是否存在地址，如果没有，则新增为'默认地址'
        Integer isDefault = 0;
        List<UserAddress> list = this.queryAll(addressBO.getUserId());
        if(list == null || list.isEmpty() || list.size() == 0){
            isDefault = 1;
        }

        //2.保存到数据库
        UserAddress newAddress = new UserAddress();
        //把addressBO相同属性的之copy到newAddress中
        BeanUtils.copyProperties(addressBO,newAddress);
        newAddress.setIsDefault(isDefault);
        newAddress.setCreatedTime(new Date());
        newAddress.setUpdatedTime(new Date());
        userAddressMapper.insert(newAddress);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddress(AddressBO addressBO) {
        Integer addressId = addressBO.getId();
        UserAddress upAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO,upAddress);
        upAddress.setId(addressId);
        upAddress.setUpdatedTime(new Date());
        userAddressMapper.updateByPrimaryKeySelective(upAddress);


    }

    /**
     * 根据用户ID和收货地址ID删除对应的收货地址信息
     * @param id
     * @param userId
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserAddress(Integer id,Integer userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(id);
        userAddress.setUserId(userId);
        userAddressMapper.delete(userAddress);
    }

    /**
     * 根据用户ID和收货地址ID设置默认收货地址
     * @param id
     * @param userId
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddressToBefault(Integer id, Integer userId) {

        //1.查找默认地址,设置为不默认
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        userAddress.setIsDefault(YesOrNo.YES.type);
        List<UserAddress> list = userAddressMapper.select(userAddress);
        //把所有地址设置为不默认地址
        for (UserAddress ua:list){
            ua.setIsDefault(YesOrNo.NO.type);
            userAddressMapper.updateByPrimaryKeySelective(ua);
        }

        //2.根据地址ID修改为默认地址
        UserAddress queryAddress = new UserAddress();
        queryAddress.setId(id);
        queryAddress.setUserId(userId);
        queryAddress.setIsDefault(YesOrNo.YES.type);
        userAddressMapper.updateByPrimaryKeySelective(queryAddress);
    }

    /**
     * 根据用户ID和收货地址ID查询用户地址信息
     * @param id
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserAddress queryUserAddres(Integer id, Integer userId) {

        UserAddress singleAddress = new UserAddress();
        singleAddress.setId(id);
        singleAddress.setUserId(userId);
        return userAddressMapper.selectOne(singleAddress);
    }


}
