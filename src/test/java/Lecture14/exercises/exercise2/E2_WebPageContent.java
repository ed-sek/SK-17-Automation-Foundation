package Lecture14.exercises.exercise2;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class E2_WebPageContent {

    @Test
    public void verifyWebPageElements() {
        SoftAssert softAssert = new SoftAssert();

        String pageTitleActual = "My Awsesome page";
        String headerActual = "Welcome!";
        String footerActual = "Contact details listed here";

        String pageTitleExpected = "My Awsesome page";
        String headerExpected = "Welcome!";
        String footerExpected = "Contact details listed here";

        // testing the page title
        softAssert.assertEquals(pageTitleActual, pageTitleExpected, "Failure: The actual page title does not match the expected page title.");

        // testing the header
        softAssert.assertEquals(headerActual, headerExpected, "Failure: The actual page title does not match the expected page title.");

        // testing the footer
        softAssert.assertEquals(footerActual, footerExpected, "Failure: The actual page title does not match the expected page title." );

        System.out.println("The verification of the web elements is now complete.");

        softAssert.assertAll();
    }


}
