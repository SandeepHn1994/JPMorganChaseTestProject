Feature:  Validation of news articles from guardian site

  Background:
    Given user launches the browser
    When  enters the guardian news site website
    Then  user on the news validation site

  @Test
  Scenario: Verify the first news article from The Guardian
    Given  user navigate to guardian news site
    When   user extract the details of the first news article
    Then   user search for similar articles on Google
    And    user validate that at least two articles are found


#   Negative test validation scenario

#   Scenario: No similar articles found
#    Given user  lands on the news validation news site
#    When  user navigate to "https://www.theguardian.com/tone/news"
#    Then  user extract the details of the first news article
#    And   user search for similar articles on Google
#    Then  user validates that no articles are found on google source
#    And   user considers the first news article as invalid



