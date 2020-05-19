package com.jtl.service.impl;

import com.jtl.mapper.StoreMapper;
import com.jtl.pojo.Store;
import com.jtl.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;


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
    @Override
    public Store queryAllView(Integer storeId) {
        Store store = new Store();
        store.setId(storeId);
        return storeMapper.selectByPrimaryKey(storeId);
    }


}
