package portfolio.web.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import portfolio.web.pages.CartPage;
import portfolio.web.pages.HomePage;
import portfolio.web.pages.LoginPage;
import portfolio.web.pages.ProductPage;
import portfolio.web.pages.SignupPage;

public class DemoBlazeSteps {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final SignupPage signupPage = new SignupPage();
    private final ProductPage productPage = new ProductPage();
    private final CartPage cartPage = new CartPage();

    private String username;
    private final String password = "Password123";
    private String signUpAlertText;
    private String loginAlertText;
    private String addToCartAlertText;

    @Given("user opens DemoBlaze homepage")
    public void userOpensDemoBlazeHomepage() {
        homePage.openHomePage();
    }

    @Then("user should see product list")
    public void userShouldSeeProductList() {
        Assert.assertTrue("Product list should be displayed", homePage.isProductListDisplayed());
    }

    @When("user signs up with new username and password")
    public void userSignsUpWithNewUsernameAndPassword() {
        username = "demouser" + System.currentTimeMillis();
        signupPage.signUpWithCredential(username, password);
        signUpAlertText = signupPage.getAlertText();
    }

    @Then("sign up should be successful")
    public void signUpShouldBeSuccessful() {
        Assert.assertTrue(
                "Sign up alert should contain success message",
                signUpAlertText.contains("Sign up successful")
        );
    }

    @When("user logs in with valid credential")
    public void userLogsInWithValidCredential() {
        createNewUserForCurrentScenario();
        loginPage.loginWithCredential(username, password);
    }

    @Then("username should be displayed on homepage")
    public void usernameShouldBeDisplayedOnHomepage() {
        String loggedInUsername = loginPage.getLoggedInUsername();
        Assert.assertTrue(
                "Logged in username should be displayed",
                loggedInUsername.contains(username)
        );
    }

    @When("user logs in with invalid password")
    public void userLogsInWithInvalidPassword() {
        username = "invaliduser" + System.currentTimeMillis();
        loginPage.loginWithCredential(username, "WrongPassword123");
        loginAlertText = loginPage.getAlertText();
    }

    @Then("error alert should be displayed")
    public void errorAlertShouldBeDisplayed() {
        Assert.assertTrue(
                "Error alert should be displayed",
                loginAlertText.contains("User does not exist") || loginAlertText.contains("Wrong password")
        );
    }

    @When("user selects a product")
    public void userSelectsAProduct() {
        homePage.clickFirstProduct();
        Assert.assertTrue("Product detail should be displayed", productPage.isProductDetailDisplayed());
    }

    @When("user adds product to cart")
    public void userAddsProductToCart() {
        productPage.clickAddToCartButton();
        addToCartAlertText = productPage.getAlertText();
    }

    @Then("product should be added to cart")
    public void productShouldBeAddedToCart() {
        Assert.assertTrue(
                "Add to cart alert should be displayed",
                addToCartAlertText.contains("Product added")
        );

        homePage.clickCartMenu();
        Assert.assertTrue("Product should be added to cart", cartPage.isProductAddedToCart());
    }

    @When("user opens cart page")
    public void userOpensCartPage() {
        homePage.clickCartMenu();
        Assert.assertTrue("Product should be available in cart", cartPage.isProductAddedToCart());
    }

    @When("user places order with valid customer data")
    public void userPlacesOrderWithValidCustomerData() {
        cartPage.clickPlaceOrderButton();
        cartPage.completeOrderForm();
    }

    @Then("purchase should be successful")
    public void purchaseShouldBeSuccessful() {
        Assert.assertTrue("Purchase should be successful", cartPage.isPurchaseSuccessful());
        Assert.assertEquals("Thank you for your purchase!", cartPage.getSuccessPurchaseMessage());
        cartPage.clickOkButton();
    }

    private void createNewUserForCurrentScenario() {
        username = "demouser" + System.currentTimeMillis();

        homePage.openHomePage();
        signupPage.signUpWithCredential(username, password);
        signupPage.getAlertText();

        homePage.openHomePage();
    }
}