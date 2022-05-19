package com.api.wealthwa.service;

import com.api.wealthwa.model.User;
import com.api.wealthwa.model.WealthUser;
import com.api.wealthwa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Author rohit
 * @Date 16/05/22
 **/
@Slf4j
@Service("userDetailServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("fetch by username {} ", username);

        User user = userRepository.findByUserName(username);

        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("No User Found with Username");
        }
        return new WealthUser(user.getUserId(), user.getUserName(),
                AuthorityUtils.
                        commaSeparatedStringToAuthorityList(user.getAuthority()),
                user.getEmail());
    }
}
