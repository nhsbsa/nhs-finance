package com.nhsbsa.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

/**
 * Created by MattHood on 01/11/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy filterChainProxy;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(new LandingPageController()).dispatchOptions(true).addFilters(filterChainProxy).build();
    }

    @Test
    public void shouldLoginCorrectDetails() throws Exception {
        mvc.perform(formLogin().user("member").password("password"))
                .andExpect(authenticated());
    }

    @Test
    public void shouldNotLoginIncorrectDetails() throws Exception {
        mvc.perform(formLogin().password("invalid"))
                .andExpect(redirectedUrl("/login?error"));
    }

    @Test
    public void shouldLogout() throws Exception {
        mvc.perform(logout("/employer/logout"))
                .andExpect(redirectedUrl("http://localhost/login"));
    }

}
