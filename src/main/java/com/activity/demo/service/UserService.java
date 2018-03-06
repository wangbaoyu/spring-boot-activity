package com.activity.demo.service;

import com.activity.demo.dao.UserDao;
import com.activity.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;
    public User selectUserByUserId(String userId){
        return userDao.selectUserByUserId(userId);
    }

    public User userLogin(Map<String, Object> map) {
        return userDao.userLogin(map);
    }

    public void register(User user) {
        user.setUserId(user.getUserName());
        Map<String,Object> userMap = new HashMap();
        userMap.put("userId",user.getUserId());
        userMap.put("userName",user.getUserName());
        userMap.put("passWord",user.getPassWord());
        userDao.saveUser(userMap);
    }
}
