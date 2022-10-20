package Com.Orange.qa.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.Orange.qa.Pages.OrangeHRMAdminpages;
import Com.Orange.qa.Pages.OrangeHRMHomepage;
import Com.Orange.qa.Pages.OrangeHRMLoginpage;
import Com.Orange.qa.base.TestBase;

public class Adminpage extends TestBase {
	
	public Adminpage() throws IOException {
		
	}

	OrangeHRMLoginpage Loginpage;
	OrangeHRMHomepage Homepage;
	OrangeHRMAdminpages Adminpage;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setup() throws IOException {
		
		initialization();
		Loginpage=new OrangeHRMLoginpage();
		Homepage=new OrangeHRMHomepage();
		Adminpage=new OrangeHRMAdminpages();
		
	}
	
	@Test
	public void AdminPages1() throws InterruptedException {
		
		Loginpage.Validateusername(props.getProperty("Username"),props.getProperty("Password"));
		Thread.sleep(3000);
		
		Adminpage.AdminPagetab(props.getProperty("NationName"));
		
	}
	
	@AfterMethod
	public void Teardown() {
		
		driver.quit();
		
	}

}
	
	
	
	
	
	