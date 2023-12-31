package page.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class ProductListingPage {

    WebDriver driver;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addItems(String[] itemsNeeded) {
        System.out.println("Adding items to the cart");
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                System.out.println("Added " + formattedName + " Item to the Cart");
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }

    public void addItemsToCart() {
        List<WebElement> add = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
        for (WebElement addCart : add) {
            if (addCart.getText().equalsIgnoreCase("Add")) {
                addCart.click();
            }
        }
        driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
    }
}
