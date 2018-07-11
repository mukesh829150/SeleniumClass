package testSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import main.Browser;

public class WidgetsAccordion extends Browser{
	
	@Test
	public void testAccordion(){
		driver.navigate().to("http://demo.automationtesting.in/Accordion.html");
		driver.manage().window().maximize();
		
		List<WebElement> totalAccords = driver.findElements(By.xpath("//a[@data-toggle='collapse']/b"));
		int totalnoAccords = totalAccords.size();
		System.out.println(totalnoAccords);
		
		for(int i = 1; i <= totalnoAccords; i++){
			String linkName = driver.findElement(By.xpath("//a[@href='#collapse"+i+"']/b")).getText();
			System.out.println(linkName);
			driver.findElement(By.xpath("//a[@href='#collapse"+i+"']/b")).click();
			String insideText = driver.findElement(By.xpath("//div[@id='collapse"+i+"']/div")).getText();
			System.out.println(insideText);
		}
		//try catch: to be implemented
	}

}
