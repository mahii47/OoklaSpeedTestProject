package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void click(WebElement element)
	{
		element.click();
	}
	public String getTextmsg(WebElement element)
	{
		return element.getText();
	}
}
