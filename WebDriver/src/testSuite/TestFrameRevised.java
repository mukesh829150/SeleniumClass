package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFrameRevised {
	
	WebDriver driver;
	String driverpath = System.getProperty("user.dir") + "\\drivers";
	
	@BeforeTest
	public void OpenChromeBrowser() {
		String chromePath = driverpath + "\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		System.out.println(chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testFrameRevised(){
		try{
			driver.switchTo().frame("singleframe");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input")).sendKeys("Gaurav");
			System.out.println("Text entered in single frame");
		}catch(Exception e){
			System.out.println("Frame not found");
		}
		
		try{
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		}catch(Exception e){
			System.out.println("Unable to click on Multiple Frame Button");
		}
		
		try{
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='Multiple']//iframe")));
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input")).sendKeys("Test Gaurav");
			System.out.println("Text entered in Multipe frame");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[@href='#Single']")).click();
			System.out.println("Clicked on single frame link");
		}catch(Exception e){
			System.out.println("Multiple frame not found");
		}
	}

}
