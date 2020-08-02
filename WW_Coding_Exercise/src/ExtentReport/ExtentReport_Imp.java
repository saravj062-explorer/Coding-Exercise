package ExtentReport;

import java.util.HashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport_Imp {
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static ExtentReports createinstance() {
		htmlreporter = new ExtentHtmlReporter("./Reports/myreport.html");
		htmlreporter.config().setDocumentTitle("WW - QA Automation");
		htmlreporter.config().setReportName("Print Associate slots on a day");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlreporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");
		return extent;

	}

	public static ExtentReports getinstance() {
		if (extent == null) {
			createinstance();
		} else {
			return extent;
		}
		return extent;

	}

	
}
