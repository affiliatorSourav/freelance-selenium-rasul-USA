package common;

import org.openqa.selenium.WebDriver;

public class BasePage extends BrowserUtils {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
