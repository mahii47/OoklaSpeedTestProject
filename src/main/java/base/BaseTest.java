package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.SpeedTestPage;

public class BaseTest {
	
	public static WebDriver driver;
	protected SpeedTestPage speedpage;
	
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		speedpage = new SpeedTestPage(driver);
		driver.manage().window().maximize();
		driver.get("https://www.speedtest.net/");
		
	}
	@AfterTest
	public void teardown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}
