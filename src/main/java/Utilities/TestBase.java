package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


/*
 * Author : hnsandeep94
 * Updated date : 06-7-2023
 * Description : Factory class to create web driver instance , Add all reusable selenium functions here like waits , actions class, dropdown
 * */
public class TestBase {
    public static Properties prop;

    public static WebDriver setUp() throws IOException {
        prop = new Properties();
        FileInputStream fs = new FileInputStream(
                System.getProperty("user.dir") + "//src//main//java//resources//config.properties");
        prop.load(fs);
        WebDriver driver = null;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        switch (prop.getProperty("browser")) {
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            default:
                options.addArguments("incognito");
                options.setHeadless(false);
                driver = new ChromeDriver(options);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        return driver;
    }
    /*
     * Author : hnsandeep94
     * Parameters required : driver and webelement
     * Descriptions : Function to  explicitly wait for element
     * */

    public static void waitElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

   /*
   * Author : hnsandeep94
   * Parameters required : driver and webelement
   * Descriptions : Function to perform move to element
   * */
    public void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }

}
