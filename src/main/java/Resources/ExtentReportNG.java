package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		String Path=System.getProperty("C:\\Users\\HP\\eclipse-workspace\\4Jun_Framework\\Report")+"/Report/"+"index.html";
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(Path);
		
		reporter.config().setReportName("4 Jun Framework Results");
		
		reporter.config().setDocumentTitle("Automation Execution Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Automation Engineer", "Rushikesh Patil");
		
		return extent;
		
	}

}
