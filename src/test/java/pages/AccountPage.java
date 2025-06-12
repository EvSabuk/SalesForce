package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class AccountPage extends BasePage {

    private static final By FOLLOW_BUTTON = By.cssSelector("[title='Follow']"),
            TITLE = By.xpath("//lightning-formatted-text[@slot='primaryField']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage open() {
        log.info("Opening 'Account list' page");
        return this;
    }

    @Override
    public AccountPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FOLLOW_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("The 'Account' page is not opened");
        }
        return this;
    }

    public String getTitle() {
        log.info("Get title for the 'Account' page");
        return driver.findElement(TITLE).getText();
    }
}