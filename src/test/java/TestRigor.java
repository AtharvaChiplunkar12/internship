import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testrigor.selfhealingselenium.v4.application.SelfHealingDriver;





public class TestRigor {
    SelfHealingDriver driver;
    //WebDriver driver;
    @BeforeClass 
    public void startBrower(){
        System.setProperty("webdriver.chrome.driver", "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/src/drivers/chromedriver");
        driver = com.testrigor.selfhealingselenium.v4.TestRigor.selfHeal(new ChromeDriver(), "a2518f3a-3e8b-484a-befe-23b9160ef166");
        //driver = new ChromeDriver();
        System.out.println("Browser Started");
    }
    @Test
    public void PageLoader(){
        driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(dependsOnMethods = "PageLoader")
    public void LoginPage() {    
            driver.findElement(By.xpath("//div[text()='Login']")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//input[contains(@data-testid, 'mobileno')]")).sendKeys("7506360475");;
            driver.findElement(By.xpath("//input[contains(@data-testid, 'password')]")).sendKeys("Pass@123");
            driver.findElement(By.xpath("//div[contains(@data-testid, 'login')]")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Atharva')]")).isDisplayed());
            checker();
            
     }
     @Test(dependsOnMethods = "LoginPage")
     public void flightsPage() {   
        driver.findElement(By.xpath("//div[contains(@data-testid,'flight status')]")).click();
        driver.findElement(By.xpath("(//input[contains(@class, 'css-1cwyjr8')])[1]")).sendKeys("Del");
        driver.findElement(By.xpath("(//input[contains(@class, 'css-1cwyjr8')])[2]")).sendKeys("Bom");
        driver.findElement(By.xpath("//div[@id='main-container']/div/div[1]/div[3]/div[2]/div[5]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        checker();
     }

     public void checker(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement ele = driver.findElement(By.xpath("//div[contains(text(), 'Atharva')]"));
        ele.click();
        //driver.findElement(By.xpath("//*[@id='main-container']/div/div[1]/div[2]/div[1]/div/div[3]/div[1]/div[2]/div[1]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'My Profile')]")).getText());
        //Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(), 'My Profile')]")).getText(), "My Profile");
     }

    @AfterClass
    public void closeBrower(){
        driver.quit();
        
    }
}
