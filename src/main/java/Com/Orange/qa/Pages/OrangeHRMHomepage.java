package Com.Orange.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Orange.qa.base.TestBase;

public class OrangeHRMHomepage  extends TestBase {
	
	@FindBy(xpath = "//a[contains(text(),\"Reports\")]")
	WebElement Report;
	
	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
	WebElement ReporterName;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement SearchButton;
	
	@FindBy(xpath = "//a[contains(text(),\"Add Employee\")]")
	WebElement AddEmployee;
	
	@FindBy(xpath = "//input[@name=\"firstName\"]")
	WebElement Firstname;
	
	@FindBy(xpath = "//input[@name=\"middleName\"]")
	WebElement Middlename;
	
	@FindBy(xpath = "//input[@name=\"lastName\"]")
	WebElement Lastname;
	
	@FindBy(xpath = "//p[contains(text(),\"Create Login Details\")]")
	WebElement Text;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement SaveButton;
	

	public OrangeHRMHomepage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String Reporterpage(String Name) throws InterruptedException {
		
		Report.click();
		Thread.sleep(3000);
		
		ReporterName.sendKeys(Name);
		
		return ReporterName.getText();
		
	}
	
	public String AddEmployees(String FirstName,String MiddleName,String LastName) throws InterruptedException {
		
		AddEmployee.click();
		Thread.sleep(3000);
		
		Firstname.sendKeys(FirstName);
		Thread.sleep(3000);
		
		Middlename.sendKeys(MiddleName);
		Thread.sleep(3000);
		
		Lastname.sendKeys(LastName);
		Thread.sleep(3000);
		
		SaveButton.click();
		
		return driver.getTitle();
		
	
	}
	

}
