package testSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTableRevised {
	
	WebDriver driver;
	String driverpath = System.getProperty("user.dir") + "//drivers";
	
	@BeforeTest
	public void OpenChromeBrowser(){
		String chromePath = driverpath + "//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver  = new ChromeDriver();
		driver.navigate().to("http://demo.automationtesting.in/WebTable.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void TableIterate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions action = new Actions(driver);
		
		WebElement btnNext = null;
		List<WebElement> rowlist = null;
		WebElement firstname = null;
		String firstnameText = null;
		WebElement editBtn;
		
		try{
			btnNext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ui-grid-pager-next']")));
		}catch(Exception e){
			System.out.println("Next button is Not present in the table");
		}
		
		try{
			rowlist = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ui-grid-row ng-scope']")));
		}catch(Exception e){
			System.out.println("Row not found");
		}
		
		String result = "fail";
		
		do{
			for(int i=1; i<=rowlist.size(); i++){
				try{
					firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-row ng-scope']["+i+"]/div/div[2]")));
					firstnameText  = firstname.getText();
					System.out.println(firstnameText);
				}catch(Exception e){
					System.out.println("First Name Column is not found");
				}
				
				if(firstnameText.equalsIgnoreCase("Sujata")){
					editBtn = driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])["+i+"]"));
					action.doubleClick(editBtn).build().perform();
					
					Thread.sleep(3000);
					firstname.findElement(By.xpath(".//input")).clear();
					firstname.findElement(By.xpath(".//input")).sendKeys("Gaurav");
					result = "pass";
					break;
				}
				
			}
				
			if(result.equalsIgnoreCase("pass")){
				break;
			}else{
				btnNext.click();
			}
			
		}while(btnNext.isEnabled());
		
	}

}
