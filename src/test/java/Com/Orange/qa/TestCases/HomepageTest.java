package Com.Orange.qa.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.Orange.qa.Pages.OrangeHRMHomepage;
import Com.Orange.qa.Pages.OrangeHRMLoginpage;
import Com.Orange.qa.base.TestBase;

public class HomepageTest extends TestBase {
	
	OrangeHRMLoginpage Loginpage;
	OrangeHRMHomepage Homepage;
	
	public HomepageTest() throws IOException {
		
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void setup() throws IOException {
		
		initialization();
		Loginpage=new OrangeHRMLoginpage();
		Homepage=new OrangeHRMHomepage();
		
	}
	
	@Test
	public void EmployeeName() throws InterruptedException {
		
		Loginpage.Validateusername(props.getProperty("Username"),props.getProperty("Password"));
		Thread.sleep(3000);
		
		Homepage.Reporterpage(props.getProperty("Name"));
		
		System.out.println(Loginpage);
		System.out.println(Homepage);
		
	}
	
	@Test
	public void AddEmploy() throws InterruptedException {
		
		Loginpage.Validateusername(props.getProperty("Username"),props.getProperty("Password"));
		Thread.sleep(3000);
		
		Homepage.AddEmployees(props.getProperty("FirstName"),props.getProperty("MiddleName"),props.getProperty("LastName"));
		
		
		
	}
	
	@AfterMethod
	public void Teardown() {
		
		driver.quit();
		
	}
	

}
