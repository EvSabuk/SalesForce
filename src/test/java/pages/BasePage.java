package pages;

import org.openqa.selenium.WebDriver;


public abstract class BasePage {

    WebDriver driver;

    public static final String BASE_URL = "https://tms9-dev-ed.develop.lightning.force.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}