package com.techprimers.security.jwtsecurity.security;

import com.techprimers.security.jwtsecurity.model.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
//    private AuthenticationManager authenticationManager;
//    private JwtSuccessHandler authenticationSuccessHandler;

//    protected JwtAuthenticationTokenFilter(String defaultFilterProcessesUrl){
//       // super(defaultFilterProcessesUrl);
//        super("/**");
//    }

        public JwtAuthenticationTokenFilter(){
           super("/rest/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String header = httpServletRequest.getHeader("Authorization");
        if(header == null || !header.startsWith("Barer ")){
            throw new RuntimeException("JWT token is missing");
                    }
        String authenticationToken = header.substring(6);
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }

//    public void setAuthenticationManager(AuthenticationManager authenticationManager){
//        this.authenticationManager = authenticationManager;
//    }
//    public void setAuthenticationSuccessHandler(JwtSuccessHandler authenticationSuccessHandler){
//        this.authenticationSuccessHandler = authenticationSuccessHandler;
//    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request,response);
    }
}
