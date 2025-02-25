package Lecture18.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableInteraction {
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
    public void testTableSecondOption() {
        this.webDriver.get("https://webdriveruniversity.com/Data-Table/index.html");
        WebElement table = this.webDriver.findElement(By.xpath("//table[@class='table table-light traversal-table']"));

        WebElement headerRow = table.findElement(By.tagName("thead"));
        List<WebElement> headerElements = headerRow.findElements(By.tagName("th"));

        // [Assignment 1]: get the index of column "First"

        int columnFirstIndex = 0;
        for (int i = 0; i < headerElements.size(); i++) {
            WebElement checkedElement = headerElements.get(i);
            String checkedElementText = checkedElement.getText();
            if (checkedElementText.equals("First")) {
                columnFirstIndex = i;
                break;
            }
        }
        // Solution to assignment 1
        System.out.println("The index of column 'First' is: " + columnFirstIndex);

        // [Assignment 2]
        // get the first name of second row
        // locator for the name should have the td element and some indexes


        WebElement bodyRow = table.findElement(By.tagName("tbody"));

        List<WebElement> allRows = bodyRow.findElements(By.tagName("tr"));

        WebElement secondRow = allRows.get(1);

        // Finding all td elements in the second row and storing them
        List<WebElement> secondRowElements = secondRow.findElements(By.tagName("td"));

        // Adjusting the to correct index to account for missing th in td row
        int adjustedColumnIndex = columnFirstIndex - 1;

        // Filtering the td by the now correct index
        WebElement actualCellNameValue = secondRowElements.get(adjustedColumnIndex);

        // Solution to Assignment 2
        System.out.println("The second row's value for 'First name' is: " + actualCellNameValue.getText());

        String expectedCellNameValue = "Jacob";
        Assert.assertEquals(actualCellNameValue.getText(), expectedCellNameValue, "[Error] Cell text value mismatch between actual and expected.");


        // Leaving below as it was part of the original code provided; not used in my solution
        // List<WebElement> headerElementsOfBodyRows = bodyRow.findElements(By.tagName("th"));
    }
}


