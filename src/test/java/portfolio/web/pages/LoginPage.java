package portfolio.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import portfolio.web.utilities.DriverManager;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public LoginPage() {
        super(DriverManager.getDriver());
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username) {
        inputText(usernameField, username);
    }

    public void inputPassword(String password) {
        inputText(passwordField, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public String getErrorMessage() {
        return getElementText(errorMessage);
    }
}