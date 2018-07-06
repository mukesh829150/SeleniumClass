package testSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.service.DriverService;

public class AssignmentWebTableMukesh {
	public static WebDriver driver;
	public static String driverPath = System.getProperty("user.dir")+"//drivers";

	public static void main(String[] args) throws IOException {
		//TestData-123-456
				Properties dataProp=new Properties();
				dataProp=loadProperties("//Data//testData.properties");
				
				//ObjectData
				Properties objectProp=new Properties();
				objectProp=loadProperties("//Object//testObject.properties");
						
				String chromePath=driverPath+"//chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromePath);
				driver=new ChromeDriver();	
				driver.navigate().to(dataProp.getProperty("WebTableUrl"));
				driver.manage().window().maximize();
				System.out.println("Webtable URL opened");
				//List<WebElement> tablelist=	driver.findElements(By.xpath("//div[@class='ui-grid-cell-contents ui-grid-header-cell-primary-focus']']/tbody/tr"));
				//int noOfRows=tablelist.size();
				//System.out.println(noOfRows);
				
				for(int i=0;i<10;i++)
				{ 
					Actions action = new Actions(driver);
					WebElement FirstName=driver.findElement(By.xpath("//*[contains(@id,'"+i+"-uiGrid-0006-cell')]"));
					if(FirstName.getText().equalsIgnoreCase("Dinesh")) 
						System.out.println("Searched Name present");
					WebElement editButton = driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])["+i+"]"));
					action.doubleClick(editButton).build().perform();
					break;
						
					
					//else {
						//WebElement Nextbutton=driver.findElement(By.xpath("//button[@title='Page forward']"));
						//if (Nextbutton.isEnabled())
							//Nextbutton.click();
						//System.out.println("Searched Name not present");
					}
					
				}
				   
					
				
				
				
	//}

	private static Properties loadProperties(String Path) throws IOException {
		Properties prop= new Properties();
		InputStream Stream=new FileInputStream(System.getProperty("user.dir")+Path);
		prop.load(Stream);
		return prop;
	}

}
