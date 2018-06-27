package testSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2 {

	public static WebDriver driver;
	public static String Title="Welcome: Mercury Tours";
	public static String Text="Dear Mukesh Kumar,";
	
	
	public static String driverPath = System.getProperty("user.dir")+"//drivers";
	
	
	public static void main(String args[]) throws IOException {
		
		
		//TestData-123-456
		Properties dataProp=new Properties();
		dataProp=loadProperties("//Data//testData.properties");
		
		//ObjectData
		Properties objectProp=new Properties();
		objectProp=loadProperties("//Object//testObject.properties");
				
		String chromePath=driverPath+"//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver=new ChromeDriver();	
		driver.navigate().to(dataProp.getProperty("URL"));
		driver.manage().window().maximize();
		if(Title.equalsIgnoreCase(driver.getTitle()))
		{
			System.out.println("Page title is correct");
		}
		else
			System.out.println("Page title is not correct");	
		getElement(objectProp.getProperty("lnk_Register")).click();
		getElement(objectProp.getProperty("txt_FirstName")).sendKeys(dataProp.getProperty("FirstName"));
		
		//driver.findElement(By.name("lastName")).sendKeys(dataProp.getProperty("LastName"));
		getElement(objectProp.getProperty("txt_LastName")).sendKeys(dataProp.getProperty("LastName"));
		//driver.findElement(By.name("phone")).sendKeys(dataProp.getProperty("Phone"));
		getElement(objectProp.getProperty("txt_Phone")).sendKeys(dataProp.getProperty("Phone"));
		//driver.findElement(By.id("userName")).sendKeys(dataProp.getProperty("UserName"));
		getElement(objectProp.getProperty("txt_UserName")).sendKeys(dataProp.getProperty("UserName"));
		//driver.findElement(By.name("address1")).sendKeys(dataProp.getProperty("Address1"));
		
		
		//driver.findElement(By.name("city")).sendKeys(dataProp.getProperty("City"));
		
		getElement(objectProp.getProperty("txt_Address1")).sendKeys(dataProp.getProperty("City"));
		//driver.findElement(By.name("state")).sendKeys(dataProp.getProperty("State"));
		
		getElement(objectProp.getProperty("txt_City")).sendKeys(dataProp.getProperty("State"));
		//driver.findElement(By.name("postalCode")).sendKeys(dataProp.getProperty("PostalCode"));
		
		getElement(objectProp.getProperty("txt_PostalCode")).sendKeys(dataProp.getProperty("PostalCode"));
		//driver.findElement(By.id("email")).sendKeys(dataProp.getProperty("email"));
		getElement(objectProp.getProperty("txt_email")).sendKeys(dataProp.getProperty("email"));
		
		//driver.findElement(By.name("password")).sendKeys(dataProp.getProperty("Password"));
		getElement(objectProp.getProperty("txt_Password")).sendKeys(dataProp.getProperty("Password"));
		
		//driver.findElement(By.name("confirmPassword")).sendKeys(dataProp.getProperty("ConfirmPassword"));
		getElement(objectProp.getProperty("txt_ConfirmPassword")).sendKeys(dataProp.getProperty("ConfirmPassword"));
		
		//driver.findElement(By.name("register")).click();
		
		getElement(objectProp.getProperty("btn_register")).click();
		//String check=driver.findElement(By.xpath("//b[contains(text(),'Dear')]")).getText();
		String check=getElement(objectProp.getProperty("VerifyText")).getText();
		/*System.out.println(check);
		System.out.println(Text);*/
		if(Text.equalsIgnoreCase(check))
		{
			System.out.println("Register Successful");
		}
		else {
			System.out.println("Register Unsuccessful");
			System.out.println("Register Unsuccessful");
		}
	}


	private static WebElement getElement(String value) {
		WebElement a=null;
		String LocatorType=value.split("#")[0];
		String LocatorValue=value.split("#")[1];
		if(LocatorType.equalsIgnoreCase("Name"))
		{
			a=driver.findElement(By.name(LocatorValue));
		}else if(LocatorType.equalsIgnoreCase("id")){
			a=driver.findElement(By.id(LocatorValue));
		}else if(LocatorType.equalsIgnoreCase("xpath")){
			a=driver.findElement(By.xpath(LocatorValue));}
		else if(LocatorType.equalsIgnoreCase("linkText")){
			a=driver.findElement(By.linkText(LocatorValue));}
		else if(LocatorType.equalsIgnoreCase("partialLinkText")){
			a=driver.findElement(By.partialLinkText(LocatorValue));}
		else if(LocatorType.equalsIgnoreCase("cssSelector")){
			a=driver.findElement(By.cssSelector(LocatorValue));}	
		
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
	
	
	
	

