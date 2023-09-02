package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CartPage;
import page.ProductListingPage;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class ShoppingCartTests extends TestBase{

    @Test
    public void checkoutTestWithPromoCode() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        ProductListingPage productListingPage = new ProductListingPage();
        productListingPage.addItems(driver, itemsNeeded);

        CartPage cartPage = new CartPage(driver);
        cartPage.applyPromoCode();
        cartPage.placeOrder();
    }

    @Test
    public void checkoutTestWithOutPromoCode() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        ProductListingPage productListingPage = new ProductListingPage();
        productListingPage.addItems(driver, itemsNeeded);

        CartPage cartPage = new CartPage(driver);
        cartPage.applyPromoCode();
        cartPage.placeOrder();
    }

    @Test
    public void checkoutTestWithOutPromoCode1() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        ProductListingPage productListingPage = new ProductListingPage();
        productListingPage.addItems(driver, itemsNeeded);

        CartPage cartPage = new CartPage(driver);
        cartPage.applyPromoCode();
        cartPage.placeOrder();
    }
    @Test
    public void loginPractice() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        Duration timeout = Duration.ofSeconds(5);
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("learning");
        driver.findElement(By.cssSelector("input[value='user']")).click();
        // webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='user']")));
        Thread.sleep(2000);
        driver.findElement(By.id("okayBtn")).click();
        WebElement drop;
        drop = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select dropDown = new Select(drop);
        dropDown.selectByIndex(2);
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInBtn")));
        List<WebElement> add = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
        for (WebElement addCart : add) {
            if (addCart.getText().equalsIgnoreCase("Add")) {
                addCart.click();
            }
        }
        driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
    }
}
