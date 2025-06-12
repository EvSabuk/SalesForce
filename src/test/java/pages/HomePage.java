package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class HomePage extends BasePage {

    private static final By USER_ICON = By.cssSelector(".uiImage"),
            TITLE = By.xpath("//span[text()='Home']//ancestor::div[@class='overflow uiBlock']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage open() {
        log.info("Opening 'Home' page");
        driver.get(BASE_URL + "lightning/setup/SetupOneHome/home");
        return this;
    }

    @Override
    public HomePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(USER_ICON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page is not opened");
        }
        return this;
    }

    public String getTitle() {
        log.info("Get title for the 'Home' page");
        return driver.findElement(TITLE).getText();
    }

    public static By getTitleXpath() {
        log.info("Get xpath for the title for 'Home' page");
        return TITLE;
    }
}