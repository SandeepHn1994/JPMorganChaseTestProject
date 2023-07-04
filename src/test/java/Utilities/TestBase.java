package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static Properties prop;
    public static WebDriver setUp() throws IOException {
        prop = new Properties();
        FileInputStream fs = new FileInputStream("D://JPMorganChaseProject//JPMorgan_NewsValidationTest//src//test//java//resources//config.properties");
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
}
