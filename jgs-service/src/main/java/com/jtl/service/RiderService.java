package com.jtl.service;

import com.jtl.pojo.Rider;

public interface RiderService {

    /**
     * 判断用户名是否存在
     * @param riderName
     * @return
     */
    public boolean queryRiderNameIsExist(String riderName);

    /**
     * 创建用户
     * @param rider
     * @return
     */
    public Rider createRider(Rider rider) throws Exception;


    /**
     * 检索用户名和密码是否匹配，用于登录
     * @param riderName
     * @param password
     * @return
     */
    public Rider queryRiderForLogin(String riderName,String password);


    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    public Rider queryRiderCont(Integer id);


    /**
     * 修改用户信息
     * @param rider
     * @return
     */
    public Rider updateRider(Rider rider);







}
