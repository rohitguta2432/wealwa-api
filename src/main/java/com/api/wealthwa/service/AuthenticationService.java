package com.api.wealthwa.service;

import com.api.wealthwa.mapper.UserDto;

import java.util.Map;

/**
 * @Author rohit
 * @Date 16/05/22
 **/

public interface AuthenticationService {
    Map<String, Object> authenticateUser(UserDto user);
}
