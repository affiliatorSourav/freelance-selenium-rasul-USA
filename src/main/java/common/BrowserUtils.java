package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    private WebDriver driver;
    private final int TIMEOUT = 10;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Waits until a WebElement is visible on the web page and then returns it.
     * @param locator = By locator
     * @return WebElement
     */
    public WebElement find(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    /**
     * Waits until a WebElement is clickable and then returns it.
     * @param locator = By locator
     * @return WebElement
     */
    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
