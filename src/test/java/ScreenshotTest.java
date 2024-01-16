
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.AShot;

public class ScreenshotTest {
    WebDriver driver;
    @BeforeClass
    public void startBrower(){
        System.setProperty("webdriver.chrome.driver", "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/src/drivers/chromedriver");
        driver = new ChromeDriver(); 
        System.out.println("Browser Started");
    }
    @Test
    public void PageLoader(){
        driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Assert.assertEquals(driver.getTitle(), "Welcome to Getinge");
    }

    @Test(dependsOnMethods = "PageLoader")
    public void takeascreenshot() throws IOException {    
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //WebElement logoImgElement = driver.findElement(By.xpath("(//div[@role='img'][@class='Header-logoImage'])[2]"));
        WebElement logoImgElement = driver.findElement(By.xpath("//img[@src='https://www.spicejet.com/public/v1.svg']"));
        /*TakesScreenshot logoImage = (TakesScreenshot) logoImgElement;
        File image = logoImage.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(image, new File("/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/image/spicejet-logo.png"));
        */
        Screenshot cur = new AShot().takeScreenshot(driver, logoImgElement);
        ImageIO.write(cur.getImage(), "png", new File("/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/image/spicejet-logo.png"));
        System.out.println("Screenshot Taken");
    }

    @Test(dependsOnMethods = "takeascreenshot")
    public void compareSS() throws IOException{
        WebElement logoImgElement = driver.findElement(By.xpath("//img[@src='https://www.spicejet.com/public/v1.svg']"));
        Screenshot curr = new AShot().takeScreenshot(driver, logoImgElement);
        ImageDiffer imgDiffer = new ImageDiffer();
        ImageDiff diff = imgDiffer.makeDiff(ImageIO.read(new File("/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/image/spicejet-logo.png")), curr.getImage());
        if(diff.hasDiff()){
            System.out.println("Image not same");
        }else{
            System.out.println("Same Image");
        }
    }

    @AfterClass
    public void closeBrower(){
        driver.quit();
    }
}
