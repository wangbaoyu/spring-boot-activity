package com.activity.demo.dao;

import com.activity.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserDao {
    User selectUserByUserId(String userId);

    User userLogin(Map<String, Object> map);

    User selectUserByUserName(String userName);

    void saveUser(Map<String,Object>  useMap);

}
