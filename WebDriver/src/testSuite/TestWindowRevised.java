package testSuite;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestWindowRevised {
	
	WebDriver driver;
	String driverpath = System.getProperty("user.dir") + "//drivers";
	
	@BeforeTest
	public void OpenChromeBrowser() {
		String chromePath = driverpath + "//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void window() throws InterruptedException {
		
		String result = null;
		
		try {
			driver.findElement(By.xpath("//li[3]//a[@class='analystic']")).click();
			driver.findElement(By.xpath("//button[text()='click ']")).click();
			String parentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> itr= handles.iterator();
			while(itr.hasNext()) {
			String str=	itr.next();
			if(!str.equalsIgnoreCase(parentHandle)) {
				String requiredWindow = driver.switchTo().window(str).getTitle();
				if(requiredWindow.equalsIgnoreCase("Sakinalium | Home")) {
					result = "success";
					break;
				}
			}
				
			}
		/*	for(String presentHandle:handles) {
				if(!presentHandle.equalsIgnoreCase(parentHandle)) {
					String requiredWindow = driver.switchTo().window(presentHandle).getTitle();
					if(requiredWindow.equalsIgnoreCase("Sakinalium | Home")) {
						result = "success";
						break;
					}
				}
			}*/
			if(result.equalsIgnoreCase("success")){
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@title='Sakinalium Demo C#-Mobile']")).click();
			}
		}catch(Exception e) {
			System.out.println("Required Window not found");
		}
		
	}

}//push
