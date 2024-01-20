package mavenprj;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/main/java/mavenprj/features",
    glue = "stepdefinitions",
    plugin = {"pretty", "html:target/cucumber-reports"}
)

public class RunCucumberTests extends AbstractTestNGCucumberTests {
}
