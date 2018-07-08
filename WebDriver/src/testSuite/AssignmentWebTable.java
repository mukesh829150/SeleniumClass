package testSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import main.Browser;

public class AssignmentWebTable extends Browser {

	@Test(enabled=false)
	public void webtable() {
		driver.navigate().to("http://demo.automationtesting.in/WebTable.html");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']")));
		
		List<WebElement> tableColnums = driver.findElements(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']"));
		int numRows = tableColnums.size();
		System.out.println(numRows);
		
		for(int i=1;i<=numRows;){
			//WebElement firstName = driver.findElement(By.xpath("//span[text()='First Name']"));
			Actions action = new Actions(driver);
			WebDriverWait wait2=new WebDriverWait(driver,10);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])["+i+"]")));
			String a = driver.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])["+(i+1)+"]")).getText();
			//System.out.println(a);
			//System.out.println(i);
			if(a.equalsIgnoreCase("carlo")){
				int row = (i/5)+1;
				WebElement editButton = driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])["+row+"]"));
				action.doubleClick(editButton).perform();
				System.out.println("The First Name has been found as : '"+a+"' at row " +row);
				break;
			}else if(i == (numRows-4)){
				driver.findElement(By.xpath("//button[@class='ui-grid-pager-next']")).click();
				i = 1;
				System.out.println(a);
			}else{
				System.out.println("Name Not Found");
			}
			i = i+5;
			System.out.println(i);
		}
		//Iterator<WebElement> iter = tableColnums.iterator();
		
		
		/*while(iter.hasNext()) {
			WebElement we = iter.next();
			if(we.getText().equals("carlo")) {
				System.out.println("firstName is: "+ we.getText());
			}else {
				System.out.println("Name Not Found");
			}
			//driver.findElement(By.xpath("//button[@class='ui-grid-pager-next']")).click();
		}*/
		
		/*int numRows = tableColnums.size();
		System.out.println(numRows);
		String columnnName = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']")).getText();
		
		System.out.println(columnnName);
		
		while(!columnnName.equalsIgnoreCase("carlo")) {
			
			numRows++;
			driver.findElement(By.xpath("//button[@class='ui-grid-pager-next']")).click();
		}
		
		WebElement FirstName = driver.findElement(By.xpath("//div[text()='carlo']"));*/

	}
	
	
	
	@Test
	public void SearchTables() throws InterruptedException {
		driver.navigate().to("http://demo.automationtesting.in/WebTable.html");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Actions action = new Actions(driver);
		WebElement btnNext=null;
		List<WebElement> rowsList=null;
		WebElement firstName = null, editButton = null;
		String txtFirstName = null;
		
		try{
			btnNext=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ui-grid-pager-next']")));
		//btnNext=driver.findElement(By.xpath("//button[@class='ui-grid-pager-next']"));
		}catch(Exception e){
			System.out.println("Next button is Not present in the table");
		}
		
		try{
			rowsList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ui-grid-row ng-scope']")));	
			//rowsList=driver.findElements(By.xpath("//div[@class='ui-grid-row ng-scope']"));
		}catch(Exception e){
			System.out.println("table is not there");
		}
		
		String result = "fail";
		//while(btnNext.isEnabled()){
		do{
			
			for(int i=1;i<=rowsList.size();i++){
				try {
					firstName=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-row ng-scope']["+i+"]/div/div[2]")));
				//	firstName = driver.findElement(By.xpath("//div[@class='ui-grid-row ng-scope']["+i+"]/div/div[2]"));
					txtFirstName = firstName.getText();
				} catch (Exception e) {
					System.out.println("First Name Column is not found");
				}
				if(txtFirstName.equalsIgnoreCase("carlo")){
					editButton = driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])["+i+"]"));
					action.doubleClick(editButton).build().perform();
					//action.moveToElement(editButton).doubleClick().build().perform();
					System.out.println("FirstName found.");
					Thread.sleep(3000);
					firstName.findElement(By.xpath(".//input")).clear();
					firstName.findElement(By.xpath(".//input")).sendKeys("Gaurav");
					//driver.findElement(By.xpath("//div[@class='ui-grid-row ng-scope']["+i+"]/div/div[2]//input")).clear();
					//driver.findElement(By.xpath("//div[@class='ui-grid-row ng-scope']["+i+"]/div/div[2]//input")).sendKeys("Gaurav");
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
