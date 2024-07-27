package com.viniciusfinger.perfect.config;

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

class SpringSecurityAuditorAware implements AuditorAware<String> {

    //to-do: solve this code smell refer to @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("MOCKED");
    }
}
