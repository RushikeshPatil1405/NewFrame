package Com.Orange.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Com.Orange.qa.base.TestBase;

public class LoginpageTest extends TestBase {
	
	Com.Orange.qa.Pages.OrangeHRMLoginpage Loginpage;

	public LoginpageTest() throws IOException {
		super();
		
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void setup() throws IOException {
		
		initialization();
		Loginpage=new Com.Orange.qa.Pages.OrangeHRMLoginpage();
		
	}
	
	@Test
	public void OrangeUsername() throws InterruptedException {
		
		boolean UserID=Loginpage.Validateusername(props.getProperty("Username"),props.getProperty("Password"));
		
		Assert.assertTrue(true);
		System.out.println(UserID);
		
	}
	
	@Test
	public void OrangeHRMPageTitle() throws InterruptedException {
		
		String PageTitle=Loginpage.validatePageTitle(props.getProperty("Username"),props.getProperty("Password"));
		
		Assert.assertEquals(PageTitle, props.getProperty("Title"));
		
		System.out.println(PageTitle);
		
	}
	
	@AfterMethod
	public void Teardown() {
		
		driver.quit();
		
	}
	

}
