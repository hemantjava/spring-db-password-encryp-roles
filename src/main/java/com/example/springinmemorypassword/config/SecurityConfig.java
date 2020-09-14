package com.example.springinmemorypassword.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //Override default spring user and password
    auth.inMemoryAuthentication()
        .withUser("hemant")
        .password("sahu")
        .roles("USER")
        .and()
        .withUser("chitresh")
        .password("nirala").roles("ADMIN");
  }

  //NoOpPasswordEncoder treat as no password encryption or plain test password
  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  //http://localhost:8181/logout   default logout page by spring
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/admin").hasRole("USER")
        .antMatchers("/user").hasAnyRole("ADMIN","USER") //http://localhost:8181/admin or http://localhost:8181/user
        .antMatchers("/").permitAll()
        .and().formLogin();
  }
}
