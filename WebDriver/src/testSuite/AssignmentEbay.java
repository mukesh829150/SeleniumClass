package testSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentEbay {
	
	public static WebDriver driver;
	
	public static String driverpath = System.getProperty("user.dir") + "//drivers";

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Properties dataProp = new Properties();		
		
		//Load all the Data Related to Test Case
		String URL=null,firstName = null,lastName = null,passWord = null;
		try {
			dataProp = loadProperties("//data//testEbay.properties");
			URL=dataProp.getProperty("URL");
			firstName= dataProp.getProperty("FirstName");
			lastName=dataProp.getProperty("LastName");
			passWord=dataProp.getProperty("password");
		} catch (Exception e) {
			System.out.println("Data Not Loaded Properly "+e.getMessage());
		}
		
		Properties objectProp = new Properties();
		objectProp = loadProperties("//Object//objectEbay.properties");
		
		
		String chromepath = driverpath + "//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		
		//System.out.println(driver.getTitle());
		String title = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
		if(title.equalsIgnoreCase(driver.getTitle())){
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		getelement(objectProp.getProperty("lnk_Register")).click();;
		//driver.findElement(By.xpath("//a[text()='register']")).click();
		//driver.findElement(By.linkText("register")).click();
		
		//System.out.println(driver.getTitle());
		String reg_title = "Sign in or Register | eBay";
		if(reg_title.equalsIgnoreCase(driver.getTitle())){
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}		
		
		WebElement Firstname = getelement(objectProp.getProperty("txt_FirstName"));
		WebElement Lasttname = getelement(objectProp.getProperty("txt_LastName"));
		WebElement Email = getelement(objectProp.getProperty("txt_Email"));
		WebElement password = getelement(objectProp.getProperty("tst_password"));
		
		Actions insertKey = new Actions(driver);
		
		insertKey.sendKeys(Firstname, firstName).build().perform();
		insertKey.sendKeys(Lasttname, lastName).build().perform();
		insertKey.sendKeys(Email, "abcdg").build().perform();
		
		
		password.click();
		String errortxt = driver.findElement(By.id("email_w")).getText();
		System.out.println(errortxt);
		
		String passError1 = driver.findElement(By.xpath("//div[@data-rule-name='MIN_PASSWORD_LENGTH_MATCH']/span")).getText();
		System.out.println(passError1);
		
		String passError2 = driver.findElement(By.xpath("//div[@data-rule-name='MIN_PASSWORD_LENGTH_MATCH']/span")).getText();
		System.out.println(passError2);
		
		String passError3 = driver.findElement(By.xpath("//div[@data-rule-name='LETTER']/span")).getText();
		System.out.println(passError3);
		
		
		insertKey.sendKeys(password, passWord).build().perform();
		
		
		Thread.sleep(2000);
	
		
		
		//getelement(objectProp.getProperty("txt_FirstName")).insertKey.sendKeys(dataProp.getProperty("FirstName")).build().perform();;
		//getelement(objectProp.getProperty("txt_LastName")).sendKeys(dataProp.getProperty("LastName"));
		
	}

	private static WebElement getelement(String value) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ret = null;
		String LocatorType = value.split("#")[0];
		String LocatorValue = value.split("#")[1];
		
		switch(LocatorType){
		
		case "id":
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorValue)));
				ret = driver.findElement(By.id(LocatorValue));
				break;
			}catch (Exception E){
				System.out.println("Element with Property ID: "+LocatorValue+" not found");
			}
			
		case "xpath":
			ret = driver.findElement(By.xpath(LocatorValue));
			break;
			
		default :
			break;
		}
		
		return ret;
		
	}

	private static Properties loadProperties(String path) throws IOException {
		Properties prop = new Properties();
		InputStream Stream = new FileInputStream(System.getProperty("user.dir") + path);
		prop.load(Stream);
		return prop;
	}

}//test
