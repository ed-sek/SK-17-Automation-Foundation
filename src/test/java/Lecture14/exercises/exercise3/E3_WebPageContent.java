package Lecture14.exercises.exercise3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class E3_WebPageContent {

    @DataProvider(name = "testDataPageElements")
    public Object[][] createDataPageElements() {
        return new Object[][]{
                {"Homepage", "Hello user!", "@ 2025 Company",
                        "Homepage", "Hello user!", "@ 2025 Company"},

                {"Profile Page", "Edit your info", "Terms & Conditions",
                        "Profile Page", "Edit your info", "Terms & Conditions"}

        };
    }


    @Test(dataProvider = "testDataPageElements")
    public void verifyWebPageElements(String pageTitleActual, String headerActual, String footerActual,
                                      String pageTitleExpected, String headerExpected, String footerExpected) {

        SoftAssert softAssert = new SoftAssert();

        // testing the page title
        softAssert.assertEquals(pageTitleActual, pageTitleExpected, "Failure: The actual page title does not match the expected page title.");

        // testing the header
        softAssert.assertEquals(headerActual, headerExpected, "Failure: The actual header does not match the expected header.");

        // testing the footer
        softAssert.assertEquals(footerActual, footerExpected, "Failure: The actual footer does not match the expected footer.");

        System.out.println("The verification test run of all elements is now completed.");

        softAssert.assertAll();
    }
}
