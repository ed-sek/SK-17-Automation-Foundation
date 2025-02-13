package Lecture14.exercises.exercise1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class E1_OrderProcessing {

    @Test
    public void testOrderStatusUpdate() {
        String actual = "Status: Under review";
        String expected = "Status: Shipped";

        Assert.assertEquals(actual, expected, "Failure: the actual status does not match the expected status.");
    }

    @Test
    public void testOrderTotalPriceCalculation() {
        int purchaseOne = 10;
        int purchaseTwo = 20;
        int purchaseThree = 30;

        int actualTotalSum = purchaseOne + purchaseTwo + purchaseThree;
        int expectedTotalSum = 70;

        Assert.assertEquals(actualTotalSum, expectedTotalSum, "Failure in calculation: the actual sum does not match the expected sum.");
    }
}
