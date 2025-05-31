package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;
import steps.AccountStep;
import steps.LoginStep;
import utils.TestListener;

import java.time.Duration;
import java.util.HashMap;

import static utils.AllureUtils.takeScreenshot;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert;
    NewAccountModal newAccountModal;
    AccountListPage accountListPage;
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    LoginStep loginStep;
    AccountStep accountStep;
    String user = System.getProperty("user");
    String password = System.getProperty("password");

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true, description = "Открытие браузера")
    public WebDriver setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        context.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        newAccountModal = new NewAccountModal(driver);
        accountListPage = new AccountListPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        accountStep = new AccountStep(driver);
        loginStep = new LoginStep(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver;
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(driver);
        }
        driver.quit();
    }
}