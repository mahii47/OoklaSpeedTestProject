package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpeedTestPage extends BasePage {
	
	By gobuttonlocator = By.xpath("//*[@class='js-start-test test-mode-multi']");
	By continueButtonlocator = By.id("onetrust-accept-btn-handler");
	By downloadspeed = By.xpath("//span[@class='result-data-large number result-data-value download-speed'and(@data-download-status-value='0.01' or @data-download-status-value='0.02')]");
		    
	By uploadspeed =  By.xpath(
		    "//span[contains(@class,'result-data-large number result-data-value upload-speed')and(@data-upload-status-value='0.01' or @data-upload-status-value='0.02')]");
	
	public SpeedTestPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(120));
	}
	public void checkInternet()
	{
		WebElement gobutton = wait.until(ExpectedConditions.elementToBeClickable(gobuttonlocator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gobutton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", gobutton);
	}
	public void privacybutton()
	{
		WebElement continuebutton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonlocator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continuebutton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", continuebutton);
	}
	public void checkSpeedTest()
	{
		WebElement downloaddata = wait.until(ExpectedConditions.visibilityOfElementLocated(downloadspeed));
		String downloadinfo = downloaddata.getText();
		System.out.println("The download Speed "+ downloadinfo);
		
		WebElement uploaddata = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadspeed));
		String uploadinfo = uploaddata.getText();
		System.out.println("The upload speed "+uploadinfo);
	}
}
