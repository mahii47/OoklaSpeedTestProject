package ui;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.SpeedTestPage;

public class UISpeedTest extends BaseTest {
	
	@Test
	public void verifyInternetSpeed() throws InterruptedException
	{
		SpeedTestPage speedpage = new SpeedTestPage(driver);
		speedpage.privacybutton();
		speedpage.checkInternet();
		speedpage.checkSpeedTest();
	}
}
