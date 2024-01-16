
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TessAPI1;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;






public class ImageReader {
        WebDriver driver;
    @BeforeClass 
    public void startBrower(){
        //System.setProperty("webdriver.chrome.driver", "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/src/drivers/chromedriver");
        //driver = new ChromeDriver(); 
        //System.out.println("Browser Started");
    }

    @Test
    public void OCR() throws IOException, TesseractException { 
        //driver.get("https://www.spicejet.com/");
       //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   
        //File image = driver.findElement(By.xpath("//img[@src='https://www.spicejet.com/public/v1.svg']")).getScreenshotAs(OutputType.FILE);
        //File filepath = new File("/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/image/OCR_check.png");
        //FileHandler.copy(image, filepath);
        //System.setProperty("jna.library.path", "/opt/homebrew/Cellar/tesseract/5.3.3");
        
        Tesseract1 imagetext = new Tesseract1();
        
        //System.out.println("Tesseract Version: " + TessAPI1.TessVersion());
        //System.out.println("Supported Languages: " + imagetext.getAvailableLanguages());

        //imagetext.setDatapath("/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/practice/tessdata");
        //imagetext.setTessVariable("TESSDATA_PREFIX", "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/practice/");

        //String str = imagetext.doOCR(new File("/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/image/spicejet-logo.png"));
        
    }

    @AfterClass
    public void closeBrower(){
        driver.quit();
    }
}
