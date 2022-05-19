package com.api.wealthwa.service;

import com.api.wealthwa.mapper.UserMapper;
import com.api.wealthwa.model.User;
import com.api.wealthwa.model.WealthUser;
import com.api.wealthwa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * @Author rohit
 * @Date 17/05/22
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUsernameAndPassword(String username, String password) {
        log.info("fetch user by username : {} ", username);

        User user = userRepository.findByUserName(username);

        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("No user found with username");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UsernameNotFoundException("Invalid Crendials..");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        Arrays.asList(user.getAuthority())
                .forEach(a -> {
                    authorities.add(new SimpleGrantedAuthority(a));
                });

        return new WealthUser(user.getUserId(), user.getUserName(),
                authorities
                , user.getEmail());
    }

    @Override
    public Map<String, String> create(UserMapper userMapper) {
        log.info("create user : {} ", userMapper);
        Map<String, String> map = new HashMap<>();
        User user = User.builder()
                .firstName(userMapper.getFirstName())
                .userName(userMapper.getUsername())
                .email(userMapper.getEmail())
                .mobile(userMapper.getMobile())
                .password(passwordEncoder.encode(userMapper.getPassword()))
                .authority(userMapper.getAuthority())
                .build();

        userRepository.save(user);
        map.put("msg","user register successfully");
        return map;
    }

}
