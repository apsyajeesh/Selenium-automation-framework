package tests;

import org.testng.annotations.Test;
import page.learn.Amazon;
import utils.TestBase;

public class AmazonTests extends TestBase {
    @Test
    public void productListPage() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(10);
        Amazon amazon = new Amazon(driver, webDriverWait);
        amazon.searchItem();

    }
}
