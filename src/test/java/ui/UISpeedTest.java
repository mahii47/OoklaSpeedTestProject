package ui;
import org.testng.annotations.Test;
import base.BaseTest;
public class UISpeedTest extends BaseTest {

	@Test(priority=1,dependsOnMethods={"verifyPrivacyButton"})
	public void verifyInternetSpeed() throws InterruptedException
	{
		speedpage.checkInternet();	
	}
	@Test(priority=0)
	public void verifyPrivacyButton()
	{
		speedpage.privacybutton();
	}
	@Test(priority=2)
	public void verifySpeedTest()
	{
		speedpage.checkSpeedTest();
	}
}
