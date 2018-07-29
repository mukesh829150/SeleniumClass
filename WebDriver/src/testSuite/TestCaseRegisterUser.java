package testSuite;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.fb.PageObjects.LandingPage;

import main.Browser;

public class TestCaseRegisterUser extends Browser{
	
	LandingPage Lpage;
	
	
	@Test
	public void TestRegister(){
		Step01ProvideFirstNameAndBday();
		Step02ClickOnSignUP();
	}


private void Step02ClickOnSignUP() {
		// TODO Auto-generated method stub
		
	}


private void Step01ProvideFirstNameAndBday() {
	Lpage=PageFactory.initElements(driver, LandingPage.class);
	Lpage.Register("Gaurav", "30");
		
	}

	
	
	
	

}
