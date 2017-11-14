package org.tustcs.lockers.service.impl;

import org.tustcs.lockers.dao.RedisDao;
import org.tustcs.lockers.dao.UsersMapper;
import org.tustcs.lockers.entity.Users;
import org.tustcs.lockers.service.UserService;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Airmacx on 2017/11/13.
 */
public class UserServiceImpl implements UserService {

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private RedisDao redisDao;

    @Override
    public String addUser(String openId, String sessionKey) throws IOException {

        String sessionVal=redisDao.add3rdSession(openId,sessionKey);
        Users users=usersMapper.selectByOpenId(openId);
        if(users==null){
            users=new Users();
            users.setOpenId(openId);
            usersMapper.insertSelective(users);
        }
        return sessionVal;
    }

}
