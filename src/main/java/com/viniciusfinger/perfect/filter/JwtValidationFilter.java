package com.viniciusfinger.perfect.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

public class JwtValidationFilter extends OncePerRequestFilter {

    //to-do: solve code smells
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader("Authorization");

        Optional.of(jwt).ifPresent(token -> {
            DecodedJWT decodedJWT = JWT.decode(jwt.replace("Bearer ", ""));

            if (decodedJWT.getExpiresAt().before(new Date())) {
                throw new InvalidBearerTokenException("Token expired");
            }

        });

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().contains("/auth");
    }
}