package Lecture14.exercises.exercise3;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class E3_OrderProcessing {

    @DataProvider(name = "testDataStatuses")
    public Object[][] createDataStatuses() {
        return new Object[][]{
                {"Status: Confirmed", "Status: Handling"},
                {"Status: Out of Stock", "Status: Delayed"}
        };
    }


    @DataProvider(name = "testDataPriceCalculations")
    public Object[][] createPriceCalculations() {
        return new Object[][]{
                {45, 32},   // actualTotalSum = 45, expectedTotalSum = 32
                {12, 15}    // actualTotalSum = 12, expectedTotalSum = 15
        };
    }


    // This test ensures that order statuses change as expected based on sample test cases from the data provider
    @Test(dataProvider = "testDataStatuses")
    public void testOrderStatusUpdate(String actual, String expected) {
        Assert.assertEquals(actual, expected,
                "Failure: the actual status does not match the expected status.");
    }

    // This test checks that the total price calculation works correctly with sample input values from the data provider
    @Test(dataProvider = "testDataPriceCalculations")
    public void testOrderTotalPriceCalculation(int actualTotalSum, int expectedTotalSum) {
        Assert.assertEquals(actualTotalSum, expectedTotalSum,
                "Failure in calculation: the actual sum does not match the expected sum.");
    }
}
