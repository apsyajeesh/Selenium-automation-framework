package page.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public Amazon(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }
    public void searchItem(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Toys");
    }
}
