package Com.Orange.qa.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.Orange.qa.Pages.OrangeHRMConfigurationpage;
import Com.Orange.qa.Pages.OrangeHRMLoginpage;
import Com.Orange.qa.base.TestBase;

public class ConfigurationPageTest extends TestBase {
	
	OrangeHRMLoginpage Loginpage;
	OrangeHRMConfigurationpage Confipage;
	
	public ConfigurationPageTest() throws IOException {
		
		
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void Setup() throws IOException {
		initialization();
		Loginpage=new OrangeHRMLoginpage();
		Confipage=new OrangeHRMConfigurationpage();
		
				
	}
	
	@Test
	public void ConfigList() throws InterruptedException {
		
		boolean UserID=Loginpage.Validateusername(props.getProperty("Username"),props.getProperty("Password"));
		
		driver.findElement(By.xpath("//span[contains(text(),\"Configuration\")]")).click();
		List<WebElement> s1=driver.findElements(By.xpath("//ul[@class=\"oxd-dropdown-menu\"]//li"));
		System.out.println(s1.size());
		
		for(int i=0;i<s1.size();i++) {
			
			System.out.println(s1.get(i).getText());
			
			if(s1.get(i).getText().equals("DataImport")) {
				
				s1.get(i).click();
				break;
				
			}
		}
	}
	

	@AfterMethod
	public void Teardown() {
		
		driver.quit();
		
	}
}
