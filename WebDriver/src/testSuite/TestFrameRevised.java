package testSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFrameRevised {
	
	WebDriver driver;
	String driverpath = System.getProperty("user.dir") + "//drivers";
	
	@BeforeTest
	public void OpenChromeBrowser() {
		String chromePath = driverpath + "//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testFrameRevised(){
		
	}

}
