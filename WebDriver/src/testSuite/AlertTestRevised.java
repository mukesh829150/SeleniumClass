package testSuite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTestRevised {
	
	WebDriver driver;
	String driverpath = System.getProperty("user.dir") + "//drivers";
	
	@BeforeTest
	public void OpenChromeBrowser() {
		String chromePath = driverpath + "//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void alertTest() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//Actions action = new Actions(driver);
		WebElement clickBtn;
		Alert alert = null;
		String alerttxt;
		WebElement okCanclBtn;
		WebElement alertBtn;
		WebElement alertTextBox;
		WebElement alertBoxBtn;
		
		try {
			 clickBtn = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
			 clickBtn.click();
		}catch(Exception e) {
			System.out.println("Alert Button not found");
		}
		
		try {
			alert = wait.until(ExpectedConditions.alertIsPresent());
			alerttxt = alert.getText();
			System.out.println(alerttxt);
			Thread.sleep(2000);
			alert.accept();
		}catch(Exception e) {
			System.out.println("Alert Box in not present");
		}
		
		try {
			okCanclBtn = driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
			okCanclBtn.click();
			alertBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
			alertBtn.click();
		}catch(Exception e) {
			System.out.println("Alert Button not found");
		}
		
		try {
			alert = wait.until(ExpectedConditions.alertIsPresent());
			alerttxt = alert.getText();
			System.out.println(alerttxt);
			Thread.sleep(2000);
			alert.dismiss();
			System.out.println(driver.findElement(By.id("demo")).getText());
		}catch(Exception e) {
			System.out.println("Alert Box for ok/cancel in not present");
		}
		
		try {
			alertTextBox = driver.findElement(By.xpath("//a[text()='Alert with Textbox ']"));
			alertTextBox.click();
			alertBoxBtn = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
			alertBoxBtn.click();
		}catch(Exception e) {
			System.out.println("Alert Box Button not found");
		}
		
		try {
			alert = wait.until(ExpectedConditions.alertIsPresent());
			alerttxt = alert.getText();
			System.out.println(alerttxt);
			Thread.sleep(2000);
			alert.sendKeys("Gaurav");
			alert.accept();
			System.out.println(driver.findElement(By.id("demo1")).getText());
		}catch(Exception e) {
			System.out.println("Alert Box for alert with Textbox in not present");
		}
	}

}
