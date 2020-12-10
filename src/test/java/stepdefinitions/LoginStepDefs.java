package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
//import org.openqa.selenium.WebDriver;

import pageobjects.BasePage;
import pageobjects.LoginPage;
import utilities.ConfigUtils;

/**
 * In Stepdefinitions class we will use assertions and call
 * other methods from PageObject classes to do our validations.
 */
public class LoginStepDefs extends BasePage {

	LoginPage loginPage = new LoginPage();
    

    @Given("I am on Parabank application login page")
    public void i_am_on_parabank_application_login_page() throws Exception {
        //driver.get("https://parabank.parasoft.com/parabank/index.htm");
    	driver.get(ConfigUtils.getConfigProperty("ApplicationUrl"));
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() throws Exception {
    	loginPage.enterValidUsernameAndPassword();

    }

    @And("I click on LOG IN button")
    public void i_click_on_log_in_button() throws Exception {
        loginPage.clickLogin();
    }

    @Then("I validate I am logged in")
    public void i_validate_i_am_logged_in() throws Exception {
        String actualAcctsOverViewTitle = loginPage.getAccountsOverviewTableTitle();
        Assert.assertEquals("ParaBank | Accounts Overview", actualAcctsOverViewTitle);
    }


}
