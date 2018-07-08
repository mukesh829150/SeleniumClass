package testSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import main.Browser;

public class WebTable extends Browser{
	
	
	@Test
	public void TestCaseWebTable() {
		
		driver.navigate().to("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().window().maximize();
		
	List<WebElement> tablelist=	driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
	int noOfRows=tablelist.size();
	System.out.println(noOfRows);
	
	for(int i=1;i<=noOfRows;i++) {
	
		WebElement ColumnName=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[1]"));
		
		if(ColumnName.getText().equalsIgnoreCase("Avanti Feeds Lim")) {
			WebElement PrevClose=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+(i+2)+"]/td[3]"));
			System.out.println("The price is : = "+PrevClose.getText());
			
		}
	}
		
	}

}
