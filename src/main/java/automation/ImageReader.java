package automation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;

public class ImageReader {
	public void ScreenShot_OCR(WebElement imageElement, String img_name) throws IOException, TesseractException  {
		//WebDriver driver = new ChromeDriver(); 
        //System.out.println("Browser Started");
        
		File image = imageElement.getScreenshotAs(OutputType.FILE);
        File filepath = new File("D:\\Atharva\\internship_getinge\\internship\\images\\OCR_check_"+img_name+".png");
        FileHandler.copy(image, filepath);
        Tesseract1 imagetext = new Tesseract1();
        String str = imagetext.doOCR(filepath);
        System.out.println(str);
	}
	
	public void SpiceJet(WebDriver driver, String x_path1, String x_path2, int test_no) throws IOException, TesseractException {
        driver.findElement(By.xpath("//a[contains(@data-testid,'Hotels')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Set<String> windowHandles = driver.getWindowHandles();

	     // Assuming only two handles (original window and the new window)
	     List<String> handlesList = new ArrayList<>(windowHandles);
	     String newWindowHandle = handlesList.get(1);

	     // Switch to the new window
	     driver.switchTo().window(newWindowHandle);
	     driver.findElement(By.xpath(x_path1)).click();
	     WebElement image = driver.findElement(By.xpath(x_path2));
	     String img_name = "SpiceJet";
	     ScreenShot_OCR(image, img_name);
	}
}
