package com.jtl.service.impl;

import com.jtl.mapper.StoreShopMapper;
import com.jtl.pojo.Store;
import com.jtl.pojo.StoreShop;
import com.jtl.service.StoreService;
import com.jtl.service.StoreShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class StoreShopServiceImpl implements StoreShopService {

    @Autowired
    private StoreShopMapper storeShopMapper;

    /**
     * 创建商家店铺
     * @param storeShop
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void createStoreShop(StoreShop storeShop) {
        if(storeShop != null){
            storeShop.setCreatedTime(new Date());
            storeShop.setUpdatedTime(new Date());
            storeShopMapper.insertUseGeneratedKeys(storeShop);
        }
    }

    /**
     * 查询商家店铺信息
     * @param storeId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public StoreShop queryView(Integer storeId) {

        Example userExmple = new Example(StoreShop.class);
        Example.Criteria userCriteria = userExmple.createCriteria();
        userCriteria.andEqualTo("storeId",storeId);
        StoreShop result = storeShopMapper.selectOneByExample(userExmple);
        return result;
    }

    /**
     * 查询商家类型
     * @param storeType
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<StoreShop> querySjsView(String storeType) {
        StoreShop storeShop = new StoreShop();
        storeShop.setType(storeType);
        List<StoreShop> list = storeShopMapper.select(storeShop);
        return list;
    }


}
