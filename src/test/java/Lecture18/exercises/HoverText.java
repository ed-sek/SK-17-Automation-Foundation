package Lecture18.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class HoverText {

    private WebDriver webDriver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.webDriver = new ChromeDriver();
        //this.webDriver = new EdgeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    protected final void tearDownTest() {
        if (this.webDriver != null) {
            this.webDriver.quit();
        }
    }

    @Test
    public void testMouseHover() throws InterruptedException {
        this.webDriver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement buttonWithHover = this.webDriver.findElement(By.xpath("//*[@class='dropbtn'][text()='Hover Over Me Second!']"));

        Actions actions = new Actions(this.webDriver);

        actions.moveToElement(buttonWithHover).perform();
        // Thread.sleep(5000);

        // [Assignment]: Check how to get the visible text under

        WebDriverWait dropDownContentWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));

        // Optimized (shorter) solution below
        WebElement dropDownContent = dropDownContentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"div-hover\"]/div[2]/div/a")));

        /* Initial long form below, with two separate calls
        dropDownContentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"div-hover\"]/div[2]/div/a")));
        WebElement dropDownContent = this.webDriver.findElement(By.xpath("//*[@id=\"div-hover\"]/div[2]/div/a"));
         */

        String actualDropDownText = dropDownContent.getText();
        System.out.println("The dropdown text is: " + actualDropDownText);


        // Assertion below
        String expectedDropDownText = "Link 1";
        Assert.assertEquals(actualDropDownText, expectedDropDownText, "[ERROR]: Dropdown text mismatch between actual and expected.");
    }
}
