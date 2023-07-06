package PageObjects;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/*
 * Author      : hnsandeep94
 * Description : Singleton pageclass to get instance if null whi;e passing driver object
 * */
public class GoogleSearchPage {
    private WebDriver driver;
    private TestBase testBase;
    private static GoogleSearchPage googleSearchPage;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private GoogleSearchPage() {
    }

    public static synchronized GoogleSearchPage getInstance(WebDriver driver) {
        if (googleSearchPage == null) {
            googleSearchPage = new GoogleSearchPage(driver);
        }
        return googleSearchPage;
    }

    @FindBy(how = How.ID, using = "L2AGLb")
    private WebElement acceptCookiesButton;

    @FindBy(how = How.CSS, using = "[title='Search']")
    private WebElement inputSearchButton;

    @FindBy(how = How.XPATH, using = "//*[@id='SIvCob']/a")
    private WebElement englishLangSelect;

    @FindBy(how = How.XPATH, using = "//*[@class='FPdoLc lJ9FBc']//input[@value='Google Search']")
    private WebElement googleSearchBtton;

    private List<WebElement> searchResults;

    public List<WebElement> getNewsSearcResults() {
        searchResults = driver.findElements(By.xpath("//*[@class='yuRUbf']/a"));
        return searchResults;
    }

    public void alert_Accept(WebDriver driver) {
        testBase.waitElement(driver, acceptCookiesButton);
        acceptCookiesButton.click();
    }

    public void searchSubjectOnGoogle(WebDriver driver, String topic) {
        testBase.waitElement(driver, englishLangSelect);
        englishLangSelect.click();
        testBase.waitElement(driver, inputSearchButton);
        inputSearchButton.clear();
        inputSearchButton.sendKeys(topic);
        testBase.waitElement(driver, googleSearchBtton);
        inputSearchButton.submit();

    }
}

