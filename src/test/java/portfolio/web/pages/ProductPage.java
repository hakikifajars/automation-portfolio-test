package portfolio.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import portfolio.web.utilities.DriverManager;

public class ProductPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    public ProductPage() {
        super(DriverManager.getDriver());
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return getElementText(pageTitle);
    }
}