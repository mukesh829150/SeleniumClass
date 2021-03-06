package testSuite;

import org.testng.annotations.Test;

import com.fb.GenericReusable.XlsReader;
import com.fb.PageObjects.LandingPage;

import main.Browser;

public class TestCaseRegisterUser extends Browser{
	
	LandingPage Lpage;
	XlsReader ReadExcel;
	
	public TestCaseRegisterUser() {
		ReadExcel=new XlsReader(System.getProperty("user.dir")+"//Data//excelWork.xlsx");
	}
	@Test
	public void TestRegister(){
		Step01ProvideFirstNameAndBday();
		Step02ClickOnSignUP();
	}


	private void Step02ClickOnSignUP() {
		// TODO Auto-generated method stub
		
	}


private void Step01ProvideFirstNameAndBday(){
	Lpage=new LandingPage(driver);
	String firstName=ReadExcel.getCellData("LandingPage", "TestCaseRegisterUser1", "FirstName");
	String lastName=ReadExcel.getCellData("LandingPage", "TestCaseRegisterUser1", "LastName");
	Lpage.Register(firstName, lastName, "30");
		
	}

	
	
	
	

}
