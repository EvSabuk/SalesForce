package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final By USER_ICON = By.cssSelector(".uiImage"),
            TITLE = By.xpath("//span[text()='Home']//ancestor::div[@class='overflow uiBlock']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage open() {
        driver.get(BASE_URL + "lightning/setup/SetupOneHome/home");
        return this;
    }

    @Override
    public HomePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_ICON));
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public static By getTitleXpath() {
        return TITLE;
    }
}