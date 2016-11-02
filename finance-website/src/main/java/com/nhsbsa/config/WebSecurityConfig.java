package com.nhsbsa.config;

import com.nhsbsa.security.FinanceAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by jeffreya on 18/08/2016.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // NOTE: IntelliJ message "Could not autowire. No beans of 'MemberAuthenticationProvider' type found." It is OK.
    @Autowired
    private FinanceAuthenticationProvider memberAuthenticationProvider;

    private static final String[] NO_SECURITY_URLS = {
            "/",
            "/start",
            "/css/*",
            "/fonts/*",
            "/images/*",
            "/javascripts/**",
            "/js/*",
            "/stylesheets/*",
            "/public/**/*",
            "/public",
            "/public/**",
            "/swagger-ui.html",
            "/v2/**",
            "/login"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(NO_SECURITY_URLS).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> httpServletResponse.sendRedirect("/finance"))
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth
                .authenticationProvider(memberAuthenticationProvider);
    }
}