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
	By downloadspeed = By.xpath("//span[contains(@class,'download-speed') and not(text()='—')]");			
	By uploadspeed = By.xpath("//span[contains(@class,'upload-speed') and not(text()='—')]");
	By Browsinginfo = By.xpath("//div[@class='MuiBox-root css-dfpqc0'][2]");
	
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
		System.out.println("The Download Speed is:"+ downloadinfo+" Mbps");
		
		WebElement uploaddata = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadspeed));
		String uploadinfo = uploaddata.getText();
		System.out.println("The Upload Speed is: "+uploadinfo+" Mbps");
	}
}
