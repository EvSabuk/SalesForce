package steps;

import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.NewAccountModal;

@Log4j2
public class AccountStep {

    WebDriver driver;
    NewAccountModal newAccountModal;

    public AccountStep(WebDriver driver) {
        this.driver = driver;
        newAccountModal = new NewAccountModal(driver);
    }

    public void createAccount(Account account) {
        log.info("Starting create account step: ");
        newAccountModal.open()
                .isPageOpened()
                .createAccount(account)
                .clickSaveButton();
    }
}