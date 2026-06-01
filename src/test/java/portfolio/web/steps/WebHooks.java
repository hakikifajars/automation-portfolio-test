package portfolio.web.steps;

import io.cucumber.java.After;
import portfolio.web.utilities.DriverManager;

public class WebHooks {

    @After("@web")
    public void tearDownWebScenario() {
        DriverManager.quitDriver();
    }
}