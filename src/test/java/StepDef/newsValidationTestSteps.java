package StepDef;

import PageObjects.GoogleSearchPage;
import PageObjects.HomePage;
import Utilities.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/*
 * Author : hnsandeep94
 * Descriptopm : Scenario to validate the news article on guardian site is not fake while comarin with google/other sorces
 * Parameters : Driver instance , PageClass singleton instances
 * */

public class newsValidationTestSteps {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;
    private HomePage homePage;

    private TestBase testBase;

    @Given("user launches the browser")
    public void user_launches_the_browser() throws IOException {
        driver = TestBase.setUp();
    }

    @When("user navigates to guardian site")
    public void user_navigates_to_guardian_site() throws IOException {
        driver.get(TestBase.prop.getProperty("baseurl"));
        homePage = HomePage.getInstance(driver);
        homePage.alert_Accept(driver);
    }

    @Then("user extract the details of the first news article")
    public void user_extract_the_details_of_the_first_news_article() {
        String news = homePage.getLatestnews(driver);
        driver.get(TestBase.prop.getProperty("googleurl"));
        googleSearchPage = GoogleSearchPage.getInstance(driver);
        googleSearchPage.alert_Accept(driver);
        googleSearchPage.searchSubjectOnGoogle(driver, news);
        boolean foundNewsArticle = false;
        List<WebElement> searchResults = googleSearchPage.getNewsSearcResults();
        for (WebElement searchResult : searchResults) {
            String newsArticleFromGoogle = searchResult.getText();
            String[] wordsInNews = news.split(" ");
            for (String word : wordsInNews) {
                if (newsArticleFromGoogle.contains(word)) {
                    searchResult.click();
                    foundNewsArticle = true;
                    break;
                }
            }
            if (foundNewsArticle) {
                break;
            }
        }
        Assert.assertTrue(foundNewsArticle, "News article not found on google source");
    }

    @Then("user on the news validation site")
    public void user_on_the_news_validation_site() {

    }

    @Then("user search for similar articles on Google")
    public void user_search_for_similar_articles_on_google() {

    }

    @Then("user validate that at least two articles are found")
    public void user_validate_that_at_least_two_articles_are_found() {
    }

    @Then("user confirm that the first news article is valid")
    public void user_confirm_that_the_first_news_article_is_valid() {
    }

    @When("user navigate to {string}")
    public void user_navigate_to(String string) {
    }

    @After
    public void tearDown() {
        // Close the browser and release resources
        if (driver != null) {
            driver.quit();
        }
    }

}


