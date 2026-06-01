package portfolio.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import portfolio.web.utilities.DriverManager;

import java.util.List;

public class HomePage extends BasePage {

    private final String baseUrl = "https://www.demoblaze.com/";

    @FindBy(id = "tbodyid")
    private WebElement productListContainer;

    @FindBy(className = "hrefch")
    private List<WebElement> productItems;

    @FindBy(id = "cartur")
    private WebElement cartMenu;

    @FindBy(id = "signin2")
    private WebElement signUpMenu;

    @FindBy(id = "login2")
    private WebElement loginMenu;

    public HomePage() {
        super(DriverManager.getDriver());
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get(baseUrl);
    }

    public boolean isProductListDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(productListContainer));
        wait.until(ExpectedConditions.visibilityOfAllElements(productItems));
        return productListContainer.isDisplayed() && !productItems.isEmpty();
    }

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productItems));
        clickElement(productItems.get(0));
    }

    public void clickCartMenu() {
        clickElement(cartMenu);
    }

    public void clickSignUpMenu() {
        clickElement(signUpMenu);
    }

    public void clickLoginMenu() {
        clickElement(loginMenu);
    }
}