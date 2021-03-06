package com.jtl.service.impl;

import com.jtl.mapper.StoreCharteredMapper;
import com.jtl.pojo.ItemsParam;
import com.jtl.pojo.ItemsSpec;
import com.jtl.pojo.StoreChartered;
import com.jtl.pojo.StoreShop;
import com.jtl.service.StoreCharteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
public class StoreCharteredServiceImpl implements StoreCharteredService {


    @Autowired
    private StoreCharteredMapper storeCharteredMapper;

    /**
     * 添加商家营业执照信息
     * @param storeChartered
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void createStoreChartered(StoreChartered storeChartered) {
        if (storeChartered != null){
            storeCharteredMapper.insertUseGeneratedKeys(storeChartered);
        }
    }

    /**
     * 查询商家营业执照信息
     * @param storeId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public StoreChartered queryStoreCharteredView(Integer storeId) {
        Example itemsParamExp = new Example(StoreChartered.class);
        Example.Criteria criteria = itemsParamExp.createCriteria();
        criteria.andEqualTo("storeId",storeId);
        return storeCharteredMapper.selectOneByExample(itemsParamExp);
    }


}

