package com.jtl.service;

import com.jtl.pojo.StoreChartered;
import com.jtl.pojo.StoreShop;

public interface StoreCharteredService {

    /**
     * 添加商家营业执照信息
     * @param storeChartered
     * @return
     */
    public void createStoreChartered(StoreChartered storeChartered);

    public StoreChartered queryStoreCharteredView(Integer storeId);


}
