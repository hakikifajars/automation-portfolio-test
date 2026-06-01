package portfolio.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import portfolio.web.utilities.DriverManager;

public class LoginPage extends BasePage {

    @FindBy(id = "login2")
    private WebElement loginMenu;

    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(id = "nameofuser")
    private WebElement nameOfUser;

    public LoginPage() {
        super(DriverManager.getDriver());
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void clickLoginMenu() {
        clickElement(loginMenu);
        wait.until(ExpectedConditions.visibilityOf(usernameField));
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

    public void loginWithCredential(String username, String password) {
        clickLoginMenu();
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }

    public String getLoggedInUsername() {
        wait.until(ExpectedConditions.visibilityOf(nameOfUser));
        return getElementText(nameOfUser);
    }

    public String getAlertText() {
        return getAlertTextAndAccept();
    }
}