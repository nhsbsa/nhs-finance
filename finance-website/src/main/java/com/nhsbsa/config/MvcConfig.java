package com.nhsbsa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by mlishman on 26/10/2016.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("start");
        registry.addViewController("/start").setViewName("start");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/scheduleyourpayment").setViewName("scheduleyourpayment");
    }

}
