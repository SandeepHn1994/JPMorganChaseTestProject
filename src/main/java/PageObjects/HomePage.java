package PageObjects;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private static HomePage homePage;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private HomePage() {}

    public static synchronized HomePage getInstance(WebDriver driver) {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    @FindBy(how = How.CSS, using = "[title ='Yes, I’m happy']")
    private static WebElement alertAcceptButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/section[1]/div/div/div[1]/ul/li[1]/div/div/a/text()")
    private static WebElement getLatestNewsHeadline;

    @FindBy(how = How.XPATH, using = "//*[@class='fc-date-headline']")
    private WebElement todaysDateObj;

    @FindBy(how = How.XPATH, using = "//*[@class='fc-item__title']//span[@class='js-headline-text'][1]")
    private WebElement headlIneObject;


    public void alert_Accept(WebDriver driver) {
        driver.switchTo().frame(driver.findElement(By.id("sp_message_iframe_801669")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(alertAcceptButton));
        alertAcceptButton.click();
    }

    public String getLatestnews(WebDriver driver) {
        String news = headlIneObject.getText();
        // driver.findElement(By.xpath("//*[@class='fc-item__title']//span[@class='js-headline-text'][1]")).getText();
        return news;
    }
}
