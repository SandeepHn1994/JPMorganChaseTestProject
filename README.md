# JPMorganChaseTestProject

Project Title:
Test Automation Project for NewsValidationSite

Introduction:
Building an automation test solution for a news validation site to prevent fake news using the BDD  approach.

Features:
List the main features and capabilities of the framework, such as:

Support for BDD testing using a specific tool (BDD -Cucumber).
Integration with Selenium WebDriver for browser automation.
Easy-to-use test scenarios written in a human-readable language (Gherkin syntax).
Reporting capabilities through cucumber provided - reporting i.e. pretty HTML test report for test results.

Prerequisites:
Java Development Kit (JDK) installed.
Maven build tool installed.
Selenium WebDriver dependencies and drivers configured.

Getting Started:
1. Ensure all the dependency mentioned in the POM file is successfully
2. Ensure the cucumber plugin is added from the IDE configuration
3. Run tests from the test runner file
4. Test runner provided tags feature to select appropriate test with tags given on feature file
Folder Structure:
Explain the recommended folder structure of the project, highlighting the key directories and their purposes.

Writing Test Scenarios:
User feature folder for adding any new feature test under src/main/java
User gherkin syntax Given, When, Then, And to write your next scenario

Project structure :
1. All the utility functions such as a Base class to initialize the browser, reusable selenium functions, and cross-browser are available in src/main
2. user Test base class to add any utilities or reusable selenium functions
3. PageObject folder is available in src/main - use this to add any new pages that are to be included for further testing and add all locators following the singleton create instance
4. User step definition folder in src/test to create any new test scenario for mapping your new test feature file.
5. Test Runner class is maintained under src/test - use this class to update tags, dry run, and monochrome features during test execution
6. Plugins are added in Pom to run any testng.xml from POM

