package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

@Configuration
class SecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity): DefaultSecurityFilterChain {
        http.invoke {
            csrf { csrfTokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse() }
            httpBasic { disable() }
            authorizeHttpRequests { authorize(anyRequest, permitAll) }
        }
        return http.build()
    }
}
