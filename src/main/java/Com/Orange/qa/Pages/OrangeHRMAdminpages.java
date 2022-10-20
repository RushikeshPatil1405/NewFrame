package Com.Orange.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Orange.qa.base.TestBase;

public class OrangeHRMAdminpages extends TestBase {
	
	@FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"]")
	WebElement Admintab;
	
	@FindBy(xpath = "//a[@class=\"oxd-topbar-body-nav-tab-item\"]")
	WebElement Nationality;
	
	@FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	WebElement AddButton;
	
	@FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
	WebElement Namenati;
	
	@FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
	WebElement SaveButton;
	

	public OrangeHRMAdminpages() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String AdminPagetab(String NationName) throws InterruptedException {
		
		Admintab.click();
		Thread.sleep(3000);
		
		Nationality.click();
		Thread.sleep(3000);
		
		AddButton.click();
		Thread.sleep(3000);
		
		Namenati.sendKeys(NationName);
		Thread.sleep(3000);
		
		SaveButton.click();
		Thread.sleep(3000);
		
		return driver.getTitle();
		
	}

}
