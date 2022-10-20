package Com.Orange.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Orange.qa.base.TestBase;

public class OrangeHRMConfigurationpage extends TestBase{
	
	@FindBy(xpath = "//span[contains(text(),\"Configuration \")]")
	WebElement Config;
	
	@FindBy(xpath = "//ul[@class=\"oxd-dropdown-menu\"]//li")
	WebElement ConfigList;
	
	@FindBy(xpath = "//a[contains(text(),\"Data Import\")]")
	WebElement DataIMP;
	

	public OrangeHRMConfigurationpage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String ConfiListBox() throws InterruptedException {
		
		Config.click();
		Thread.sleep(3000);
		ConfigList.getText();
		
		return ConfigList.getText();
	}
	public String DataImport() {
		
		DataIMP.getText();
		return DataIMP.getText();
		
		
	}
	
	

}
