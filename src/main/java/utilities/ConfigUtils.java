package utilities;

 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

 

public class ConfigUtils {
    
//    static String configPropertiesFilePath= System.getProperty("user.dir")+"/src/main/java/utilities/config.properties";
    static String configPropertiesFilePath= ".//src/main/java/utilities/config.properties";
    
    /**
     * This will return the value set against the propName in config.properties file
     * 
     * @param propName
     * @return value
     */
    public static String getConfigProperty(String propName) {
        
        Properties prop = new Properties();
        InputStream is;
        
        try {
            
            is = new FileInputStream(configPropertiesFilePath);
            prop.load(is);
            String propertyValue = prop.getProperty(propName);
            is.close();
            return propertyValue;
            
    }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
    }catch(IOException ioe){
            ioe.printStackTrace();    
    }
        
        return null;
        
    }
    
    /**
     * This function searches if system environment variable is present with variable name=browser.
     *  If no system variable is found, then it will search in config.properties file
     * 
     * @return browserName
     */
    public String getBrowserType() {
        
        String browser = System.getenv("browse");
        
        if(browser==null) {
            
            Properties prop = new Properties();
            InputStream is;
            
            try {
                
                is = new FileInputStream(configPropertiesFilePath);
                prop.load(is);
                browser = prop.getProperty("browser");
                is.close();
                return browser;
                
            }catch(FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            }catch(IOException ioe) {
                ioe.printStackTrace();
            }
            
        }
        return browser;
    }
    
    
    

 

}