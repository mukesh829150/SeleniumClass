package testSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersOpenBrowser {
	
	WebDriver driver;
	String driverpath = System.getProperty("user.dir") + "//drivers";
	
	@Parameters({"browserName"})
	@Test(alwaysRun=true)
	public void selectBrowser(String browserName){
		if(browserName.equalsIgnoreCase("OpenChrome")){
			OpenChromeBrowser();
		}else{
			OpenFirefoxBrowser();
		}
	}
	
	
	public void OpenChromeBrowser(){
		String chromepath = driverpath + "//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	public void OpenFirefoxBrowser(){
		String fireFoxPath = driverpath + "//geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", fireFoxPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
	}

}
