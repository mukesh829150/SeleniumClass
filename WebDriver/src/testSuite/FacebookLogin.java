package testSuite;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.fb.PageObjects.LandingPage;

import main.Browser;

public class FacebookLogin extends Browser{
	@Test
	public void fb(){
	driver.navigate().to("https://www.facebook.com/");
	driver.manage().window().maximize();
	LandingPage Lpage=PageFactory.initElements(driver, LandingPage.class);
	Lpage.Login("uname", "pass");
	}
}
