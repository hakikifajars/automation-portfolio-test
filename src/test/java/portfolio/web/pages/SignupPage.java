package portfolio.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import portfolio.web.utilities.DriverManager;

public class SignupPage extends BasePage {

    @FindBy(id = "signin2")
    private WebElement signUpMenu;

    @FindBy(id = "sign-username")
    private WebElement usernameField;

    @FindBy(id = "sign-password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUpButton;

    public SignupPage() {
        super(DriverManager.getDriver());
        PageFactory.initElements(driver, this);
    }

    public void clickSignUpMenu() {
        clickElement(signUpMenu);
    }

    public void inputUsername(String username) {
        inputText(usernameField, username);
    }

    public void inputPassword(String password) {
        inputText(passwordField, password);
    }

    public void clickSignUpButton() {
        clickElement(signUpButton);
    }

    public void signUpWithCredential(String username, String password) {
        clickSignUpMenu();
        inputUsername(username);
        inputPassword(password);
        clickSignUpButton();
    }

    public String getAlertText() {
        return getAlertTextAndAccept();
    }
}