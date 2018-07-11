
package testSuite;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import main.Browser;

public class TestWindowMukesh extends Browser{
	
	@Test
	public void Window() throws InterruptedException{
		driver.navigate().to("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='    click   ']")).click();
		String parentHandle=driver.getWindowHandle();
		 Set<String> handles=driver.getWindowHandles();
		 for(String presenthandle:handles) {
			 if(!presenthandle.equalsIgnoreCase(parentHandle)) {
				 driver.switchTo().window(presenthandle); 
			 }
		 }
			 
		 System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Sakinalium Demo C#-Mobile']")).click();
		driver.switchTo().window(parentHandle);
		}
	

}

