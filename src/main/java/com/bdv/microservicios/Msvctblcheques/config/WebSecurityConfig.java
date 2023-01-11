package com.bdv.microservicios.Msvctblcheques.config;

import com.bdv.microservicios.Msvctblcheques.services.security.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UsuarioDetailsService usuarioDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic(withDefaults()).authorizeRequests()
                .antMatchers("/app/getTblCheque/**").hasRole("admin")
                .anyRequest().authenticated();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(usuarioDetailsService);

       /* auth.inMemoryAuthentication().withUser("Tblcheque").password("{noop}"+"Microserviciotblechequepassword").roles("admin")
                .and()
                .withUser("user").password("{noop}"+"12345").roles("user");*/
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}