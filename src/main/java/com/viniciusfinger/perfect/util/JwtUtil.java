package com.viniciusfinger.perfect.util;

import org.springframework.security.oauth2.jwt.Jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

    private JwtUtil(){}

    public static String getClientId(Jwt token){
        DecodedJWT jwt = JWT.decode(token.getTokenValue());
        String source = jwt.getClaim("client_id").toString();
        return source.replace("\"", "");
    }

    public static String getUsername(Jwt token){
        DecodedJWT jwt = JWT.decode(token.getTokenValue());
        String source = jwt.getClaim("preferred_username").toString();
        return source.replace("\"", "");
    }
}