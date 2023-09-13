package tests;

import page.learn.CartPage;
import page.learn.ProductListingPage;
import org.testng.annotations.*;
import utils.TestBase;

public class ShoppingCartTests extends TestBase {

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
