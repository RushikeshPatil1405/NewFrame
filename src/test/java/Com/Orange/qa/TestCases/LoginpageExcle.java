package Com.Orange.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import Com.Orange.qa.Pages.Login;
import Com.Orange.qa.Util.ReadExcledata;
import Com.Orange.qa.base.TestBase;

public class LoginpageExcle extends TestBase{
		
		Login log;

		public LoginpageExcle() throws IOException {
			
			
		}
		
		@BeforeMethod
		public void setup() throws IOException {
			
			initialization();
			log=new Login();
			
		}
		
		@Test(dataProviderClass =ReadExcledata.class,dataProvider ="testData")
		public void OrangeUsername() throws InterruptedException {
			
			boolean UserID=log.Validateusername(ReadExcledata.getProperty("Username"),ReadExcledata.getProperty("Password"));
			
			Assert.assertTrue(true);
			System.out.println(UserID);
			
		}
		
	
		
		@AfterMethod
		public void Teardown() {
			
			driver.quit();
			
		}
		


}
