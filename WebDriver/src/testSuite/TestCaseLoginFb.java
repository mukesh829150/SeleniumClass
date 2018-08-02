package testSuite;

import org.testng.annotations.Test;

import com.fb.GenericReusable.WebElementAction;
import com.fb.GenericReusable.XlsReader;
import com.fb.PageObjects.HomePage;
import com.fb.PageObjects.LandingPage;

import main.Browser;

public class TestCaseLoginFb extends Browser{
	
	LandingPage Lpage;
	HomePage Home;
	WebElementAction actions;
	XlsReader ReadExcel;
	
	public TestCaseLoginFb() {
		
		ReadExcel = new XlsReader(System.getProperty("user.dir")+"//Data//excelWork.xlsx");
	}
	
	@Test
	public void TestLogin() throws InterruptedException {
		
		Step01ProvideEmailandPass();
		Step02ClickSearchBox();//individually handle through try catch
	}

	private void Step01ProvideEmailandPass() {
		Lpage = new LandingPage(driver);
		String emailId = ReadExcel.getCellData("LandingPage", "TestCaseRegisterUser1", "EmailId");
		String password = ReadExcel.getCellData("LandingPage", "TestCaseRegisterUser1", "Password");
		Lpage.Login(emailId, password);
	}
	
    /*private void Step02ClickLogin() {
			Lpage.btnLogin.click();
	}*/
	
	private void Step02ClickSearchBox() throws InterruptedException {
		
		Home = new HomePage(driver);
		
		//hide/show notification box made page black and no operation can be made without manually disabling the alert box.
		//actions = new WebElementAction();
		//actions.alertAccept();
		Thread.sleep(5000);
		Home.txtSearchBox.click();
	}

}
