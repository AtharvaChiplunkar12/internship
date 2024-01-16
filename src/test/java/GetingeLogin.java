import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetingeLogin {
       WebDriver driver;
    @BeforeClass 
    public void startBrower(){
        System.setProperty("webdriver.chrome.driver", "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/src/drivers/chromedriver");
        driver = new ChromeDriver(); 
        System.out.println("Browser Started");
    }
    @Test
    public void PageLoader(){
        driver.get("https://www.getinge.com/int/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@id=\"onetrust-reject-all-handler\"]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Ok!')]")).click();
        Assert.assertEquals(driver.getTitle(), "Welcome to Getinge");
    }
    @Test(dependsOnMethods = "PageLoader")
    public void navigatetoLogin(){
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='/int/login/'][@title='Login'][text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='Card'][contains(@href, 'portal/account')]")).click();
    }
    /*
    @AfterClass
    public void closeBrower(){
        driver.quit();
    }
    */
}
