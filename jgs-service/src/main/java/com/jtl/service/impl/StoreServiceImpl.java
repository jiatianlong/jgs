package com.jtl.service.impl;

import com.jtl.mapper.StoreMapper;
import com.jtl.pojo.Store;
import com.jtl.pojo.Users;
import com.jtl.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.beans.Transient;

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





}
