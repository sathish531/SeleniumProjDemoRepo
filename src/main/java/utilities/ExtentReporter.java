package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extentReport;
	public static ExtentReports getExtentReports() {
		
		String extentReportPath = System.getProperty("user.dir")+"\\reports\\ExtentReports.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("Tutorials Ninja Automatiom Reports");
		reporter.config().setDocumentTitle("Test Results");
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System", "Windows 11");
		extentReport.setSystemInfo("Tested By", "Sathish");
		
		return extentReport;
		
	}

}
