package com.example.TicketGuru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.TicketGuru.service.DetailsService;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private DetailsService userDetailsService;

    private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {
            new AntPathRequestMatcher("/events")
    };

    private static final AntPathRequestMatcher[] ADMIN_LIST_URLS = {
            new AntPathRequestMatcher("/tickets")
    };

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers(ADMIN_LIST_URLS).hasAuthority("ADMIN")
                .and()
                .headers().frameOptions().disable()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/", true)
                .and()
                .logout().permitAll().logoutSuccessUrl("/")
                .and()
                .httpBasic();

        http.cors().and().csrf().disable();
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
