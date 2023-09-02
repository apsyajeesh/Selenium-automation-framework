package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    By addToCartButton = By.cssSelector("img[alt='Cart']");
    By proceedToCheckoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoCodeTextBox = By.cssSelector("input[class='promoCode']");
    By promoCodeSubmitButton = By.cssSelector("button[class='promoBtn']");

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyPromoCode() {
        System.out.println("Applying promo code");
        driver.findElement(addToCartButton).click();
        driver.findElement(proceedToCheckoutButton).click();
        driver.findElement(promoCodeTextBox).sendKeys("rahulshettyacademy");
        driver.findElement(promoCodeSubmitButton).click();
        Duration timeout = Duration.ofSeconds(5);
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(promoCodeSubmitButton));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText() + " promo code applied succesfully");
    }

    public void placeOrder() {
        System.out.println("Placing and order");
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
        System.out.println("Order Placed successfully");
    }
}
