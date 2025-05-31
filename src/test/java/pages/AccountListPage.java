package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountListPage extends BasePage {

    private static final By TITLE = By.xpath(
            "//lightning-formatted-text[@slot='primaryField']");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account");
        return this;
    }

    @Override
    public AccountListPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title=New]")));
        return this;
    }

    public NewAccountModal clickNew() {
        driver.findElement(By.cssSelector("[title=New]")).click();
        return new NewAccountModal(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
}