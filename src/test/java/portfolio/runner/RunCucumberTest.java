package portfolio.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "portfolio.api.steps",
                "portfolio.web.steps"
        },
        plugin = {
                "pretty",
                "html:build/reports/cucumber/cucumber-report.html",
                "json:build/reports/cucumber/cucumber-report.json"
        },
        monochrome = true
)
public class RunCucumberTest {
}