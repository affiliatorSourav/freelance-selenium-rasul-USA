package stepdefinitions;

 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

 


import static common.BrowserFactory.driver;
//import static base.BrowserFactory.winDriver;

 

import java.awt.Robot;
import java.awt.event.KeyEvent;

 

public class BaseSteps {
    
    
    public boolean isElementPresent(WebElement element)
    {
        try {
        element.getAttribute("");
        return true;
        }
        
        catch(Exception e)
        {
            return false;
        }
    }
    
    
    
    public boolean isElementPresent(String xpath)
    {
        try {
        driver.findElement(By.xpath(xpath));
        return true;
        }
        
        catch(Exception e)
        {
            return false;
        }
    }

 

    public void selectFromDropdownUsingVisibleText(WebElement elementOfDropdown, String visibleText) {
        
        Select select = new Select(elementOfDropdown);
        select.selectByVisibleText(visibleText);
    }
    

 


    public void setValue(WebElement element, String value) throws InterruptedException
    {
        if(!value.trim().equalsIgnoreCase("<ignore>") && !value.trim().equals(""))
        {
            int lenght= element.getAttribute("value").length();
            
            if(lenght>0)
            {    
                element.sendKeys(Keys.END);
                
                
                for(int i=1;i<=lenght;i++)
                {
                    
                    element.sendKeys(Keys.BACK_SPACE);
        
                }
            }
            
            element.sendKeys(value);
        }
    }
    
    /*
    public void doubleClickUsingwinDriver(WebElement element) {
        
        
        Actions action = new Actions(winDriver) ;
        
        action.moveToElement(element).build().perform();
        action.doubleClick(element).build().perform();

 

 


    }*/
    
    public void rbSendKeys(Robot robot, String keys) {
        for (char c : keys.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException(
                    "Key code not found for character '" + c + "'");
            }
            robot.keyPress(keyCode);
            robot.delay(100);
            robot.keyRelease(keyCode);
            robot.delay(100);
        }
    }

 

    public void selectElementUsingValue(WebElement selectElement, String value) {
        
        Select select = new Select(selectElement);
        select.deselectAll();
        select.selectByValue(value);
    }

 


}