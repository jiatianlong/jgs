package com.jtl.service.impl;

import com.jtl.bo.StoreBO;
import com.jtl.enums.Sex;
import com.jtl.mapper.StoreMapper;
import com.jtl.pojo.Store;
import com.jtl.service.StoreService;
import com.jtl.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;


/**
 * 商家信息
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    /**
     * 商家登录
     * @param username
     * @param password
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Store queryUserForLogin(String username, String password) {

        Example storeExmple = new Example(Store.class);
        Example.Criteria storeCriteria = storeExmple.createCriteria();
        storeCriteria.andEqualTo("username",username);
        storeCriteria.andEqualTo("password",password);
        Store store = storeMapper.selectOneByExample(storeExmple);
        return store;
    }

    /**
     * 商家信息
     * @param storeId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Store queryAllView(Integer storeId) {
        Store store = new Store();
        store.setId(storeId);
        return storeMapper.selectByPrimaryKey(storeId);
    }

    /**
     * 判断商家是否存在
     * @param username
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryStorenameIsExist(String username) {
        Example userExmple = new Example(Store.class);
        Example.Criteria userCriteria = userExmple.createCriteria();
        userCriteria.andEqualTo("username",username);
        Store result = storeMapper.selectOneByExample(userExmple);
        return result == null ? false : true;
    }

    /**
     * 创建商家
     * @param storeBO
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Store createStore(StoreBO storeBO) {
        Store store = new Store();
        store.setUsername(storeBO.getUsername());
        try {
            store.setPassword(MD5Utils.getMD5Str(storeBO.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
        }
        //默认昵称
        store.setNickname("青山商家");
        //设置性别 默认为保密
        store.setSex(Sex.secret.type);
        store.setCreatedTime(new Date());
        store.setUpdatedTime(new Date());
        storeMapper.insertUseGeneratedKeys(store);
        return store;
    }


}
