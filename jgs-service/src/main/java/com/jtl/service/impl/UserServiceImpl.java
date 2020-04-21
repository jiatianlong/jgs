package com.jtl.service.impl;

import com.jtl.bo.UsersBO;
import com.jtl.enums.Sex;
import com.jtl.mapper.StuMapper;
import com.jtl.mapper.UsersMapper;
import com.jtl.pojo.Stu;
import com.jtl.pojo.Users;
import com.jtl.service.StuService;
import com.jtl.service.UserService;
import com.jtl.utils.DateUtil;
import com.jtl.utils.MD5Utils;
import org.n3r.idworker.Sid;
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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {

        Example userExmple = new Example(Users.class);
        Example.Criteria userCriteria = userExmple.createCriteria();
        userCriteria.andEqualTo("username",username);
        Users result = usersMapper.selectOneByExample(userExmple);

        return result == null ? false : true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UsersBO usersBO) {

        String userId = sid.nextShort();

        Users users = new Users();
        users.setId(userId);
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
}
