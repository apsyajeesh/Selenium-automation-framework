package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext contextFinish) {
        System.out.println("onFinish method finished");

    }

    @Override
    public void onStart(ITestContext contextStart) {
        System.out.println("onStart method started");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Method failed with certain success percentage" + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed" + result.getName());
        WebDriver driver = ((TestBase) result.getInstance()).driver;
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("./screenshots/" + result.getName() + ".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Method skipped" + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Method started" + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed" + result.getName());

    }

}