package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        glue = "steps",
        features = "classpath:features",
        plugin = {
                "com.github.kirlionik.cucumberallure.AllureReporter",
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        }
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
