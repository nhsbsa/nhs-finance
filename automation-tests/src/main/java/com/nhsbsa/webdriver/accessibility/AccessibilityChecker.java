package com.nhsbsa.webdriver.accessibility;

import com.nhsbsa.webdriver.DriverManager;
import com.nhsbsa.webdriver.NavigationManager;
import junit.framework.Assert;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by MattHood on 07/10/2016.
 */
public class AccessibilityChecker {

    private AccessibilityChecker() {
        throw new IllegalAccessError("Utility class");
    }

    public static void checkAccessibility(String webPage) {
//        final Logger logger = LoggerFactory.getLogger(AccessibilityChecker.class);
//
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(ResultSet.class);
            final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            final URL url = new URL(NavigationManager.ACHECKER_WEBSITE + "?&uri="  + webPage + "&id=" + NavigationManager.ACHECKER_ID + "&output=" + NavigationManager.ACHECKER_OUTPUT + "&guide=" + NavigationManager.ACHECKER_GUIDE);
            final ResultSet resultSet = (ResultSet) jaxbUnmarshaller.unmarshal(url);
//            logger.info("########################################");
//            logger.info("Number of errors: " + resultSet.getSummary().getNumOfErrors());
//            logger.info("Number of likely errors: " + resultSet.getSummary().getNumOfLikelyProblems());
//            logger.info("Number of potential errors: " + resultSet.getSummary().getNumOfPotentialProblems());
//            logger.info("Current status: " + resultSet.getSummary().getStatus());
//            logger.info(NavigationManager.ACHECKER_WEBSITE + "?&uri="  + webPage + "&id=" + NavigationManager.ACHECKER_ID + "&output=html" + "&guide=" + NavigationManager.ACHECKER_GUIDE);
//            logger.info("########################################");

            Assert.assertEquals("Should be 0 fatal errors", 0, resultSet.getSummary().getNumOfErrors());

        } catch (JAXBException | MalformedURLException e) {
//            logger.info("AccessibilityChecker exception", e);
        }

        DriverManager.shutdown();
    }

}
