package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CartPage;
import page.LoginPage;
import page.ProductListingPage;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class ShoppingCartTests extends TestBase{

    @Test(groups = "p0")
    public void checkoutTestWithPromoCode() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage.addItems(itemsNeeded);

        CartPage cartPage = new CartPage(driver);
        cartPage.applyPromoCode();
        cartPage.placeOrder();
    }
}
