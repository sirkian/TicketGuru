package com.example.TicketGuru.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class LoginResponse {
    private String token;
    private String email;
    // GrantedAuthority on UserDetailsin interface
    // ks. DetailsService.java rivi 47 =>
    private Collection<? extends GrantedAuthority> authorities;

    public LoginResponse(String token, String email, Collection<? extends GrantedAuthority> authorities) {
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
}
