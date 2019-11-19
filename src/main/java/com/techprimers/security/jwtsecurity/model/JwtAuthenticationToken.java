package com.techprimers.security.jwtsecurity.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private String token;
//    public JwtAuthenticationToken(Object principal, Object credentials) {
//        super(principal, credentials);
//    }

    public JwtAuthenticationToken(String token) {
        super(null,null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null ;
    }

    //    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
//        super(principal, credentials, authorities);
//    }
}
