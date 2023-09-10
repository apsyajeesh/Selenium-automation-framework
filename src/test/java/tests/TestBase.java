package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Duration timeout = Duration.ofSeconds(5);
        webDriverWait = new WebDriverWait(driver, timeout);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
