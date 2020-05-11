package com.jtl.service.impl;

import com.jtl.bo.CenterUsersBO;
import com.jtl.bo.UsersBO;
import com.jtl.enums.Sex;
import com.jtl.mapper.UsersMapper;
import com.jtl.pojo.Users;
import com.jtl.service.UserService;
import com.jtl.utils.DateUtil;
import com.jtl.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;


    private static final String USER_FACE = "默认头像地址";

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
       /* try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Example userExmple = new Example(Users.class);
        Example.Criteria userCriteria = userExmple.createCriteria();
        userCriteria.andEqualTo("username",username);
        Users result = usersMapper.selectOneByExample(userExmple);

        return result == null ? false : true;
    }

    /**
     * 添加用户
     * @param usersBO
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UsersBO usersBO) {

        Users users = new Users();
        users.setUsername(usersBO.getUsername());
        try {
            users.setPassword(MD5Utils.getMD5Str(usersBO.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
        }
        //默认昵称
        users.setNickname(usersBO.getUsername());
        //默认头像地址
        users.setFace(USER_FACE);
        //设置默认的生日
        users.setBirthday(DateUtil.stringToDate("1900-01-01"));
        //设置性别 默认为保密
        users.setSex(Sex.secret.type);

        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());

        usersMapper.insert(users);

        return users;
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {
        Example userExmple = new Example(Users.class);
        Example.Criteria userCriteria = userExmple.createCriteria();
        userCriteria.andEqualTo("username",username);
        userCriteria.andEqualTo("password",password);

        Users result = usersMapper.selectOneByExample(userExmple);

        return result;
    }

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserCont(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改用户信息
     * @param centerUsersBO
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUsers(CenterUsersBO centerUsersBO) {
        Users updateUser = new Users();
        BeanUtils.copyProperties(centerUsersBO, updateUser);
        updateUser.setUpdatedTime(new Date());
        usersMapper.updateByPrimaryKeySelective(updateUser);
    }

    /**
     * 更新用户头像
     * @param userId
     * @param faceUrl
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserFace(String userId, String faceUrl) {
        Users updateUser = new Users();
        updateUser.setId(userId);
        updateUser.setFace(faceUrl);
        updateUser.setUpdatedTime(new Date());
        usersMapper.updateByPrimaryKeySelective(updateUser);
    }


}
