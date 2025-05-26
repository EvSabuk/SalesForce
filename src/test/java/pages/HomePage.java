package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private static final By TITLE = By.xpath(
            "//span[text()='Home']//ancestor::div[@class='overflow uiBlock']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public static By getTitleXpath() {
        return TITLE;
    }
}