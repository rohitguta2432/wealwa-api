package com.api.wealthwa.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 16/05/22
 **/
@Data
public class WealthUser implements UserDetails {

    private UUID userId;
    private String userName;
    private Collection<? extends GrantedAuthority> authorities;
    private String emailId;

    public WealthUser(UUID userId, String userName,
                       Collection<? extends GrantedAuthority> authorities, String email) {
        this.setUserId(userId);
        this.setUserName(userName);
        this.setAuthorities(authorities);
        this.setEmailId(email);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
