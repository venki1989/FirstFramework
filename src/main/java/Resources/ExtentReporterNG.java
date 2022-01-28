package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.IReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IReporter;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.Report;
import com.relevantcodes.extentreports.converters.ReportParser;
import com.relevantcodes.extentreports.model.Test;

public class ExtentReporterNG implements IReporter {
	public ExtentReports extent;
	public Properties properties; 

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportsTestNG.html", true);
		properties= new Properties();

		FileInputStream file = null;


		try {
			file = new FileInputStream("C:\\Users\\venkatesh.m\\Framework\\src\\main\\java\\Resources\\data.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			properties.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		extent.flush();
		extent.close();
	}

	public void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				//test = extent.startTest(result.getClass().getName());// getMethod().getMethodName());
				test = extent.startTest(result.getMethod().getMethodName());
				/*test.getTest(). = getTime(result.getStartMillis());
                test.getTest().endedTime = getTime(result.getEndMillis());*/

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				String message = properties.getProperty(result.getMethod().getMethodName());

				if (result.getThrowable() != null)
					message = result.getThrowable().getMessage();

				test.log(status, message);

				extent.endTest(test);
			}
		}
	}

	@SuppressWarnings("unused")
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();        
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public void addTest(Test test) {
		// TODO Auto-generated method stub
		
	}

	public void setTestRunnerLogs() {
		// TODO Auto-generated method stub
		
	}

	public void start(ReportParser report) {
		// TODO Auto-generated method stub
		
	}


}