package Lecture16.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserCommandsPractice {

    @Test
    public void testBrowserCommands() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();

        // Maximize the browser window
        webDriver.manage().window().maximize();

        // Open the URL into the browser
        webDriver.get("https://google.com");

        String pageTitle = webDriver.getTitle();
        System.out.println("The page title is: " + pageTitle);

        //Thread.sleep(2000);

        webDriver.get("https://www.nasa.gov/");
        String currentURL = webDriver.getCurrentUrl();
        System.out.println("The page URL is: " + currentURL);

        webDriver.close();
    }
}
