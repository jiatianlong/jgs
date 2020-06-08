package com.jtl.service;

import com.jtl.bo.StoreBO;
import com.jtl.pojo.Store;
import com.jtl.pojo.StoreShop;

import java.util.List;

public interface StoreShopService {

    /**
     * 创建商家店铺
     * @param storeShop
     * @return
     */
    public void createStoreShop(StoreShop storeShop);

    /**
     * 根据商家ID查看商家店铺信息
     * @param storeId
     * @return
     */
    public StoreShop queryView(Integer storeId);


    /**
     * 查询设计师
     * @param storeType
     * @return
     */
    public List<StoreShop> querySjsView(String storeType);


}
