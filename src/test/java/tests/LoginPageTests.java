package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import page.learn.LoginPage;
import utils.TestBase;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;

public class LoginPageTests extends TestBase {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        // Read data from the XML file and return it as a 2D array
        try {
            File xmlFile = new File("test-data/login-creds.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("test");
            Object[][] data = new Object[nodeList.getLength()][2];

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    data[i][0] = element.getElementsByTagName("username").item(0).getTextContent();
                    data[i][1] = element.getElementsByTagName("password").item(0).getTextContent();
                }
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test(dataProvider = "loginData", groups = "smoke")
    public void loginPractice(String username, String password) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        Thread.sleep(2000);
        LoginPage loginPage = new LoginPage(driver, webDriverWait);
        loginPage.login(username, password);
    }

    @Test
    public void testGoogle()  {
        WebDriver driver = new ChromeDriver();
        String testUrl = "https://www.google.com/finance";
        driver.get(testUrl);
        WebElement SearchTicker = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div[3]/div[3]/div/div/div/div[1]/input[2]"));
        SearchTicker.sendKeys("GOOGL");
        SearchTicker.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement previousClosingTickerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pFZ9G")));;
        String previousClosingPrice = previousClosingTickerElement.getText().split("\\$")[1].trim();
        System.out.println("Previous Closing Price: $" + previousClosingPrice);

    }

}
