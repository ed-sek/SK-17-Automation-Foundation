package Lecture14.practice;

import org.testng.annotations.*;

public class AnnotationsPractice {

    // Runs before all tests in the suite.
    // Useful for setting global configs.
    @BeforeSuite
    public void myBeforeSuite() {
        System.out.println("Message [BeforeSuite]: This runs before all test methods in the suite.");
    }

    // Runs after all tests in the suite have run.
    // Useful for cleaning up global configs or resources.
    @AfterSuite
    public void myAfterSuite() {
        System.out.println("Message [AfterSuite]: This runs after all tests in the suite.");
    }

    // Runs once before all test methods in a <test> section of testng.xml.
    // If no XML file is used, it may not execute at all
    @BeforeTest
    public void myBeforeTest() {
        System.out.println("Message [BeforeTest]: This runs once before all test methods in the <test> section.");
    }

    // Runs once after all test methods in a <test> section of testng.xml.
    // If no XML file is used, it may not execute at all.
    @AfterTest
    public void myAfterTest() {
        System.out.println("Message [AfterTest]: This runs once after all test methods in the <test> section.");
    }

    // Runs before the first test method when the current class is invoked.
    // Useful for setting up configs specific to a single test class.
    @BeforeClass
    public void myBeforeClass() {
        System.out.println("Message [BeforeClass]: This runs before all test methods in this class.");
    }

    // Runs after all the tests in the current class have run.
    // Useful for cleaning up configs specific to a single test class.
    @AfterClass
    public void myAfterClass() {
        System.out.println("Message [AfterClass]: This runs after all test methods in this class.");
    }

    // Runs before each test method.
    // Useful for setting up configs that need to be reset before each test method.
    @BeforeMethod
    public void myBeforeMethod() {
        System.out.println("Message [BeforeMethod]: This runs before each test method in this class.");
    }

    // Runs after each test method.
    // Useful for cleaning up configs that need to be reset after each test method.
    @AfterMethod
    public void myAfterMethod() {
        System.out.println("Message [AfterMethod]: This runs after each test method in this class.");
    }

    @Test
    public void firstTest() {
        System.out.println("Message [FirstTest]: This is the first test.");
    }

    @Test
    public void secondTest() {
        System.out.println("Message [SecondTest]: This is the second test.");
    }
}
