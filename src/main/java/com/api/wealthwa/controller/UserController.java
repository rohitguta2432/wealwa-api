package com.api.wealthwa.controller;

import com.api.wealthwa.mapper.UserMapper;
import com.api.wealthwa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author rohit
 * @Date 12/05/22
 **/

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserMapper user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }
}

