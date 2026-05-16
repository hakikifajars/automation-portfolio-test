package portfolio.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void inputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected String getElementText(WebElement element) {
        return element.getText();
    }
}