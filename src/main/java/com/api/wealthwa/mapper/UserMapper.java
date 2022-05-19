package com.api.wealthwa.mapper;

import lombok.Data;

import java.util.Map;

/**
 * @Author rohit
 * @Date 16/05/22
 **/

@Data
public class UserMapper {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String mobile;
    private String authority;

    Map<String, String> message;
}
