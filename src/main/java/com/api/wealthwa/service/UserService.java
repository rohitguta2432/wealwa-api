package com.api.wealthwa.service;

import com.api.wealthwa.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

/**
 * @Author rohit
 * @Date 16/05/22
 **/

public interface UserService {

    UserDetails loadUsernameAndPassword(String username, String password);
    Map<String,String> create(UserMapper userMapper);

}
