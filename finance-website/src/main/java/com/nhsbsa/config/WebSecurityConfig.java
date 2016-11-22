package com.nhsbsa.config;

import com.nhsbsa.security.FinanceAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jeffreya on 18/08/2016.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FinanceAuthenticationProvider memberAuthenticationProvider;


    private static final List<String> NO_SECURITY_URLS = new ArrayList<>(Arrays.asList(
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
            "/login"));

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final String[] unsecuredUrls = getUnsecuredUrls();
        http
                .authorizeRequests()
                .antMatchers(unsecuredUrls).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> httpServletResponse.sendRedirect("/scheduleyourpayment"))
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll();
    }

    private String[] getUnsecuredUrls() {
        return getEndPoints();
    }

    private String[] getEndPoints() {
        return NO_SECURITY_URLS.toArray(new String[NO_SECURITY_URLS.size()]);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth
                .authenticationProvider(memberAuthenticationProvider);
    }
}