package portfolio.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import portfolio.web.utilities.DriverManager;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(id = "tbodyid")
    private WebElement cartTable;

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr")
    private List<WebElement> cartRows;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement cardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement successPurchaseMessage;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okButton;

    public CartPage() {
        super(DriverManager.getDriver());
        PageFactory.initElements(driver, this);
    }

    public boolean isProductAddedToCart() {
        wait.until(ExpectedConditions.visibilityOf(cartTable));
        wait.until(ExpectedConditions.visibilityOfAllElements(cartRows));
        return !cartRows.isEmpty();
    }

    public void clickPlaceOrderButton() {
        clickElement(placeOrderButton);
    }

    public void inputOrderName(String name) {
        inputText(nameField, name);
    }

    public void inputCountry(String country) {
        inputText(countryField, country);
    }

    public void inputCity(String city) {
        inputText(cityField, city);
    }

    public void inputCard(String card) {
        inputText(cardField, card);
    }

    public void inputMonth(String month) {
        inputText(monthField, month);
    }

    public void inputYear(String year) {
        inputText(yearField, year);
    }

    public void clickPurchaseButton() {
        jsClickElement(purchaseButton);
    }

    public void completeOrderForm() {
        wait.until(ExpectedConditions.visibilityOf(nameField));

        inputOrderName("Hakiki");
        inputCountry("Indonesia");
        inputCity("Jakarta");
        inputCard("1234567890");
        inputMonth("12");
        inputYear("2026");

        clickPurchaseButton();
    }

    public boolean isPurchaseSuccessful() {
        wait.until(ExpectedConditions.visibilityOf(successPurchaseMessage));
        return successPurchaseMessage.isDisplayed();
    }

    public String getSuccessPurchaseMessage() {
        wait.until(ExpectedConditions.visibilityOf(successPurchaseMessage));
        return getElementText(successPurchaseMessage);
    }

    public void clickOkButton() {
        jsClickElement(okButton);
    }
}