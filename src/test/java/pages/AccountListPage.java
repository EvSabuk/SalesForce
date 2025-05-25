package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountListPage extends BasePage {

    private static final By TITLE = By.xpath(
            "//lightning-formatted-text[@slot='primaryField']");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
}