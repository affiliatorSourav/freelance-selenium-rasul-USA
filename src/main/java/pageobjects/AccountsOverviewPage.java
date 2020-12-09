package pageobjects;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * In this class we will house all the locators and methods related
 * to Accounts Overview Page from our application.
 */
public class AccountsOverviewPage extends BasePage {

    private WebDriver driver;

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Locators
    By tblTitleLoc = By.cssSelector(".title");

    //Methods
    public String validateAccountsOverviewTblTitle() {
        String actualAcctsOverviewTblTitle = find(tblTitleLoc).getText();
        return actualAcctsOverviewTblTitle;
    }
}