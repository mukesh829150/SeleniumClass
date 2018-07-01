package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Browser {
	
	public static WebDriver driver;
	public static String driverPath = System.getProperty("user.dir") + "//drivers";
	
	@BeforeMethod
	public void OpenChromeBrowser() {	
		String chromePath = driverPath + "//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
	}
//	@BeforeMethod
	public void OpenFirefoxBrowser() {
		String firefoxPath= driverPath + "//geckodriver.exe";
		//firefoxPath="D://Project//SeleniumClass//WebDriver//Drivers//geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
