package com.techprimers.security.jwtsecurity.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
//    private AuthenticationManager authenticationManager;
//    private JwtSuccessHandler authenticationSuccessHandler;

    protected JwtAuthenticationTokenFilter(String defaultFilterProcessesUrl){
       // super(defaultFilterProcessesUrl);
        super("/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        return null;
    }

//    public void setAuthenticationManager(AuthenticationManager authenticationManager){
//        this.authenticationManager = authenticationManager;
//    }
//    public void setAuthenticationSuccessHandler(JwtSuccessHandler authenticationSuccessHandler){
//        this.authenticationSuccessHandler = authenticationSuccessHandler;
//    }
}
