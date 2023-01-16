package com.example.securitymaster.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.example.securitymaster.security.SecurityRoles.*;
@EnableMethodSecurity(securedEnabled = true)
public class WevSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){

        var uds = new InMemoryUserDetailsManager();

        var john = User.withUsername("john")
                .password("john")
                .roles(ROLES_ADMIN)
                .build();

        var emma = User.withUsername("emma")
                .password("emma")
                .roles(EMPLOYEES_ADMIN)
                .build();

        var william = User.withUsername("william")
                .password("william")
                .roles(EMPLOYEES_ADMIN,EMPLOYEES_CREATE,EMPLOYEES_READ,EMPLOYEES_PAG_VIEW)
                .build();

        var lucas = User.withUsername("lucas")
                .password("lucas")
                .roles(CUSTOMERS_READ,CUSTOMERS_PAG_VIEW)
                .build();

        var tom = User.withUsername("tom")
                .password("tom")
                .roles()
                .build();

        uds.createUser(john);
        uds.createUser(emma);
        uds.createUser(william);
        uds.createUser(lucas);
        uds.createUser(tom);

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
