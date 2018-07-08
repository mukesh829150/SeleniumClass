package testSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import main.Browser;

public class AssignmentWebTableMukesh extends Browser{
	public static WebDriver driver;
	public static String driverPath = System.getProperty("user.dir")+"//drivers";

	@Test
	public void searchtable() throws IOException, InterruptedException {
		//TestData-123-456
				Properties dataProp=new Properties();
				dataProp=loadProperties("//Data//testData.properties");
				
				//ObjectData
				//Properties objectProp=new Properties();
				//objectProp=loadProperties("//Object//testObject.properties");
						
				String chromePath=driverPath+"//chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromePath);
				driver=new ChromeDriver();	
				driver.navigate().to(dataProp.getProperty("WebTableUrl"));
				driver.manage().window().maximize();
				System.out.println("Webtable URL opened");
				Thread.sleep(3000);
				List<WebElement> tablelist=	driver.findElements(By.xpath("//*[contains(@id,'-uiGrid-0006-cell')]"));
				
				//System.out.println(noOfRows);
				Actions action = new Actions(driver);
				boolean flag=false;
				
				WebElement Nextbutton=driver.findElement(By.xpath("//button[@title='Page forward']"));
				do {
					int noOfRows=tablelist.size();
					for(int i=0;i<noOfRows;i++){
						WebElement FirstName=driver.findElement(By.xpath("//*[contains(@id,'"+i+"-uiGrid-0006-cell')]"));
						if(FirstName.getText().equalsIgnoreCase("Carlo")) {
							flag=true;
							System.out.println("Searched Name present");
							WebElement editButton = driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])["+(i+1)+"]"));
							action.doubleClick(editButton).build().perform();
							//Click on Edit Button and Change the firstName	
							FirstName.findElement(By.xpath(".//input")).clear();
							FirstName.findElement(By.xpath(".//input")).sendKeys("Mukesh");
							
							
							break;
							}
						}
					if(flag==false) {
						Nextbutton.click();
						}else {
							break;
							}
					}while(Nextbutton.isEnabled());
	}

	private static Properties loadProperties(String Path) throws IOException {
		Properties prop= new Properties();
		InputStream Stream=new FileInputStream(System.getProperty("user.dir")+Path);
		prop.load(Stream);
		return prop;
	}

}
