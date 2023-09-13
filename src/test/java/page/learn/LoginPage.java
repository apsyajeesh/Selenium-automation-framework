package page.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    By usernameTextBox=By.cssSelector("input[name='username']");
    By passwordTextBox=By.cssSelector("input[name='password']");
    By userRoleRadioButton=By.cssSelector("input[value='user']");
    By OkayButton=By.id("okayBtn");
    By roleSelectDropDown=By.cssSelector("select[class='form-control']");
    WebDriver driver;
    WebDriverWait webDriverWait;
    public LoginPage(WebDriver driver,WebDriverWait webDriverWait){
        this.driver=driver;
        this.webDriverWait=webDriverWait;
    }

    public void login(String username,String password) throws InterruptedException {
        driver.findElement(usernameTextBox).sendKeys(username);
        driver.findElement(passwordTextBox).sendKeys(password);
        driver.findElement(userRoleRadioButton).click();
        Thread.sleep(2000);
        driver.findElement(OkayButton).click();
    }

    public void selectTerms(){
        WebElement drop;
        drop = driver.findElement(roleSelectDropDown);
        Select dropDown = new Select(drop);
        dropDown.selectByIndex(2);
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }
}
