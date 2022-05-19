package com.api.wealthwa.controller;

import com.api.wealthwa.mapper.UserDto;
import com.api.wealthwa.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author rohit
 * @Date 16/05/22
 **/

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(authenticationService
                               .authenticateUser(userDto), HttpStatus.OK);
    }
}
