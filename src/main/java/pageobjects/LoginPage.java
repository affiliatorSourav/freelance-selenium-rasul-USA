package pageobjects;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Locators

    By usNmLoc = By.name("username");
    By pswLoc = By.name("password");
    By loginLoc = By.cssSelector("input[type='submit']");


    /**
     * Enters a valid username and password.
     */
    public void enterValidUsernameAndPassword() {
        find(usNmLoc).sendKeys("testuser991199");
        find(pswLoc).sendKeys("testuser991199");
    }

    public void clickLogin() {
        click(loginLoc);
    }

    public String getAccountsOverviewTableTitle() {
        return driver.getTitle();
    }


}
