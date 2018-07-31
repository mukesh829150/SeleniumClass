package com.fb.GenericReusable;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.Browser;

public class WebElementAction extends Browser{
	
	public boolean selectElementByVisibleText(WebElement element, String text){
		try{
			Select select=new Select(element);
			select.selectByVisibleText(text);	
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean selectElementByValue(WebElement element, String value){
		try{
			Select select=new Select(element);
			select.selectByValue(value);	
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean selectElementByIndex(WebElement element, int index){
		try{
			Select select=new Select(element);
			select.selectByIndex(index);	
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean alertAccept(){
		WebDriverWait wait=new WebDriverWait(driver,2);
		try{
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean switchFramebyIdorName(String name){
		WebDriverWait wait=new WebDriverWait(driver,2);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(name)));
			driver.switchTo().frame(name);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean switchWindowByTitle(String requiredTile){
		try{
			String flag = null;
			Set<String> handles = driver.getWindowHandles();
			
			for (String presenthandle : handles) {
				if(driver.switchTo().window(presenthandle).getTitle().equalsIgnoreCase(requiredTile)){
					flag="success";
					break;
					}
				
			}
			if(flag.equalsIgnoreCase("success")){
				return true;
			}else{
			return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public WebElement waitForVisibility(WebElement element) throws Error{
	       return new WebDriverWait(driver, 30)
	            .until(ExpectedConditions.visibilityOf(element));
	}

}
