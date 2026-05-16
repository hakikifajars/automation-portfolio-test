package portfolio.web.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import portfolio.web.pages.LoginPage;
import portfolio.web.pages.ProductPage;
import portfolio.web.utilities.DriverManager;

public class WebSteps {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Given("user opens SauceDemo login page")
    public void userOpensSauceDemoLoginPage() {
        loginPage.openLoginPage();
    }

    @When("user inputs username {string}")
    public void userInputsUsername(String username) {
        loginPage.inputUsername(username);
    }

    @When("user inputs password {string}")
    public void userInputsPassword(String password) {
        loginPage.inputPassword(password);
    }

    @When("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user should be redirected to product page")
    public void userShouldBeRedirectedToProductPage() {
        Assert.assertEquals("Products", productPage.getPageTitle());
    }

    @Then("user should see login error message")
    public void userShouldSeeLoginErrorMessage() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
    }

    @After("@web")
    public void tearDown() {
        DriverManager.closeDriver();
    }
}