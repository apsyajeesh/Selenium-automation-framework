package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

@Listeners({TestListener.class})
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

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
