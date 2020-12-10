package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.winium.DesktopOptions;
//import org.openqa.selenium.winium.WiniumDriver;
//import org.openqa.selenium.winium.WiniumDriverService;

 

import io.github.bonigarcia.wdm.WebDriverManager;
//import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import utilities.ConfigUtils;
import utilities.LogUtils;

public class BrowserFactory {
    
    public static WebDriver driver;
    //public static WiniumDriver winDriver;
    //public static WiniumDriverService service;
    static ConfigUtils configUtils = new ConfigUtils();
    static String desktopApplicationPath;
    public static final String sauceUsername = "V";
    public static final String sauceAccessKey = "B";
    
    public static void openBrowser(String browserType) throws MalformedURLException {
        
        switch(browserType.toLowerCase()) {
            
            case "chrome":
                //System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); //
                System.setProperty("webdriver.chrome.silentOutput","true");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
                
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
                
            case "saucechrome":

 

                ChromeOptions options = new ChromeOptions();
                //DesiredCapabilities options = DesiredCapabilities.chrome();
                options.setCapability("platform", "Windows 10");
                options.setCapability("version", "65");
                //options.setCapability("maxDuration", 10800);
                //options.setCapability("sauceUsername", "y");
                //options.setCapability("sauceAccessKey", "z");
                options.setCapability("name", "X");
                //options.setCapability("tunnelIdentifier", "X_Tunnel");
                //options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                //options.setCapability(ChromeOptions.CAPABILITY, options);
                options.setCapability("extendedDebugging","true");
                //driver = new RemoteWebDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub"),options);
                
                driver = new RemoteWebDriver(new URL("https://"+ sauceUsername +":"+ sauceAccessKey +"@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),options);
                //driver = new RemoteWebDriver(new URL("https://AWG:a9d03573-22c8-4c40-b14c-21e595a2d4c0@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),options);
                break;
                
            
            default:
                System.out.println("Please give a valid browser name");
                break;
        }
        
    }
    
    
    
    /**
     *Launches Browser
     *maximise the browser
     *wait for 5 seconds implicitly
     * @return WebDriver
     * @throws InterruptedException 
     */
    public static WebDriver createWebDriver()  {
        try {
        
                    
            BrowserFactory.destroyDriver();
            Thread.sleep(1000);
        
        
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        try {
            
        LogUtils.INFO("Creating driver instance");
        openBrowser(configUtils.getBrowserType());
        LogUtils.INFO("driver instance has been successfully created");
        
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        return driver;
    }
    
        
    /**
     * driver.quit();
        driver=null;
     */
    public static void destroyDriver() {
        
        if(driver!=null) {
        
            driver.quit();
            driver=null;
        
        }
        /*
        if(winDriver!=null) {
            try {
            
                winDriver.quit();
                service.stop();
                
                Runtime.getRuntime().exec("taskkill /F /IM Winium.Desktop.Driver.exe /t");
                winDriver=null;
                
            } catch (Exception e) {
                
                LogUtils.INFO("Exception recorded in quiting winium driver");
            }
        }*/
        
        System.gc();
    }
    
    public static String openCamsApplication(String ApplicationName) {
        
        switch(ApplicationName.toLowerCase()) {
        
        case "calc":
            desktopApplicationPath=ConfigUtils.getConfigProperty("AppPath");
            break;
        
        case "allocation":
            desktopApplicationPath=ConfigUtils.getConfigProperty("CAMS_AllocationPath");
            break;
                    
        default:
            LogUtils.INFO("Application not found. Please check application name or path.");
            return null;
            
            
        }
        
        return desktopApplicationPath;
    }
    /*
    public static WiniumDriver createDesktopDriver(String applicationName) throws Exception {
        
                
            destroyDriver();

 

//            Runtime.getRuntime().exec(ConfigUtils.getConfigProperty("WiniumDriverPath")+" --port 8080");
            DesktopOptions options = new DesktopOptions();
            options.setApplicationPath(openCamsApplication(applicationName));
            
            File driverPath = new File(ConfigUtils.getConfigProperty("WiniumDriverPath")); //+" --port 4545"
            
            service = new WiniumDriverService.Builder()
                                                .usingDriverExecutable(driverPath)
                                                .usingPort(9999)
                                                .withVerbose(true)
                                                .withSilent(false)
                                                .buildDesktopService();
            
            service.start();
            
            winDriver = new WiniumDriver(service, options);
            
            
            
//            driver = new WiniumDriver(new URL(ConfigUtils.getConfigProperty("WiniumPortURL")), options);
            
            
            return winDriver;
    }*/
    
}