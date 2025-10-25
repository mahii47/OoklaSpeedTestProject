package base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.SpeedTestPage;

public class BaseTest {
	
	public static WebDriver driver;
	protected SpeedTestPage speedpage;
	public static final Logger logger = LogManager.getLogger(BaseTest.class);
	@BeforeTest
	public void setup()
	{
		logger.info("Starting Speed Test Automation");
		driver = new ChromeDriver();
		speedpage = new SpeedTestPage(driver);
		driver.manage().window().maximize();
		driver.get("https://www.speedtest.net/");
		logger.info("Opening Speedtest website");
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
