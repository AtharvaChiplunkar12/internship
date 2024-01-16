
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.google.gson.JsonParser;

public class Test1 {
    WebDriver driver;
    @BeforeClass
    public void startBrower(){
        System.setProperty("webdriver.chrome.driver", "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/src/drivers/chromedriver");
        driver = new ChromeDriver(); 
        System.out.println("Browser Started");
    }
    @Test
    public void PageLoader(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='username']")).isDisplayed());
    }
    @Test(dependsOnMethods = "PageLoader")
    public void Login(){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");;
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='profile picture'][starts-with(@class, 'oxd')]")).isDisplayed());
    }
    @Test(dependsOnMethods = "Login")
    public void Signout(){
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='username']")).isDisplayed());
    }
    @AfterClass
    public void closeBrower(){
        driver.quit();
    }
}