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

public class RadioButtons {

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
    private final void tearDownTest() {
        if (this.webDriver != null) {
            this.webDriver.close();
        }
    }

    @Test
    public void testRadioButton() {
        /*
        Green
        Blue
        Yellow
        Orange
        Purple
         */

        this.webDriver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement radioButton = this.webDriver.findElement(By.xpath("//*[@id='radio-buttons']/input[@value='green']"));

        Assert.assertFalse(radioButton.isSelected(), "The radio button Green is selected");
        radioButton.click();
        Assert.assertTrue(radioButton.isSelected(), "The radio button Green is not selected");

        // [Assignment]: Add validations for rest of the radio buttons are not selected

        // Collecting all elements in a WebElements list
        List<WebElement> radioButtons = this.webDriver.findElements(By.xpath("//form[@id='radio-buttons']/input"));

        // Looping through the elements checking if they're selected
        for (WebElement radio : radioButtons) {
            if (!radio.equals(radioButton)) { // ignoring the selected button
                // [DEBUG] System.out.println("Checking radio button: " + radio.getAttribute("value"));
                Assert.assertFalse(radio.isSelected(), "Error: A non-selected button is actually selected.");
            }
        }

    }
}
