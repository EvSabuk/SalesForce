package tests;

import dto.Account;
import dto.AccountFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewAccountModal;
import static org.testng.Assert.assertEquals;

public class AccountTest extends BaseTest {

    @Test
    public void checkCreateAccount() {
        Account account = AccountFactory.getAccount("Cold");
        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password002!");
        homePage.isPageOpened();
        newAccountModal.open();
        newAccountModal.isPageOpened();
        newAccountModal.createAccount(account);
        newAccountModal.clickSaveButton();
        assertEquals(accountPage.getTitle(),
                "TMS",
                "Аккаунт не создан");
    }

    @Test
    public void checkCreateAccountFull() {
        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password002!");
        homePage.isPageOpened();
        newAccountModal.open();
        newAccountModal.isPageOpened();
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
        assertEquals(accountPage.getTitle(),
                "TMS",
                "Аккаунт не создан");
    }

    @Test
    public void checkCreateAccountSteps() {
        Account account = AccountFactory.getAccount("Cold");
        loginStep.auth("tborodich@tms.sandbox", "Password002!");
        accountStep.createAccount(account);
        assertEquals(accountPage.getTitle(),
                "TMS",
                "Аккаунт не создан");
    }

    @Test
    public void checkCreateAccountChain() {
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password002!")
                .isPageOpened();
        accountListPage.open()
                .isPageOpened()
                .clickNew()
                .createAccountFull("TMS", "+375445445", "+3754454450", "Hot",
                        "3312", "www.site.com", "www.myaccount.com", "AAPL",
                        "Prospect", "Private", "Banking", "420", "3123123123",
                        "341124", "VIP Client", "TeachMeSkills", "My Street",
                        "Minsk", "Soligorsk", "6000", "Belarus",
                        "Your street", "Batumi", "Chakvi",
                        "6002", "Georgia", "Low", "Gold",
                        "28.05.2025", "SLA51234", "13", "No",
                        "Yes", "My First correct test").
                clickSaveButton();
        accountPage.isPageOpened();
        assertEquals(accountPage.getTitle(),
                "TMS",
                "Аккаунт не создан");
    }
}