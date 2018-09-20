package testSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import main.Browser;

public class TestAutoComplete extends Browser{
	
	@Test
	public void autoComplete() {	
		
		driver.navigate().to("http://demo.automationtesting.in/AutoComplete.html");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
	WebElement auto = driver.findElement(By.xpath("//div[contains(@class,'ui-autocomplete-multiselect')]/input"));
	auto.sendKeys("ind");
	
	List<WebElement> options= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item']/a")));
	int a = options.size();
	System.out.println(a);
	
	String expectedVal = "India";
	for(WebElement autoVal:options) {
		String searchedVal = autoVal.getText();
		if(searchedVal.equalsIgnoreCase(expectedVal)) {
			System.out.println("Found text : '"+expectedVal+"' with auto complete value 'IND'");
			autoVal.click();
		}
	}
	
 }

}
