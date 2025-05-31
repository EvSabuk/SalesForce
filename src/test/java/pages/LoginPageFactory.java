package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage{

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "username")
    private WebElement userNameField;

    @FindBy (id = "password")
    private WebElement passwordField;

    @FindBy (id = "Login")
    private WebElement loginButton;

    public void open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/");
    }

    public void login(String user, String password) {
        userNameField.sendKeys(user);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
