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
 * Description : Scenario to validate the news article on guardian site is not fake while validating with Google/other source
 *        TC01 - Validate successful launching guardian site page
 *        TC02 - Validate  news articles on the page are displayed
 *        TC03 - Validate the first article news from guardian on Google search results are found
 *        TC04 - Validate at least 2 or more articles similar to news on guardian is found
 * Parameters : Driver instance , PageClass singleton instances
 * */

public class newsValidationTestSteps {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;
    private HomePage homePage;

    private TestBase testBase;

    private String news;

    @Given("user launches the browser")
    public void user_launches_the_browser() throws IOException {
        driver = TestBase.setUp();
    }


    @Given("user navigate to guardian news site")
    public void user_navigates_to_guardian_site() throws IOException {
        driver.get(TestBase.prop.getProperty("baseurl"));
        homePage = HomePage.getInstance(driver);
        homePage.alert_Accept(driver);
    }

    @When("user extract the details of the first news article")
    public void user_extract_the_details_of_the_first_news_article() {
        news = homePage.getLatestnews(driver);
    }

    @Then("user search for similar articles on Google")
    public void user_search_for_similar_articles_on_google() {
        driver.get(TestBase.prop.getProperty("googleurl"));
        googleSearchPage = GoogleSearchPage.getInstance(driver);
        googleSearchPage.alert_Accept(driver);
        googleSearchPage.searchSubjectOnGoogle(driver, news);
    }

    @Then("user validate that at least two articles are found")
    public void user_validate_that_at_least_two_articles_are_found() {
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
        Assert.assertTrue(searchResults.size() >= 2, "At least two articles should be found");
        Assert.assertTrue(foundNewsArticle, "News article not found on google source");
    }


    @Then("user on the news validation site")
    public void user_on_the_news_validation_site() {

    }

    @When("enters the guardian news site website")
    public void user_enters_guardian_news_site_website() {
        //driver.get(TestBase.prop.getProperty("baseurl"));
    }


    @After
    public void tearDown() {
        // Close the browser and release resources
        if (driver != null) {
            driver.quit();
        }
    }

}


