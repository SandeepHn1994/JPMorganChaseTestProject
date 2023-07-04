package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Alerts']/..")
    private WebElement alertButton;

    @FindBy(xpath = "//div[@class=\"main-header\" and text()='Alerts']")
    private WebElement alertPageverify;

    @FindBy(xpath = "//h5[contains(text(),'Frame')]")
    private WebElement frameButton;


}
