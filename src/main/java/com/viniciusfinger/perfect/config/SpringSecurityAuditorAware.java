package com.viniciusfinger.perfect.config;

import com.viniciusfinger.perfect.util.JwtUtil;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import java.util.Optional;

class SpringSecurityAuditorAware implements AuditorAware<String> {

    //to-do: solve this code smell refer to @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(
                JwtUtil.getUsername(
                        (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
                ));
    }
}
