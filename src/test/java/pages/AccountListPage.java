package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class AccountListPage extends BasePage {

    private static final By NEW_BUTTON = By.cssSelector("[title=New]");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage open() {
        log.info("Opening 'Account list' page");
        driver.get(BASE_URL + "lightning/o/Account/list?filterName=MyAccounts");
        return this;
    }

    @Override
    public AccountListPage isPageOpened() {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("The 'Account list' page is not opened");
        }
        return this;
    }

    public NewAccountModal clickNew() {
        log.info("Click on the 'New' button on the 'Account list' page");
        driver.findElement(NEW_BUTTON).click();
        return new NewAccountModal(driver).isPageOpened();
    }
}