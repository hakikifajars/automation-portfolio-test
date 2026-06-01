package portfolio.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import portfolio.web.utilities.DriverManager;

public class ProductPage extends BasePage {

    @FindBy(css = ".name")
    private WebElement productName;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;

    public ProductPage() {
        super(DriverManager.getDriver());
        PageFactory.initElements(driver, this);
    }

    public boolean isProductDetailDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(productName));
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        return productName.isDisplayed() && addToCartButton.isDisplayed();
    }

    public String getProductName() {
        wait.until(ExpectedConditions.visibilityOf(productName));
        return getElementText(productName);
    }

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        clickElement(addToCartButton);
    }

    public String getAlertText() {
        return getAlertTextAndAccept();
    }
}