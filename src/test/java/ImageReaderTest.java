

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import automation.ImageReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TesseractException;






public class ImageReaderTest {
        WebDriver driver;
    @BeforeMethod 
    public void startBrower(){
        //System.setProperty("webdriver.chrome.driver", "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/src/drivers/chromedriver");
        driver = new ChromeDriver(); 
        //System.out.println("Browser Started");
    }

    @Test
    public void test1() throws IOException, TesseractException { 
    	driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
    	String x_path1 = "//img[contains(@src, 'SUMMERSALEFPH')]";
    	String x_path2 = "//img[contains(@src, 'SUMMERFPH')]";
        ImageReader img = new ImageReader();
        img.SpiceJet(driver, x_path1, x_path2, 1);
    }
    @Test
    public void test2() throws Exception, TesseractException {
    	driver.get("https://sayingimages.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
    	WebElement image = driver.findElement(By.xpath("//img[contains(@alt, 'let go')]"));
        ImageReader img = new ImageReader();
        img.ScreenShot_OCR(image, "Saying");
    }
    

    @AfterMethod
    public void closeBrower(){
    	if (driver != null) {
            driver.quit();
        }
    }
}
