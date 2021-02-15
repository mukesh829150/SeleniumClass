package testSuite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.fb.GenericReusable.WebElementAction;

import main.Browser;

public class AlertTests extends Browser{
	
	@Test
	public void alert() throws InterruptedException{
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		WebElement btnHover = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		action.moveToElement(btnHover).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		
		//Alert alert=driver.switchTo().alert();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		System.out.println(alertText);
		Thread.sleep(3000);
		WebElementAction acceptalert = new WebElementAction();
		acceptalert.alertAccept();
		//alert.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		alert.accept();
	}

}