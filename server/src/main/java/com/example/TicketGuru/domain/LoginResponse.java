package com.example.TicketGuru.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class LoginResponse {
    private Long userId;
    private String token;
    private String email;
    // GrantedAuthority on UserDetailsin interface
    // ks. DetailsService.java rivi 47 =>
    private Collection<? extends GrantedAuthority> authorities;

    public LoginResponse(Long userId, String token, String email, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.token = token;
        this.email = email;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
