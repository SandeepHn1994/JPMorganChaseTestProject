Feature:  Validation site functionality

  Background:
    Given user launches the browser
    When  user navigates to guardian site
    Then  user on the news validation site

  @Test
  Scenario: Validate the first news article from The Guardian
    Given user on the news validation site
    When  user navigate to "https://www.theguardian.com/tone/news"
    Then  user extract the details of the first news article
    And   user search for similar articles on Google
    Then  user validate that at least two articles are found
    And   user confirm that the first news article is valid

#   Negative test validation

#   Scenario: No similar articles found
#    Given user  lands on the news validation news site
#    When  user navigate to "https://www.theguardian.com/tone/news"
#    Then  user extract the details of the first news article
#    And   user search for similar articles on Google
#    Then  user validates that no articles are found on google source
#    And   user considers the first news article as invalid



