package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MixTilesPhotoPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MixTilesPhotoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void uploadPhoto() {
        driver.findElement(By.className("UploadButton")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("PickPhotosMenustyles__ButtonImage-sc-1c08lci-5"))).click();
        driver.findElement(By.cssSelector("[data-testid='choose-from-device-button']"))
                        .sendKeys("C:/Users/apsya/OneDrive/Pictures/Screenshots/TC - 01.22A.png");

    }
    public void checkoutPage(){
        driver.findElement(By.cssSelector("button[data-testid='photo-styler-cta-button']")).click();
        driver.findElement(By.cssSelector("div[data-testid='add-address-button-text']")).click();
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("apsyajeesh@gmail.com");
        //driver.findElement(By.id("Field-nameInput")).sendKeys("Apsy Prakash");
    }
}
