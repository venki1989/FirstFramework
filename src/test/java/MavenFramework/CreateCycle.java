package MavenFramework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import Resources.ExcelUtils;
import Resources.base;
import pageObjects.CycleFormObject;
import pageObjects.metricLoginUI;
import Resources.ExtentReporterNG;
public class CreateCycle extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	CycleFormObject cycle=null;
	ExcelUtils data = new ExcelUtils();
	ExtentReporterNG report = new ExtentReporterNG();

	@Test(priority=1)
	public void LoginApplication() throws IOException, InterruptedException
	{
		//Login to Application
		ArrayList<String>value =data.getData("LoginApplication");
		driver=initializeDriver();
		driver.get(properties.getProperty("metricurl"));
		metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority=2)
	public void EnterCycleName() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		cycle=new CycleFormObject(driver);
		cycle.OpenCycleForm().click();
		ArrayList<String>value =data.getData("EnterCycleName");
		cycle.CycleNameField().sendKeys(value.get(1));
	}

	@Test(priority=3)
	public void EnterRTFData() throws InterruptedException, IOException
	{
		ArrayList<String>value =data.getData("EnterRTF Data");
		cycle=new CycleFormObject(driver);
		cycle.RTF(value.get(1));
	}

	@Test(priority=4)
	public void SelectComplianceDomain() throws InterruptedException, IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Select Compliance Domain drop down");
		cycle.ComplianceDomainsSLOV(value.get(1));

	}

	@Test(priority=5)
	public void SelectOrganizationArea() throws InterruptedException, IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Select Organization Area Drop down");
		cycle.OrganizationalAreaSLOV(value.get(1));
	}

	@Test(priority=6)
	public void SelectApplicableTechnology() throws InterruptedException, IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Select Applicable Technology");
		cycle.ApplicableTechnologyMLOV(value.get(1));
	}

	@Test(priority=7)
	public void SelectMRC() throws InterruptedException, IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Select MRC");
		cycle.OwnerOrganizationsSLOV(value.get(1));
	}

	@Test(priority=8)
	public void SelectOwner() throws InterruptedException, IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Select Owner");
		cycle.Owners(value.get(1));
	}

	@Test(priority=9)
	public void SelectRestricdropDown() throws IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Select Restriction Drop Down");
		cycle.RestricDropDown(value.get(1));
	}

	@Test(priority=10)
	public void SelectActionDropDown() throws IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Select Action Drop Down");
		cycle.ActionDropDown(value.get(1));
	}


	@Test(priority=11)
	public void EnterCommentText() throws IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Enter Comments text");
		cycle.CommentText().sendKeys(value.get(1));

	}


	@Test(priority=12)
	public void EnterValidFromDate() throws IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("ValidFrom"); 
		cycle.ValidFrom(value.get(1));
		cycle.ClickAway().click();
	}   

	@Test(priority=13)
	public void EnterUntillDate() throws IOException, InterruptedException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("ValidUntill");
		cycle.ValidUntill(value.get(1));
		cycle.ClickAway().click();
		Thread.sleep(2000);
	}   
	@Test(priority=14)
	public void SaveForm() throws IOException, InterruptedException
	{
		cycle=new CycleFormObject(driver);
		cycle.SaveCycleForm().click();
		Thread.sleep(2000);
	}



	@Test(priority=15)
	public void SaveDraftForm() throws IOException, InterruptedException
	{
		cycle=new CycleFormObject(driver);
		cycle.SaveDraftCycleForm();
		Thread.sleep(3000);
		//driver.switchTo().defaultContent();
	}


	@Test(priority=16)
	public void SelectMyTask3() throws IOException, InterruptedException
	{Thread.sleep(3000);
	cycle=new CycleFormObject(driver);
	cycle.SelectMyTask();
	}

	@Test(priority=17)
	public void SubmitForm() throws InterruptedException, IOException
	{
		cycle=new CycleFormObject(driver);
		cycle.SubmitForm();
	}   




	@Test(priority=18)
	public void EnterWithApprover() throws IOException, InterruptedException
	{
		cycle=new CycleFormObject(driver);
		cycle.Logout().click();
		ArrayList<String>value =data.getData("Select Owner");
		metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().clear();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}



	@Test(priority=19)
	public void RequestForClarification() throws IOException, InterruptedException
	{
		cycle=new CycleFormObject(driver);
		cycle.SelectMyTask();
		ArrayList<String>value =data.getData("Select Action Drop Down");
		cycle.ActionDropDown(value.get(2));

	}

	@Test(priority=20)
	public void EnterCommentText1() throws IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Enter Comments text");
		cycle.CommentText().sendKeys(value.get(1));

	}

	@Test(priority=21)
	public void SubmitForm2() throws InterruptedException, IOException
	{
		cycle=new CycleFormObject(driver);
		Thread.sleep(2000);
		cycle.SubmitForm();
	}  

	///////////////////////////////////////

	@Test(priority=22)
	public void EnterWithClarifier() throws IOException, InterruptedException
	{
		cycle=new CycleFormObject(driver);
		cycle.Logout().click();
		ArrayList<String>value =data.getData("LoginApplication");
		metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().clear();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}



	@Test(priority=23)
	public void Clarification() throws IOException, InterruptedException
	{
		cycle=new CycleFormObject(driver);
		cycle.SelectMyTask();
		ArrayList<String>value =data.getData("Select Action Drop Down");
		cycle.ActionDropDown(value.get(1));

	}

	@Test(priority=24)
	public void EnterCommentText11() throws IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Enter Comments text");
		cycle.CommentText().sendKeys(value.get(1));

	}

	@Test(priority=25)
	public void SubmitForm3() throws InterruptedException, IOException
	{
		cycle=new CycleFormObject(driver);
		Thread.sleep(2000);
		cycle.SubmitForm();
	}  

	/////////////////////////////////////

	//*************************************//


	///////////////////////////////////////

	@Test(priority=26)
	public void Approve() throws IOException
	{
		cycle=new CycleFormObject(driver);
		cycle.Logout().click();
		ArrayList<String>value =data.getData("Select Owner");
		metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().clear();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}

	@Test(priority=27)
	public void SelectMyTask2() throws IOException, InterruptedException
	{
		cycle=new CycleFormObject(driver);
		cycle.SelectMyTask();
	}



	@Test(priority=28)
	public void Clarification2() throws IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Select Action Drop Down");
		cycle.ActionDropDown(value.get(3));

	}

	@Test(priority=29)
	public void EnterCommentText12() throws IOException
	{
		cycle=new CycleFormObject(driver);
		ArrayList<String>value =data.getData("Enter Comments text");
		cycle.CommentText().sendKeys(value.get(1));

	}

	@Test(priority=30)
	public void SubmitForm4() throws InterruptedException, IOException
	{
		cycle=new CycleFormObject(driver);
		Thread.sleep(2000);
		cycle.SubmitForm();
	}  



	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}
