package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;

import java.time.Duration;

public class LoginPageTests extends TestBase {

    @DataProvider
    private Object[][] userInfo() {
        return new Object[][]{
                {"rahulshettyaccademy", "Learning"},
                {"sdsd@sdsds", "dada"},
                {"3453534", "34534534"}
        };
    }

    @Test(dataProvider = "userInfo", groups = "smoke")
    public void loginPractice(String username, String password) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        Thread.sleep(2000);
        LoginPage loginPage = new LoginPage(driver, webDriverWait);
        loginPage.login(username, password);

    }

    @Test
    public void testGoogle()  {
        WebDriver driver = new ChromeDriver();
        String testUrl = "https://www.google.com/finance";
        driver.get(testUrl);
        WebElement SearchTicker = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div[3]/div[3]/div/div/div/div[1]/input[2]"));
        SearchTicker.sendKeys("GOOGL");
        SearchTicker.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement previousClosingTickerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pFZ9G")));;
        String previousClosingPrice = previousClosingTickerElement.getText().split("\\$")[1].trim();
        System.out.println("Previous Closing Price: $" + previousClosingPrice);

    }

}
