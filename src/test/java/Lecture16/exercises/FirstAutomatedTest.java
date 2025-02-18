package Lecture16.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstAutomatedTest {

    @Test
    public void firstAutomatedTest() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();

        webDriver.get("http://training.skillo-bg.com:4200/posts/all");

        // used to kill the chrome driver process at the end
        webDriver.quit();
    }
}
