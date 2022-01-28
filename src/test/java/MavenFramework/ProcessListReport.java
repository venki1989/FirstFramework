package MavenFramework;



import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Resources.ExcelUtils;
import Resources.base;
import pageObjects.ProcessReportObject;
import pageObjects.metricLoginUI;

public class ProcessListReport extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	ProcessReportObject ProcessReport=null;
	ExcelUtils data= new ExcelUtils();


	@Test(priority=1)
	public void LoginApplication() throws IOException, InterruptedException
	{
		//Login to Application
		driver=initializeDriver();
		driver.get(properties.getProperty("metricurl"));
		metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().sendKeys(properties.getProperty("user"));
		login.clickaway().click();
		login.password().sendKeys(properties.getProperty("pass"));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority=2)
	public void OpenProcessReport() throws InterruptedException
	{
		ProcessReport=new ProcessReportObject(driver);
		ProcessReport.ProcessReportLink().click();
		Thread.sleep(3000);
	}

	@Test(priority=3)
	public void ExpandReport() throws InterruptedException
	{
	    Thread.sleep(5000);
		ProcessReport=new ProcessReportObject(driver);
		Actions mouse = new Actions(driver);
		Thread.sleep(5000);
		System.out.println("waiting for 3 seconds");
		//mouse.doubleClick(ProcessReport.ReportExpand()).build().perform();
		mouse.moveToElement(ProcessReport.ReportExpand()).click().build().perform();
		//mouse.click(ProcessReport.ReportExpand());

	}


	@Test(priority=4)
	public void EnterCycleFilterData() throws InterruptedException, IOException
	{

		ProcessReport=new ProcessReportObject(driver);
		Thread.sleep(2000);
		ArrayList<String>value =data.getData("EnterCycleName");
		ProcessReport.CycleFilter(value.get(1));
	}


	@Test(priority=5)
	public void EnterProcessFilterData() throws InterruptedException, IOException
	{

		ProcessReport=new ProcessReportObject(driver);
		Thread.sleep(2000);
		ArrayList<String>value =data.getData("EnterProcessName");
		ProcessReport.ProcessFilter(value.get(1));
	}

	@Test(priority=6)
	public void GenerateReport() throws InterruptedException
	{
		Thread.sleep(3000);
		ProcessReport=new ProcessReportObject(driver);
		ProcessReport.SubmitReport().click();
		Thread.sleep(3000);
		ProcessReport.SubmitReport().click();
	}




	@Test(priority=7)
	public void VerifyCycleNameColumn() throws IOException, InterruptedException
	{
		ProcessReport=new ProcessReportObject(driver);
		Thread.sleep(3000);
		String CycleNameColumntext=ProcessReport.CycleName().getText();
		ArrayList<String>value =data.getData("EnterCycleName");
		String PropertiesName =value.get(1);
		boolean checktrue=CycleNameColumntext.equalsIgnoreCase(PropertiesName);
		boolean checkfalse=!CycleNameColumntext.equalsIgnoreCase(PropertiesName);
		if (checktrue)
		{
			assertTrue(checktrue, "The report shows " + CycleNameColumntext + " Matching with : "+ PropertiesName);
			//Reporter.log(PropertiesName, checktrue);
			log.info("The Cycle name in the report is displayed correctly");
			System.out.println("The Cycle Name in the report is displayed correctly");
		}

		else {
			assertFalse(checkfalse, "The report shows " + CycleNameColumntext + " But Expected data is : "+ PropertiesName);
			log.info("The Cycle name in the report is not displayed correctly");
			System.out.println("The Cycle Name in the repot is not displayed correctly");
		}
	}

	@Test(priority=8)
	public void VerifyAreaColumn() throws IOException
	{
		ProcessReport=new ProcessReportObject(driver);
		String OrgAreaColumntext=ProcessReport.Area().getText();
		ArrayList<String>value =data.getData("Select Organization Area Drop down");
		String PropertiesName =value.get(1);
		boolean checktrue=OrgAreaColumntext.equalsIgnoreCase(PropertiesName);
		boolean checkfalse=!OrgAreaColumntext.equalsIgnoreCase(PropertiesName);
		if (OrgAreaColumntext.equals(PropertiesName))
		{
			assertTrue(checktrue, "The report shows " + OrgAreaColumntext+ " Matching with : "+ PropertiesName);
			log.info("The org Area in the report is displayed correctly");
			System.out.println("The org area in the report is displayed correctly");
		}

		else {
			assertFalse(checkfalse, "The report shows " + OrgAreaColumntext + " But Expected data is : "+ PropertiesName);
			log.info("The Cycle OwnerOrg in the report is not displayed correctly");
			System.out.println("The Cycle OwnerOrg in the repot is not displayed correctly");
		}
	}





	@Test(priority=9)
	public void VerifyProcessNameColumn() throws IOException
	{
		ProcessReport=new ProcessReportObject(driver);
		String ProcessNameColumntext=ProcessReport.ProcessName().getText();
		ArrayList<String>value =data.getData("EnterProcessName");
		String PropertiesName =value.get(1);
		boolean checktrue=ProcessNameColumntext.equalsIgnoreCase(PropertiesName);
		boolean checkfalse=!ProcessNameColumntext.equalsIgnoreCase(PropertiesName);
		if (ProcessNameColumntext.equalsIgnoreCase(PropertiesName))
		{
			assertTrue(checktrue, "The report shows " + ProcessNameColumntext + " Matching with : "+ PropertiesName);
			log.info("The Cycle Owner in the report is displayed correctly");
			System.out.println("The Cycle Owner in the report is displayed correctly");
		}

		else {
			assertFalse(checkfalse, "The report shows " + ProcessNameColumntext + " But Expected data is : "+ PropertiesName);
			log.info("The Cycle Owner in the report is not displayed correctly");
			System.out.println("The Cycle Owner in the repot is not displayed correctly");
		}
	}



//	@Test(priority=10)
//	public void VerifyOwnerOrgColumn() throws IOException
//	{
//		ProcessReport=new ProcessReportObject(driver);
//		String OwnerOrgColumntext=ProcessReport.ProcessID().getText();
//		ArrayList<String>value =data.getData("Select MRC");
//		String PropertiesName =value.get(1);
//		boolean checktrue=OwnerOrgColumntext.equalsIgnoreCase(PropertiesName);
//		boolean checkfalse=!OwnerOrgColumntext.equalsIgnoreCase(PropertiesName);
//		if (OwnerOrgColumntext.equalsIgnoreCase(PropertiesName))
//		{
//			assertTrue(checktrue, "The report shows " + OwnerOrgColumntext + " Matching with : "+ PropertiesName);
//			log.info("The Cycle Owner in the report is displayed correctly");
//			System.out.println("The Cycle Owner in the report is displayed correctly");
//		}
//
//		else {
//			assertFalse(checkfalse, "The report shows " + OwnerOrgColumntext + " But Expected data is : "+ PropertiesName);
//			log.info("The Cycle Owner in the report is not displayed correctly");
//			System.out.println("The Cycle Owner in the repot is not displayed correctly");
//		}
//	}


	@Test(priority=10)
	public void VerifyOwnerColumn() throws IOException
	{
		ProcessReport=new ProcessReportObject(driver);
		String ProcessOwnerColumntext=ProcessReport.Owner().getText();
		ArrayList<String>value =data.getData("Select Owner in process form");
		String PropertiesName =value.get(1);
		boolean checktrue=ProcessOwnerColumntext.equalsIgnoreCase(PropertiesName);
		boolean checkfalse=!ProcessOwnerColumntext.equalsIgnoreCase(PropertiesName);
		if (ProcessOwnerColumntext.equalsIgnoreCase(PropertiesName))
		{
			assertTrue(checktrue, "The report shows " + ProcessOwnerColumntext + " Matching with : "+ PropertiesName);
			log.info("The Cycle Owner in the report is displayed correctly");
			System.out.println("The Cycle Owner in the report is displayed correctly");
		}

		else {
			assertFalse(checkfalse, "The report shows " + ProcessOwnerColumntext + " But Expected data is : "+ PropertiesName);
			log.info("The Cycle Owner in the report is not displayed correctly");
			System.out.println("The Cycle Owner in the repot is not displayed correctly");
		}
	}


	@Test(priority=11)
	public void ClearAllReport() throws InterruptedException
	{
		Thread.sleep(3000);
		ProcessReport=new ProcessReportObject(driver);
		ProcessReport.ClearAllReport().click();
		Thread.sleep(3000);
	}



	@Test(priority=12)
	public void GenerateAllDataReport() throws InterruptedException
	{
		Thread.sleep(3000);
		ProcessReport=new ProcessReportObject(driver);
		ProcessReport.SubmitReport().click();
		Thread.sleep(3000);
		ProcessReport.SubmitReport().click();
		Thread.sleep(3000);
	}

	@Test(priority=13)
	public void ReportDataCount() throws InterruptedException
	{
		Thread.sleep(3000);
		ProcessReport=new ProcessReportObject(driver);
		String ReportText = ProcessReport.ReportCount().getText();
		String TrunkReportText=  ReportText.substring(29, 32);
		System.out.println("The Report count is :" + TrunkReportText);
		Thread.sleep(3000);
	}


	@Test(priority=14)
	public void ExportExcel() throws InterruptedException
	{
		ProcessReport=new ProcessReportObject(driver);
		ProcessReport.ReportExcelExport().click();
		Thread.sleep(2000);
		driver.switchTo().frame("exportpopup");
		ProcessReport.ExcelExport().click();
		Thread.sleep(2000);
	}


	@Test(priority=15)
	public void ExportCSV() throws InterruptedException
	{
		ProcessReport=new ProcessReportObject(driver);
		ProcessReport.ReportExcelExport().click();
		Thread.sleep(2000);
		ProcessReport.CSVExport().click();
		Thread.sleep(2000);
		ProcessReport.ExcelExport().click();
		Thread.sleep(5000);

	}


	@Test(priority=16)
	public void CloseReport()
	{
		ProcessReport=new ProcessReportObject(driver);
		ProcessReport.CloseReport();
	}

	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}
