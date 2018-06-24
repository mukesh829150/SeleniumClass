package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {

	public static WebDriver driver;
	public static String driverPath = System.getProperty("user.dir")+"//drivers";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//input[@name='sex' and @type='radio' and @value='2']
		String chromePath=driverPath+"//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		
		driver.navigate().to("https://demo.tutorialzine.com/2009/09/simple-ajax-website-jquery/demo.html#page1");		
		driver.findElement(By.xpath("//a[text()='Page 2']")).click();
		//Thread.sleep(2000);
		//Implicit wait--driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebDriverWait wait=new WebDriverWait(driver,10);
		
	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Aliquamppp')]")));
		WebElement textArea=driver.findElement(By.xpath("//*[contains(text(),'Aliquam')]"));
		System.out.println(textArea.getText());	
	}catch(Exception E) {
		E.printStackTrace();
		System.out.println("Text Area Not found after 5 secs");
	}
		
		
		
		
		
		
		/*if(text.contains("Aliquam")) {
			System.out.println("Test Case Passed");
		}else {
			System.out.println("Test Case Failed");
		}*/
		
	    
		
		
		
	}

}
