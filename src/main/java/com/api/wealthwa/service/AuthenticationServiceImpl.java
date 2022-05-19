package com.api.wealthwa.service;

import com.api.wealthwa.mapper.UserDto;
import com.api.wealthwa.model.AuthToken;
import com.api.wealthwa.model.WealthUser;
import com.api.wealthwa.repository.AuthTokenRepository;
import com.api.wealthwa.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author rohit
 * @Date 16/05/22
 **/
@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private AuthTokenRepository authTokenRepository;

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public Map<String, Object> authenticateUser(UserDto user) {
        log.info("Authentication user : [{}]", user);

        Map<String, Object> map = new HashMap<>();
        String token = "";

        WealthUser wealthUser = (WealthUser) userDetailsService
                .loadUsernameAndPassword(user.getUsername(), user.getPassword());

        AuthToken authToken = authTokenRepository.findByUserId(wealthUser.getUserId());

        if (ObjectUtils.isEmpty(authToken)) {
            token = tokenUtils.generateToken(user.getUsername());
            AuthToken authTokens = AuthToken.builder()
                    .userId(wealthUser.getUserId())
                    .token(token)
                    .build();

            authTokenRepository.save(authTokens);
        } else {
            token = authToken.getToken();
        }
        map.put("user", user);
        map.put("token", token);

        return map;
    }

}
