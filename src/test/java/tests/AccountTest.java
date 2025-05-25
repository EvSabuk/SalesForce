package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewAccountModal;
import static org.testng.Assert.assertEquals;

public class AccountTest extends BaseTest {

    @Test
    public void checkCreateAccount() {
        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password002!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.getTitleXpath()));
        newAccountModal.open();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccountModal.getTitleXpath()));
        newAccountModal.createAccount("TMS", "+374", "+375", "Hot");
        newAccountModal.clickSaveButton();
        assertEquals(accountListPage.getTitle(),
                "TMS",
                "Аккаунт не создан");
    }

    @Test
    public void checkCreateAccountFull() {
        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password002!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.getTitleXpath()));
        newAccountModal.open();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccountModal.getTitleXpath()));
        newAccountModal.createAccountFull("TMS", "+375445445", "+3754454450", "Hot",
                "3312", "www.site.com", "www.myaccount.com", "AAPL",
                "Prospect", "Private", "Banking", "420", "3123123123",
                "341124", "VIP Client", "TeachMeSkills", "My Street",
                "Minsk", "Soligorsk", "6000", "Belarus",
                "Your street", "Batumi", "Chakvi",
                "6002", "Georgia", "Low", "Gold",
                "28.05.2025", "SLA51234", "13", "No",
                "Yes", "My First correct test");
        newAccountModal.clickSaveButton();
        assertEquals(accountListPage.getTitle(),
                "TMS",
                "Аккаунт не создан");
    }
}