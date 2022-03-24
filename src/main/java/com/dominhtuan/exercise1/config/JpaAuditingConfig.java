package com.dominhtuan.exercise1.config;

import com.dominhtuan.exercise1.service.impl.AuditorAwareServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider(){
        return new AuditorAwareServiceImpl();
    }
}
