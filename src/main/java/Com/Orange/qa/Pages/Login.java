package Com.Orange.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import Com.Orange.qa.base.TestBase;

public class Login extends TestBase{
	
	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement Username;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement LoginButton;
	
	@FindBy(xpath = "//p[@class=\"oxd-userdropdown-name\"]")
	WebElement HomePageUsername;
	
	public  Login() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean Validateusername(String UN,String PWD) throws InterruptedException {
		
		Username.sendKeys(UN);
		Thread.sleep(3000);
		
		Password.sendKeys(PWD);
		Thread.sleep(3000);
		
		LoginButton.click();
		
		return HomePageUsername.isDisplayed();
		
	}
	
}
