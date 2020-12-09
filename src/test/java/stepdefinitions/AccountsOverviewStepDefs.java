package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.AccountsOverviewPage;

/**
 * In Stepdefinitions class we will use assertions and call
 * other methods from PageObject classes to do our validations.
 */
public class AccountsOverviewStepDefs {

    private WebDriver driver;
    private AccountsOverviewPage accountsOverviewPage;

    public AccountsOverviewStepDefs() {
        this.driver = Hooks.driver;
        this.accountsOverviewPage = new AccountsOverviewPage(driver);
    }


    @Then("I validate Accounts Overview table title")
    public void i_validate_accounts_overview_table_title() {
        String actualAcctsOverviewTblTitle = accountsOverviewPage.validateAccountsOverviewTblTitle();
        Assert.assertEquals("Accounts Overview", actualAcctsOverviewTblTitle);
    }



}
