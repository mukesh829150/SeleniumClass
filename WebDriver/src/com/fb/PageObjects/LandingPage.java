package com.fb.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fb.GenericReusable.WebElementAction;

public class LandingPage{
	
	WebDriver LandingPageDriver;
	
	
	public LandingPage(WebDriver driver) {
		LandingPageDriver=driver;
	}
	
	@FindBy(name="email")
	public WebElement txtLoginEmail;
	
	@FindBy(name="pass")
	public WebElement txtLoginPassword;
	
	@FindBy(id="u_0_2")
	public WebElement btnLogin;
	
	@FindBy(id="u_0_j")
	WebElement txtFirstName;
	
	@FindBy(id="u_0_l")
	WebElement txtLasttName;
	
	@FindBy(id="u_0_o")
	WebElement txtMobile;
	
	@FindBy(id="u_0_v")
	WebElement txtRegPassword;
	
	@FindBy(id="day")
	WebElement drpRegBirthday;
	
	@FindBy(id="month")
	WebElement drpRegBirthmonth;
	
	@FindBy(id="year")
	WebElement drpRegBirthyear;
	
	@FindBy(xpath="//input[@type='radio' and @value=1]")
	WebElement radFemale;
	
	@FindBy(xpath="//input[@type='radio' and @value=2]")
	WebElement radMale;
	
	@FindBy(name="//button[@name='websubmit']")
	WebElement SignUp;
	
	
	public boolean Login(String UserName, String Password) {
		try {
			txtLoginEmail.sendKeys(UserName);
			txtLoginPassword.sendKeys(Password);
			btnLogin.click();
			return true;
			}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean Register(String FirstName, String LastName, String BirthDay) {
		try {
			txtFirstName.sendKeys(FirstName);
			txtLasttName.sendKeys(LastName);
			(new WebElementAction()).selectElementByVisibleText(drpRegBirthday, BirthDay);
			return true;
			}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

}
