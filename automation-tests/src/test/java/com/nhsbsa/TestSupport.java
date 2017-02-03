package com.nhsbsa;

import com.nhsbsa.webdriver.DriverManager;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * Created by Mark Lishman on 12/09/2016.
 */
public class TestSupport {

    @Autowired DataSource dataSource;

    @Before
    public void before() {
       // Script that sets the database to a consistent state.
       // ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
       // populator.addScripts(new ClassPathResource("/test-data/member.sql"));
       // populator.execute(dataSource);
    }

    @After("@smokeTest")
    public void after() {
        DriverManager.shutdown();
    }

}