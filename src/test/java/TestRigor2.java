


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.testrigor.selfhealingselenium.v4.application.SelfHealingDriver;

import junit.framework.Assert;

public class TestRigor2 {
    private static final int SECONDS_TIMEOUT = 4;
	private static final String TEST_TEXT = "test123";
	@Test
	public void test_Selenium_tests_heals_for_path_and_tag_change() {
		System.setProperty("webdriver.chrome.driver", "/Users/AtharvaChiplunkar/Library/CloudStorage/GoogleDrive-ac2434@g.rit.edu/My Drive/internship-getinge/getinge-internship/src/drivers/chromedriver");
		//RemoteWebDriver driver = new ChromeDriver();
		SelfHealingDriver driver = com.testrigor.selfhealingselenium.v4.TestRigor.selfHeal(new ChromeDriver(), "a2518f3a-3e8b-484a-befe-23b9160ef166");
		driver.manage().timeouts().implicitlyWait(SECONDS_TIMEOUT, TimeUnit.SECONDS);
		driver.get("http://r4d4.info/form-button-label");
		actualTest(driver);
		driver.get("http://r4d4.info/form-button-label2");
		actualTest(driver);
	}

	private void actualTest(SelfHealingDriver driver) {
		WebElement input = driver.findElement(By.id("messageNew"));
		WebElement button = driver.findElement(By.id("changer"));
		input.sendKeys(TEST_TEXT);
		button.click();
		String result = driver.findElement(By.xpath("/html/body/div/p[1]")).getText();
		System.out.println(result);
		//Assert.assertEquals(TEST_TEXT, );
		
	}
}
