package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngParameters {
	
	WebDriver driver;
	String driverpath = System.getProperty("user.dir") + "//drivers";
	
	@BeforeTest
	public void OpenChromeBrowser() {
		String chromePath = driverpath + "//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://store.demoqa.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	@Parameters({"username", "password"})
	public void SendParameters(String username, String password) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement loginField;
		WebElement passField;
		
		try {
			driver.findElement(By.xpath("//a[text()='My Account']")).click();
			loginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log")));
			passField = driver.findElement(By.id("pwd"));
			loginField.sendKeys(username);
			passField.sendKeys(password);
		}catch(Exception e) {
			System.out.println("Login Field not found");
		}

	}

}//push
