package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeSuite
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Duration timeout = Duration.ofSeconds(5);
        webDriverWait = new WebDriverWait(driver, timeout);
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}
