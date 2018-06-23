package testSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBaseClass {

	public static WebDriver driver;
	public static String Title="Welcome: Mercury Tours";
	public static String Text="Dear Mukesh Kumar,";
	
	public static String driverPath = System.getProperty("user.dir")+"//drivers";
	
	
	public static void main(String args[]) throws IOException {
		Properties prop=new Properties();
		InputStream Stream=new FileInputStream(System.getProperty("user.dir")+"//Data//testData.properties");
		prop.load(Stream);
		String chromePath=driverPath+"//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver=new ChromeDriver();	
		driver.navigate().to("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		if(Title.equalsIgnoreCase(driver.getTitle()))
		{
			System.out.println("Page title is correct");
		}
		else
			System.out.println("Page title is not correct");	
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Mukesh");
		driver.findElement(By.name("lastName")).sendKeys("Kumar");
		driver.findElement(By.name("phone")).sendKeys("9681948185");
		driver.findElement(By.id("userName")).sendKeys("mukesh829150@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("Address 123 Dump");
		driver.findElement(By.name("city")).sendKeys("Kolkata");
		driver.findElement(By.name("state")).sendKeys("WB");
		driver.findElement(By.name("postalCode")).sendKeys("700001");
		driver.findElement(By.id("email")).sendKeys("mukesh829150@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345678");
		driver.findElement(By.name("confirmPassword")).sendKeys("12345678");
		driver.findElement(By.name("register")).click();
		String check=driver.findElement(By.xpath("//b[contains(text(),'Dear')]")).getText();
		/*System.out.println(check);
		System.out.println(Text);*/
		if(Text.equalsIgnoreCase(check))
		{
			System.out.println("Register Successful");
		}
		else
			System.out.println("Register Unsuccessful");
	}
}
	
	
	
	

