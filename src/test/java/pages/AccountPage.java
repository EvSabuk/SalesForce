package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

    private static final By FOLLOW_BUTTON = By.cssSelector("[title='Follow']"),
            TITLE = By.xpath("//lightning-formatted-text[@slot='primaryField']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage open() {
        return this;
    }

    @Override
    public AccountPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FOLLOW_BUTTON));
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
}