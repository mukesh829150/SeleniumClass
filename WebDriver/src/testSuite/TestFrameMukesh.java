
package testSuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import main.Browser;

public class TestFrameMukesh extends Browser{
	
	@Test
	public void alert() throws InterruptedException{
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("SingleFrame");
		driver.findElement(By.xpath("//input")).sendKeys("Mukesh");
		System.out.println("Text entered in single frame");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//li[2]/a[@href='#Multiple']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='Multiple']/iframe")));
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input")).sendKeys("Mukesh");
		System.out.println("Text entered in Multipe frame");
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@href='#Single']")).click();
		System.out.println("Clicked on single frame link");
		
	}

}
