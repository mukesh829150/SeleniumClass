package testSuite;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import main.Browser;

public class AutoCompleteMukesh  extends Browser {
	String text="India";
	@Test
	public void AutoComplete() throws InterruptedException{
		driver.navigate().to("http://demo.automationtesting.in/AutoComplete.html");
		driver.manage().window().maximize();
		WebElement autoOption=driver.findElement(By.xpath("//input[@id='searchbox']"));
		autoOption.sendKeys("Ind");
		Thread.sleep(3000);
		List<WebElement> optionsToSelect = driver.findElements(By.xpath("//ul/li/a[@class='ui-corner-all']"));
		
		int total=optionsToSelect.size();
		
		System.out.println(total);
		
		for(int i=0;i<=total;i++) {
			WebElement first=driver.findElement(By.xpath("(//ul/li/a[@class='ui-corner-all'])[i]"));
			String value=first.getText();
			if(value.equalsIgnoreCase(text));
			 System.out.println("Trying to select: "+text);
			 first.click();
	            break;
	            
	         /*   for(WebElement search:optionsToSelect) {
	            	String value=search.getText();
	            	if(value.equalsIgnoreCase(text));
	   			 
	   			 search.click();
	            }
		}*/
		}
	}
}

