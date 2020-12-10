package utilities;

 

import java.util.NoSuchElementException;

 

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

 

import common.BrowserFactory;

 

public class WaitUtils extends BrowserFactory{
    
    private static WebDriverWait webdriverWait() {
        
        return new WebDriverWait(driver, 30);
        
    }
    
    public static void waitForElementPresent(WebElement elementToWaitFor) {
        
        try {
            
        webdriverWait().until(ExpectedConditions.visibilityOf(elementToWaitFor));
        
        }catch(Exception ex) {
            
            
            assertThat(ex)
            .withFailMessage("Element " + elementToWaitFor + " is not found")
            .isInstanceOf(NoSuchElementException.class);
            
        }
    }
    
    public static void waitForElementToBeClickable(WebElement elementToWaitFor) {
        
        try {
            
        webdriverWait().until(ExpectedConditions.elementToBeClickable(elementToWaitFor));
        
        }catch(Exception ex) {
            
            assertThat(ex)
                .withFailMessage("Element " + elementToWaitFor + " is not clickable")
                .isInstanceOf(ElementClickInterceptedException.class);
        }
    }
    
    /*public static void waitForTextPresent(WebElement textLocator, String text) {
        
        try {
            
          webdriverWait().until(ExpectedConditions.visibilityOf(textLocator));
          webdriverWait().until((waitFor) -> text.equals(textLocator.getText()));
        
        }catch(Exception ex) {
             assertThat(ex)
             .withFailMessage("Text " + text + " is not found at element " + textLocator)
             .isInstanceOf(NotFoundException.class);
        }
    }*/
    
    

 

}