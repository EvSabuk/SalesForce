package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountListPage extends BasePage {

    private static final By NEW_BUTTON = By.cssSelector("[title=New]");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage open() {
        driver.get(BASE_URL + "lightning/o/Account/list?filterName=MyAccounts");
        return this;
    }

    @Override
    public AccountListPage isPageOpened() {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        return this;
    }

    public NewAccountModal clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return new NewAccountModal(driver).isPageOpened();
    }
}