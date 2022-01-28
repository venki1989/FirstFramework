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
import pageObjects.CycleReportObject;
import pageObjects.metricLoginUI;

public class SoxCycleReport extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	CycleReportObject cycleReport=null;
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
	public void OpenSoxCycleReport() throws InterruptedException
	{
		cycleReport=new CycleReportObject(driver);
		cycleReport.CycleReportLink().click();
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void ExpandReport() throws InterruptedException
	{
	    Thread.sleep(5000);
		cycleReport=new CycleReportObject(driver);
		Actions mouse = new Actions(driver);
		Thread.sleep(5000);
		System.out.println("waiting for 3 seconds");
		//mouse.doubleClick(cycleReport.ReportExpand()).build().perform();
		mouse.moveToElement(cycleReport.ReportExpand()).click().build().perform();
		//mouse.click(cycleReport.ReportExpand());
		
	}
	
	
	@Test(priority=4)
	public void EnterCycleFilterData() throws InterruptedException, IOException
	{

		cycleReport=new CycleReportObject(driver);
		Thread.sleep(2000);
		ArrayList<String>value =data.getData("EnterCycleFilterData");
		cycleReport.CycleFilter(value.get(1));
	}
	
	 
	@Test(priority=5)
	public void GenerateReport() throws InterruptedException
	{
		Thread.sleep(3000);
		cycleReport=new CycleReportObject(driver);
		cycleReport.SubmitReport().click();
		Thread.sleep(3000);
		cycleReport.SubmitReport().click();
	}
	
	

	
	@Test(priority=6)
	public void VerifyCycleNameColumn() throws IOException, InterruptedException
	{
		cycleReport=new CycleReportObject(driver);
		Thread.sleep(3000);
		String CycleNameColumntext=cycleReport.CycleNameColumn().getText();
		System.out.println("Cycle name : "+ CycleNameColumntext);
		ArrayList<String>value =data.getData("VerifyCycleNameColumn");
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

	@Test(priority=7)
	public void VerifyCycleOwnerOrgColumn() throws IOException
	{
		cycleReport=new CycleReportObject(driver);
		String CycleOwnerOrgColumntext=cycleReport.CycleOwnerOrg().getText();
		ArrayList<String>value =data.getData("VerifyCycleOwnerOrgColumn");
		String PropertiesName =value.get(1);
		boolean checktrue=CycleOwnerOrgColumntext.equalsIgnoreCase(PropertiesName);
		boolean checkfalse=!CycleOwnerOrgColumntext.equalsIgnoreCase(PropertiesName);
		if (CycleOwnerOrgColumntext.equals(PropertiesName))
		{
			assertTrue(checktrue, "The report shows " + CycleOwnerOrgColumntext+ " Matching with : "+ PropertiesName);
			log.info("The Cycle OwnerOrg in the report is displayed correctly");
			System.out.println("The Cycle OwnerOrg in the report is displayed correctly");
		}
		
		else {
			assertFalse(checkfalse, "The report shows " + CycleOwnerOrgColumntext + " But Expected data is : "+ PropertiesName);
			log.info("The Cycle OwnerOrg in the report is not displayed correctly");
			System.out.println("The Cycle OwnerOrg in the repot is not displayed correctly");
		}
	}

	
	@Test(priority=8)
	public void VerifyCycleOwnerColumn() throws IOException
	{
		cycleReport=new CycleReportObject(driver);
		String CycleOwnerColumntext=cycleReport.CycleOwner().getText();
		ArrayList<String>value =data.getData("VerifyCycleOwnerColumn");
		String PropertiesName =value.get(1);
		boolean checktrue=CycleOwnerColumntext.equalsIgnoreCase(PropertiesName);
		boolean checkfalse=!CycleOwnerColumntext.equalsIgnoreCase(PropertiesName);
		if (CycleOwnerColumntext.equalsIgnoreCase(PropertiesName))
		{
			assertTrue(checktrue, "The report shows " + CycleOwnerColumntext + " Matching with : "+ PropertiesName);
			log.info("The Cycle Owner in the report is displayed correctly");
			System.out.println("The Cycle Owner in the report is displayed correctly");
		}
		
		else {
			assertFalse(checkfalse, "The report shows " + CycleOwnerColumntext + " But Expected data is : "+ PropertiesName);
			log.info("The Cycle Owner in the report is not displayed correctly");
			System.out.println("The Cycle Owner in the repot is not displayed correctly");
		}
	}

	
	
	@Test(priority=9)
	public void ClearAllReport() throws InterruptedException
	{
		Thread.sleep(3000);
		cycleReport=new CycleReportObject(driver);
		cycleReport.ClearAllReport().click();
		Thread.sleep(3000);
	}
	

	
	@Test(priority=10)
	public void GenerateAllDataReport() throws InterruptedException
	{
		Thread.sleep(3000);
		cycleReport=new CycleReportObject(driver);
		cycleReport.SubmitReport().click();
		Thread.sleep(3000);
		cycleReport.SubmitReport().click();
		Thread.sleep(3000);
	}
	
	@Test(priority=11)
	public void ReportDataCount() throws InterruptedException
	{
		Thread.sleep(3000);
		cycleReport=new CycleReportObject(driver);
		String ReportText = cycleReport.ReportCount().getText();
		String TrunkReportText=  ReportText.substring(29, 32);
		System.out.println("The Report count is :" + TrunkReportText);
		Thread.sleep(3000);
	}
	
	
	@Test(priority=12)
	public void ExportExcel() throws InterruptedException
	{
		cycleReport=new CycleReportObject(driver);
		cycleReport.ReportExcelExport().click();
		Thread.sleep(2000);
		driver.switchTo().frame("exportpopup");
		cycleReport.ExcelExport().click();
		Thread.sleep(2000);
	}

	
	@Test(priority=13)
	public void ExportCSV() throws InterruptedException
	{
		cycleReport=new CycleReportObject(driver);
		cycleReport.ReportExcelExport().click();
		Thread.sleep(2000);
		cycleReport.CSVExport().click();
		Thread.sleep(2000);
		cycleReport.ExcelExport().click();
		Thread.sleep(5000);
		
	}
	
	
	@Test(priority=14)
	public void CloseReport()
	{
		cycleReport=new CycleReportObject(driver);
		cycleReport.CloseReport();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}
