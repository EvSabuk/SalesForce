package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;


public abstract class BasePage {

   public static final String BASE_URL = "https://tms9-dev-ed.develop.lightning.force.com/";
    WebDriver driver;
    WebDriverWait wait;

    public void isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> numberOfElements = driver.findElements(locator);
        assertEquals(numberOfElements.size(), 0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
    }

    public abstract BasePage open();

    public abstract BasePage isPageOpened();
}