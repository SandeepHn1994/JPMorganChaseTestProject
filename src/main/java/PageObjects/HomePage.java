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
/*
 * Author      : hnsandeep94
 * Description : Singleton Guardian HomePageNews class to return single instance while passing driver object
 * */

public class HomePage {
    private WebDriver driver;
    private static HomePage homePage;
    private TestBase testBase;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private HomePage() {
    }

    public static synchronized HomePage getInstance(WebDriver driver) {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    @FindBy(how = How.CSS, using = "[title ='Yes, I’m happy']")
    private static WebElement alertAcceptButton;

    @FindBy(how = How.XPATH, using = "//*[@class='fc-slice-wrapper']//a[@data-link-name='article'][1]")
    private static WebElement getLatestNewsHeadline;

    @FindBy(how = How.XPATH, using = "//*[@class='fc-date-headline']")
    private WebElement todaysDateObj;
    @FindBy(how = How.ID, using = "sp_message_iframe_801669")
    private WebElement iframeObject;
    @FindBy(how = How.XPATH, using = "//*[@class='fc-item__title']//span[@class='js-headline-text'][1]")
    private WebElement headlIneObject;

    /*
     * Author : hnsandeep94
     * Description : checking if any iframesavailable and handles alert
     * */

    public void checkIfAlertIsPresentandclick(WebDriver driver) {
        int iframeCount = driver.findElements(By.id("sp_message_iframe_801669")).size();
        boolean isIframeAvailable = iframeCount > 0;
        if (isIframeAvailable) {
            switchToIframeAndAcceptAlert(driver);
        }
    }

    public void switchToIframeAndAcceptAlert(WebDriver driver) {
        TestBase.waitForIframe(driver, iframeObject);
        alertAcceptButton.click();
    }

    /*
     * Author : hnsandeep94
     * Description : function to get latestNews from guardian news page
     * */
    public String getLatestnews(WebDriver driver) {
        String news = headlIneObject.getText();
        return news;
    }
}
