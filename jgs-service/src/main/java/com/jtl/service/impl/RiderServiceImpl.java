package com.jtl.service.impl;

import com.jtl.mapper.RiderMapper;
import com.jtl.pojo.Rider;
import com.jtl.service.RiderService;
import com.jtl.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class RiderServiceImpl  implements RiderService {

    @Autowired
    private RiderMapper riderMapper;

    /**
     * 判断用户是否存在
     * @param riderName
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryRiderNameIsExist(String riderName) {
        Example riderExample = new Example(Rider.class);
        Example.Criteria riderCriteria = riderExample.createCriteria();
        riderCriteria.andEqualTo("riderName",riderName);
        Rider result = riderMapper.selectOneByExample(riderExample);
        return result == null ? false : true;
    }

    /**
     * 添加骑手
     * @param rider
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Rider createRider(Rider rider) throws Exception {
        Rider r= new Rider();
        String riderName = rider.getRiderName();
        String pwd = rider.getPassword();
        r.setRiderName(riderName);
        r.setPassword(MD5Utils.getMD5Str(pwd));
        r.setCreatedTime(new Date());
        r.setUpdatedTime(new Date());
        riderMapper.insertUseGeneratedKeys(r);
        return r;
    }

    /**
     * 检索用户名和密码是否匹配，用于登录
     * @param riderName
     * @param password
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Rider queryRiderForLogin(String riderName, String password) {

        Example riderExmple = new Example(Rider.class);
        Example.Criteria riderCriteria = riderExmple.createCriteria();
        riderCriteria.andEqualTo("riderName",riderName);
        riderCriteria.andEqualTo("password",password);

        Rider result = riderMapper.selectOneByExample(riderExmple);

        return result;
    }

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Rider queryRiderCont(Integer id) {
        return riderMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改骑手信息
     * @param rider
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Rider updateRider(Rider rider) {
        rider.setUpdatedTime(new Date());
        riderMapper.updateByPrimaryKeySelective(rider);
        return rider;
    }

}
