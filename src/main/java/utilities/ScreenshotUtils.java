package utilities;

 

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

 

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.aspects.AllureAttachAspects;*/

 

import static common.BrowserFactory.driver;
//import static base.BrowserFactory.winDriver;

 

public class ScreenshotUtils {
    
    public static String getSnapshotFolderPath() {
        
        String path = ConfigUtils.getConfigProperty("ScreenShotPath");
        return path;
    
    }
    
    public static String takeScreenShot() throws IOException {
        
        LogUtils.INFO("Taking snapshot");
        File srcFile;
        
        //if(driver!=null) {
        
            srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        //}else {
            
            //srcFile = ((TakesScreenshot)winDriver).getScreenshotAs(OutputType.FILE);
            
        //}
        
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();

 

        String snapshotFileName = "screenshot" + dateFormat.format(cal.getTime()) + ".png";
        String pathToSnapshot = getSnapshotFolderPath() + "/" + snapshotFileName;

 

        FileUtils.copyFile(srcFile, new File(pathToSnapshot));

 

        return snapshotFileName;

 

    }
    
    public static void attachSnapshotToReport() {
        
        Path content = null;
        
        String snapshotFileName = null;
        try {
            snapshotFileName = takeScreenShot();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        content = Paths.get(getSnapshotFolderPath() + "/" + snapshotFileName);
        try (InputStream is = Files.newInputStream(content)) {
            //Allure.addAttachment(snapshotFileName, is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
        
        
        
        
        
        
    }

 

