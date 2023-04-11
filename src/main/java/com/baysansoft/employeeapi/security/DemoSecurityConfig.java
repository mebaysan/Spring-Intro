package com.baysansoft.employeeapi.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // static in-memory authentication
    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {
    // UserDetails user1 = User.builder()
    // .username("user1")
    // .password("{noop}password")
    // .roles("EMPLOYEE")
    // .build();

    // UserDetails user2 = User.builder()
    // .username("user2")
    // .password("{noop}password")
    // .roles("EMPLOYEE", "MANAGER")
    // .build();

    // UserDetails user3 = User.builder()
    // .username("user3")
    // .password("{noop}password")
    // .roles("EMPLOYEE", "MANAGER", "ADMIN")
    // .build();

    // return new InMemoryUserDetailsManager(user1, user2, user3);

    // }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("ADMIN"));

        // use httpBasic() to enable basic authentication
        http.httpBasic();

        // disable CSRF to enable POST requests
        http.csrf().disable();

        return http.build();
    }

}
