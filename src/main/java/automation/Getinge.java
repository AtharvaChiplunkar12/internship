package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Getinge {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.setProperty("webdriver.chrome.driver", "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/src/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.getinge.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//button[@id=\"onetrust-reject-all-handler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"eventlist-22316\"]/button[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"eventlist-22316\"]/div/div/div[6]/div/div/a")));
        element.click();
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"slick-slide-control11\"]")).click();
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"slick-slide10\"]/div/div/div/div/div[1]/div/a")));
        element2.click();
        Thread.sleep(1000);
        driver.quit();
    }
}
