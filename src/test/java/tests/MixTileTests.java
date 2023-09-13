package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.MixTilesPhotoPage;
import utils.TestBase;
import utils.TestListener;

import java.util.UUID;

public class MixTileTests extends TestBase {

    @Test
    public void testFileUpload() throws Exception {
        driver.get("https://mixtiles.com/photos");
        Thread.sleep(3000);
        MixTilesPhotoPage mixTilesPhotoPage = new MixTilesPhotoPage(driver, webDriverWait);
        mixTilesPhotoPage.uploadPhoto();
        mixTilesPhotoPage.checkoutPage();
    }
}
