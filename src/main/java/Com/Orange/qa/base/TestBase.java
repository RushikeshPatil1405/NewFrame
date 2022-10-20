package Com.Orange.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Com.Orange.qa.Util.ReadExcledata;
import Com.Orange.qa.Util.TestUtill;
import freemarker.log.Logger;
import net.bytebuddy.utility.RandomString;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties props;
	public static Logger logger;
	
	
	public TestBase() throws IOException {
		
		props=new Properties();
		
		FileInputStream ip=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\4Jun_Framework\\src\\main\\java\\Com\\Orange\\qa\\config\\config.properties");
		
		props.load(ip);
		
	}
	
	@SuppressWarnings("deprecation")
	@Parameters({"browser"})
	public static void initialization() {
		
		System.out.println(props.getProperty("browser"));
		String Browsername=props.getProperty("browser");
		
		if(Browsername.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\eclipse\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		if(Browsername.equals("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver","C:\\eclipse\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		if(Browsername.equals("Edge")) {
			
			System.setProperty("webdriver.edge.driver","C:\\eclipse\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else {
			
			System.out.println("No Browser Values is Given");
		}
		
//		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\chromedriver.exe");
//		
//		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(props.getProperty("url"));
	}
	
	public String getScreenshotAs(String testcasename) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File Source =ts.getScreenshotAs(OutputType.FILE);
		
		String Random=RandomString.make(5);
		
		String Destination=System.getProperty("C://Users//HP//eclipse-workspace//4Jun_Framework//Screenshot")+"//Sceenshot//"+testcasename+""+Random+".png";
		
		FileUtils.copyFile(Source,new File(Destination));
		
		return Destination;
		
	}
	
	
	
}
