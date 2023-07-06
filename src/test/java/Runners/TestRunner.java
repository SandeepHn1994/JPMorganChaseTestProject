package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src//test//java//Features"},
        glue = {"StepDef"},
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-reports" },
        tags = "@Test")
public class TestRunner extends AbstractTestNGCucumberTests {
}
