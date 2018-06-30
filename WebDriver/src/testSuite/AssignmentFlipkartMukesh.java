package testSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentFlipkartMukesh {
	public static WebDriver driver;
	
	
	
	public static String driverPath = System.getProperty("user.dir")+"//drivers";

	public static void main(String[] args) throws IOException, InterruptedException {
		 Properties dataProp = null;
		 Properties objectProp = null;
		 String FlipkartURL=null;
		 String MaxValue=null;
		    try {
				dataProp=new Properties();
				dataProp=loadProperties("//Data//testData.properties");
				 FlipkartURL=dataProp.getProperty("FlipkartURL");
				 MaxValue=dataProp.getProperty("MaxValue");
		    }catch(Exception E) {
		    	System.out.println("Test Data Issue");
		    }
				
				
				try {
				
				//ObjectData
				 objectProp=new Properties();
				objectProp=loadProperties("//Object//testObject.properties");
		    }
		    catch(Exception e) {
		    	System.out.println("Property file not found");
		    }
		    
		    String chromePath=driverPath+"//chromedriver.exe";
		    System.setProperty("webdriver.chrome.driver", chromePath);
		    driver=new ChromeDriver();
				//Step 1: Flipkart URL
		    try {
		    	driver.navigate().to(FlipkartURL);
		    	} catch (Exception e) {
		    		System.out.println("Steps 1: Invalid URL entered");
		    		}
				
				driver.manage().window().maximize();
				try {
				getElement(objectProp.getProperty("Flipkart_popup_close")).click();
				//Step 2: Click on Tvs & Appliances menu
				getElement(objectProp.getProperty("lnk_TVs&Appliances")).click();
				//Thread.sleep(5000);
				//Step 3: Click on Inverter AC link
				getElement(objectProp.getProperty("lnk_InverterAC")).click();
				//Thread.sleep(5000);
				}
				catch(Exception e) {
					System.out.println("Element not found for either Step 2 or 3");
				}
				//WebElement element= ;
				Select dropdown=null ;
				String s;
				WebElement records=null;
				
				//Step4: User to Navigate to DropDown and selected the range
				try {
					dropdown = new Select(getElement(objectProp.getProperty("select_RangeClick")));
					}catch(Exception e) {
						System.out.println("Step 4: Element not found");
						}
				
				try {
					dropdown.selectByValue(MaxValue);
					}catch(Exception e) {
						System.out.println("Step 4.1: Value not found");
						}
				Thread.sleep(3000);
				try {
					records=getElement(objectProp.getProperty("select_Range"));
					}catch(Exception e) {
						System.out.println("Step 4.2: Record Element not found");
						}
				s=records.getText();
				//Step 5: Number of item displayed for the selected range
				System.out.println("Total record under "+dataProp.getProperty("MaxValue")+" range are:"+s);
				}
				
	private static WebElement getElement(String value) {
		WebElement a=null;
		String LocatorType=value.split("#")[0];
		String LocatorValue=value.split("#")[1];
		WebDriverWait wait=new WebDriverWait(driver,200);
		if(LocatorType.equalsIgnoreCase("Name"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LocatorValue)));
			a=driver.findElement(By.name(LocatorValue));
			}
		        else if(LocatorType.equalsIgnoreCase("id")){
				    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorValue)));
				    a=driver.findElement(By.id(LocatorValue));
				}
			    else if(LocatorType.equalsIgnoreCase("xpath")){
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorValue)));
					a=driver.findElement(By.xpath(LocatorValue));}
				else if(LocatorType.equalsIgnoreCase("linkText")){
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LocatorValue)));
					a=driver.findElement(By.linkText(LocatorValue));}
				else if(LocatorType.equalsIgnoreCase("partialLinkText")){
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(LocatorValue)));
					a=driver.findElement(By.partialLinkText(LocatorValue));}
				else if(LocatorType.equalsIgnoreCase("cssSelector")){
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LocatorValue)));
					a=driver.findElement(By.cssSelector(LocatorValue));}
				else if(LocatorType.equalsIgnoreCase("classname")){
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(LocatorValue)));
					a=driver.findElement(By.className(LocatorValue));}
		return a;
	}
	private static Properties loadProperties(String Path) throws IOException {
		Properties prop= new Properties();
        InputStream Stream=new FileInputStream(System.getProperty("user.dir")+Path);
		prop.load(Stream);
		return prop;
		//SYSO
	}

	

}
