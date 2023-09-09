package tests;

import org.openqa.selenium.By;
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
        driver.get("https://www.google.com/finance");
      WebElement element=driver.findElement(By.cssSelector("input.Ax4B8.ZAGvjd"));
       // Duration timeout = Duration.ofSeconds(30);
       // WebDriverWait wait = new WebDriverWait(driver, timeout);
       //wait.until(ExpectedConditions.elementToBeClickable(element));
        ((ChromeDriver) driver).executeScript("arguments[0].click();", element);

       element.sendKeys("helo");
       //// String price = driver.findElement(By.className("pFZ9G")).getText();
      //  String  previousPrice=price.split("\\$")[1].trim();
       // System.out.println("Previous Closing price:$"+previousPrice);

    }

}
