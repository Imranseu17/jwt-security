package com.techprimers.security.jwtsecurity.security;

import com.techprimers.security.jwtsecurity.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String secret = "youtube";


    public JwtUser validate(String token){
         JwtUser jwtuser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
            jwtuser = new JwtUser();
            jwtuser.setUserName(body.getSubject());
            jwtuser.setId(Long.parseLong((String)body.get("userId")));
            jwtuser.setRole((String)body.get("role"));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return jwtuser;
    }
}
