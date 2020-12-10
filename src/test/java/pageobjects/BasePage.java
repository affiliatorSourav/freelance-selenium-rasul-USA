package pageobjects;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.winium.WiniumDriver;

 

import stepdefinitions.BaseSteps;

 

public class BasePage {

 

    public BaseSteps baseSteps = new BaseSteps();
    public static WebDriver driver;
    //public static WiniumDriver winDriver;
    
    public BasePage() {
        PageFactory.initElements(driver, this);
    }
    
}