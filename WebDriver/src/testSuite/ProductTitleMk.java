package testSuite;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductTitleMk {
	
	WebDriver driver;
	@BeforeTest
	public void OpenChroeBrowser(){
			String chromePath = System.getProperty("user.dir") + "//drivers" + "//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver  = new ChromeDriver();
			driver.navigate().to("https://store.demoqa.com");
			driver.manage().window().maximize();
		}
	@Test
	public void findProductTitle() throws InterruptedException {

	List<WebElement> title=driver.findElements(By.xpath("//section[@class='footer_featured']/ul/li"));
	
	Iterator<WebElement> itr= title.iterator();
	String ProductTitle="iPod Nano Blue";
	int i=0;
	while(itr.hasNext()) {
		itr.next();
		i=i+1;
		String titleText=driver.findElement(By.xpath("//section[@class='footer_featured']/ul/li["+i+"]/a[1]")).getText();
		if(ProductTitle.equalsIgnoreCase(titleText)) {
			driver.findElement(By.xpath("//section[@class='footer_featured']//ul/li["+i+"]/a[3]")).click();
			break;
			}	
	}
	/*int listSize=title.size();
	System.out.println(listSize);
	//System.out.println(driver.findElement(By.xpath("//section[@class='footer_featured']/ul/li[3]/a[1]")).getText());
	
	String ProductTitle="iPod Nano Blue";
	for(int i=1;i<=listSize;i++) {
		String titleText=driver.findElement(By.xpath("//section[@class='footer_featured']/ul/li["+i+"]/a[1]")).getText();
		if(ProductTitle.equalsIgnoreCase(titleText)) {
			driver.findElement(By.xpath("//section[@class='footer_featured']//ul/li["+i+"]/a[3]")).click();
			break;
			}
		}*/
	}
}
