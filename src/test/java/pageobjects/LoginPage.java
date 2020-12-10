package pageobjects;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
    //Locators
    
    @FindBy(xpath="//input[@name='username']") WebElement usNmLoc;
    @FindBy(xpath="//input[@name='password']") WebElement pswLoc;
    @FindBy(xpath="//input[@value='Log In']") WebElement loginLoc;
    
    
	//By usNmLoc = By.name("username");
    //By pswLoc = By.name("password");
    //By loginLoc = By.cssSelector("input[type='submit']");


    /**
     * Enters a valid username and password.
     */
    public void enterValidUsernameAndPassword() {
    	usNmLoc.sendKeys("testuser991199");
    	pswLoc.sendKeys("testuser991199");
    }

    public void clickLogin() {
    	loginLoc.click();
    }

    public String getAccountsOverviewTableTitle() {
        return driver.getTitle();
    }


}
