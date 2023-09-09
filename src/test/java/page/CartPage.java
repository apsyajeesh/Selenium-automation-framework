package page;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    @FindBy(css = "img[alt='Cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
    WebElement proceedToCheckoutButton;
    @FindBy(css = "input[class='promoCode']")
    WebElement promoCodeTextBox;
    @FindBy(css = "button[class='promoBtn']")
    WebElement promoCodeSubmitButton;

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void applyPromoCode() {
        System.out.println("Applying promo code");
        addToCartButton.click();
        proceedToCheckoutButton.click();
        promoCodeTextBox.sendKeys("rahulshettyacademy");
        promoCodeSubmitButton.click();
        Duration timeout = Duration.ofSeconds(5);
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        webDriverWait.until(ExpectedConditions.visibilityOf(promoCodeSubmitButton));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText() + " promo code applied succesfully");
    }

    public void placeOrder() {
        System.out.println("Placing and order");
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
        System.out.println("Order Placed successfully");
    }
}
