package Lecture17.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsPractice {
    private WebDriver webDriver;

    @BeforeSuite
    protected final void setUpTestSuite() {
        // Prepare WebDrivers for Chrome, Firefox and Edge
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.webDriver = new ChromeDriver();
        // this.webDriver = new EdgeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    protected final void tearDownTest() {
        if (this.webDriver != null) {
            this.webDriver.quit();
        }
    }

    @Test
    public void testMyQuotesPageButton() {
        this.webDriver.get("https://www.nasdaq.com/");

        WebDriverWait explicitWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));

        this.webDriver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text()='My Quotes']"))).click();

        WebElement watchlistOpenActual = this.webDriver.findElement(By.xpath("//*[@class=\"watchlist__content\"]\n"));
        boolean isWatchlistOpen = watchlistOpenActual.isDisplayed();

        Assert.assertTrue(isWatchlistOpen, "The Watchlist panel is not displayed");
    }

}
