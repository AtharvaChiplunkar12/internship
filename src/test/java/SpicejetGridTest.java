import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SpicejetGridTest {
    WebDriver driver;
    @BeforeClass
    public void startBrower(){
        System.setProperty("webdriver.chrome.driver", "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/test-automation/internship/drivers/chromedriver");
        driver = new ChromeDriver(); 
        System.out.println("Browser Started");
    }
    @AfterClass
    public void closeBrower(){
        driver.quit();
        
    }

   @Test
   public void flight_input(){
        driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement origin = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div[2]/input"));
        WebElement destination = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div/div[2]/input"));
        WebElement radio_bt_one_way = driver.findElement(By.xpath("//div[@data-testid='one-way-radio-button']"));
        WebElement departure_date_input = driver.findElement(By.xpath("//div[contains(@data-testid,'departure-date')]"));
        origin.sendKeys("Del");
        destination.sendKeys("Bom");
        radio_bt_one_way.click();
        departure_date_input.click();
        WebElement date = driver.findElement(By.xpath("//div[contains(@data-testid,'March-2024')]/div[3]/div[1]/div[1]"));
        String month_end = "31";
        String selected_date = "12";
        int i = 1;
        outerloop:
        while(!date.getText().equals(month_end)){
            for(int j = 1; j <= 7; j++){
                String x_path =  "//div[contains(@data-testid,'March-2024')]/div[3]/div["+i+"]/div["+j+"]";
                date = driver.findElement(By.xpath(x_path));
                //System.out.println("Date "+date.getText()); 
                if(date.getText().equals(selected_date)){
                    break outerloop;
                }
            }
            i++;
        }
        date.click(); 
        WebElement passengers_box = driver.findElement(By.xpath("//div[contains(@data-testid,'travellers')]"));
        passengers_box.click();
        WebElement adult_no = driver.findElement(By.xpath("//div[contains(@data-testid,'travellers')]/following-sibling::div/div[2]/div/div/div[1]/div[2]/div[2]/div"));
        WebElement add = driver.findElement(By.xpath("//div[contains(@data-testid,'Adult-testID-plus')]"));
        String selected_no_adult = "3";
        while(!adult_no.getText().equals(selected_no_adult)){
            add.click();
        }  
        WebElement currency_box = driver.findElement(By.xpath("//*[@id='main-container']/div/div[1]/div[3]/div[2]/div[5]/div[2]/div"));
        currency_box.click();
        
        String currency_value = "USD";
        for(int j = 1; j <= 5; j++){
            String x_path = "//*[@id='main-container']/div/div[1]/div[3]/div[2]/div[5]/div[2]/div[2]/div[2]/div/div["+j+"]/div";
            WebElement currency = driver.findElement(By.xpath(x_path));
            if(currency.getText().equals(currency_value)){
                currency.click();
                break;
            } 
        }
        WebElement search_flight = driver.findElement(By.xpath("//div[contains(@data-testid,'flight-cta')]"));
        search_flight.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main-container']/div/div[1]/div[4]/div/div[1]/div/div[2]")));
        System.out.println(driver.getTitle());
   }

   @Test(dependsOnMethods = "flight_input")
   public void flight_details(){
        WebElement all_flight_info = driver.findElement(By.xpath("(//*[@id='list-results-section-0']/div[5])"));
        List<WebElement> flight_info_list = all_flight_info.findElements(By.xpath("./div"));
        for (int i = 0; i < flight_info_list.size(); i++) {
            String main_x_path = "(//*[@id='list-results-section-0']/div[5])/div["+(i+1)+"]";
            WebElement start_time = driver.findElement(By.xpath(main_x_path+"/div/div[1]/div/div[1]/div[1]"));
            WebElement from_loc = driver.findElement(By.xpath(main_x_path+"/div/div[1]/div/div[1]/div[2]"));
            WebElement duration = driver.findElement(By.xpath(main_x_path+"/div/div[1]/div/div[2]/div[2]"));
            WebElement end_time = driver.findElement(By.xpath(main_x_path+"/div/div[1]/div/div[3]/div[1]"));
            WebElement to_loc = driver.findElement(By.xpath(main_x_path+"/div/div[1]/div/div[3]/div[2]"));
            WebElement flight_no = driver.findElement(By.xpath(main_x_path+"/div/div[1]/div/div[4]/div[1]"));
            WebElement connection = driver.findElement(By.xpath(main_x_path+"/div/div[1]/div/div[4]/div[2]"));
            WebElement prize = driver.findElement(By.xpath(main_x_path+"/div/div[2]/div[1]/div/div/div/div[2]"));
            System.out.println("Flight Number: "+ flight_no.getText());
            System.out.println("From: " + from_loc.getText() + " " + "To: " + to_loc.getText());
            System.out.println("Total Duration: " + duration.getText());
            System.out.println("Time: " + start_time.getText() + "-" + end_time.getText());
            System.out.println("Connection: " + connection.getText());
            System.out.println("Fare: " + prize.getText());
            System.out.println("----------------------------------");

        }

   }

}
