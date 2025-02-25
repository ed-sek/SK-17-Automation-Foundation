package Lecture16.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserCommandsPracticeEnhanced {

    @Test
    public void testNavigatingToAnotherPage() throws InterruptedException {
        // Start of reusable code block for
        // setting the browser and maximizing the window
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        // End of reusable code block

        webDriver.get("https://wikipedia.org");
        String pageTitle = webDriver.getTitle();
        System.out.println("The page title is: " + pageTitle);

        //Thread.sleep(3000);

        // refresh the page
        webDriver.navigate().refresh();

        //Thread.sleep(3000);

        webDriver.get("https://www.imdb.com/title/tt0133093/");
        String currentURL = webDriver.getCurrentUrl();
        System.out.println("The page URL is: " + currentURL);

        webDriver.quit();
    }

    @Test
    public void testUseNavigateToLaunch() throws InterruptedException {
        // Start of reusable code block for
        // setting the browser and maximizing the window
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        // End of reusable code block

        webDriver.navigate().to("https://www.youtube.com/");

        String pageTitle = webDriver.getTitle();
        System.out.println("The page title is: " + pageTitle);

        Thread.sleep(3000);

        webDriver.quit();
    }

    @Test
    public void tesFindingElementAndClicking() throws InterruptedException {
        // Start of reusable code block for
        // setting the browser and maximizing the window
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        // End of reusable code block

        webDriver.get("https://wikipedia.org");

        WebElement searchButton = webDriver.findElement(By.xpath("//button[@type='submit']"));

        Thread.sleep(2500);

        searchButton.click();

        Thread.sleep(2500);

        String pageTitle = webDriver.getTitle();
        String currentURL = webDriver.getCurrentUrl();

        System.out.println("The page title is: " + pageTitle);
        System.out.println("The current URL is: " + currentURL);

        webDriver.quit();
    }

    @Test
    public void testFindingElementAndSendingText() throws InterruptedException {
        // Start of reusable code block for
        // setting the browser and maximizing the window
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        // End of reusable code block

        webDriver.get("https://wikipedia.org");

        WebElement searchButton = webDriver.findElement(By.xpath("//button[@type='submit']"));
        WebElement inputField = webDriver.findElement(By.id("searchInput"));

        inputField.sendKeys("Champs-Élysées");
        searchButton.click();

        Thread.sleep(5000);

        String currentTitle = webDriver.getTitle();

        System.out.println("The page title is: " + currentTitle);

        webDriver.quit();

        /*
         * Debugging Process:
         * - Encountered ElementNotInteractableException while trying to interact with the input field.
         * - The issue was due to an improper locator for the input field.
         * - Experimented with explicit waits to ensure elements were ready before interaction.
         * - The corrected locators are now used below.
         *
         * Previously tested approach with waits:
         * WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
         * WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
         * WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-input")));
         */
    }

    @Test
    public void testGettingElementText() throws InterruptedException {
        // Start of reusable code block for
        // setting the browser and maximizing the window
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        // End of reusable code block

        webDriver.get("https://www.nba.com/");

        Thread.sleep(3000);

        // Finding the tracking popup's Accept button and clicking to agree
        WebElement trackingButtonAccept = webDriver.findElement(By.xpath("//button[text()='I Accept']"));
        trackingButtonAccept.click();

        WebElement leaguePassButton = webDriver.findElement(By.xpath("//span[text()='League Pass']"));
        System.out.println(leaguePassButton.getText());

        Thread.sleep(3000);

        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
