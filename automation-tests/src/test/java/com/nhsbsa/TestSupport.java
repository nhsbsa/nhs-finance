package com.nhsbsa;

import com.nhsbsa.webdriver.DriverManager;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * Created by Mark Lishman on 12/09/2016.
 *
 * NOTE: If you create other "runners" that have new @AnnotationNames in and are to be run
 * you need to add the new @AnnotationNames in the list below or else the DriverManager.shutdown()
 * will not be called and then you can get Chrome Driver issues as run out of spawning memory.
 */
public class TestSupport {

    @Autowired DataSource dataSource;

    @Before
    public void before() {
       // Script that pre-populates DB items so a generic starting point, if required.
       // ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
       // populator.addScripts(new ClassPathResource("/test-data/member.sql"));
       // populator.execute(dataSource);
    }

    @After("@smokeTest")
    public void after() {
        DriverManager.shutdown();
    }

}