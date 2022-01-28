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
public class CreateCycle2 extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	CycleFormObject cycle=null;
	ExcelUtils data = new ExcelUtils();
	ExtentReporterNG report = new ExtentReporterNG();
	ArrayList<String>value = null;
	//metricLoginUI login=new metricLoginUI(driver);

	@Test(priority =1)
	public void CreateCycleFlow() throws IOException, InterruptedException
	{

		//Login to Application
		value=data.getData("LoginApplication");
		driver=initializeDriver();
		cycle=new CycleFormObject(driver);
		driver.get(properties.getProperty("metricurl"));
		metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		///Enter Cycle Name
		Thread.sleep(1000);
		////cycle=new CycleFormObject(driver);
		cycle.OpenCycleForm().click();
		value=data.getData("EnterCycleName");
		cycle.CycleNameField().sendKeys(value.get(1));


		///Enter RTF
		value=data.getData("EnterRTF Data");
		////cycle=new CycleFormObject(driver);
		cycle.RTF(value.get(1));


		//Select Compliace Domain
		////cycle=new CycleFormObject(driver);
		value=data.getData("Select Compliance Domain drop down");
		cycle.ComplianceDomainsSLOV(value.get(1));


		//Select Organization area
		////cycle=new CycleFormObject(driver);
		value=data.getData("Select Organization Area Drop down");
		cycle.OrganizationalAreaSLOV(value.get(1));


		//Select Applicable Tecnology
		////cycle=new CycleFormObject(driver);
		value=data.getData("Select Applicable Technology");
		cycle.ApplicableTechnologyMLOV(value.get(1));


		//Select MRC
		////cycle=new CycleFormObject(driver);
		value=data.getData("Select MRC ");
		cycle.OwnerOrganizationsSLOV(value.get(1));


		//Select Owner
		//cycle=new CycleFormObject(driver);
		value=data.getData("Select Owner");
		cycle.Owners(value.get(1));

		// Select Restriction value
		//cycle=new CycleFormObject(driver);
		value=data.getData("Select Restriction Drop Down");
		cycle.RestricDropDown(value.get(1));
		//Select Action drop down
		//cycle=new CycleFormObject(driver);
		value=data.getData("Select Action Drop Down");
		cycle.ActionDropDown(value.get(1));
		//Enter comments text
		//cycle=new CycleFormObject(driver);
		value=data.getData("Enter Comments text");
		cycle.CommentText().sendKeys(value.get(1));

		//Enter Valid from
		//cycle=new CycleFormObject(driver);
		value=data.getData("ValidFrom"); 
		cycle.ValidFrom(value.get(1));
		cycle.ClickAway().click();
		//Enter Valid untill
		//cycle=new CycleFormObject(driver);
		value=data.getData("ValidUntill");
		cycle.ValidUntill(value.get(1));
		cycle.ClickAway().click();
		Thread.sleep(2000);
		//SaveForm
		//cycle=new CycleFormObject(driver);
		cycle.SaveCycleForm().click();
		Thread.sleep(2000);
		//SaveDraft
		//cycle=new CycleFormObject(driver);
		cycle.SaveDraftCycleForm();
		Thread.sleep(3000);
		//driver.switchTo().defaultContent();



		//Select Saved task
		Thread.sleep(3000);
		//cycle=new CycleFormObject(driver);
		cycle.SelectMyTask();

		//SubmitForm
		//cycle=new CycleFormObject(driver);
		cycle.SubmitForm();
		//Login with Approver user
		//cycle=new CycleFormObject(driver);
		cycle.Logout().click();
		value=data.getData("Select Owner");
		//metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().clear();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Select task for approval
		//cycle=new CycleFormObject(driver);
		cycle.SelectMyTask();
		//Request for clarification
		//cycle=new CycleFormObject(driver);
		value=data.getData("Select Action Drop Down");
		cycle.ActionDropDown(value.get(2));

		//Enter Comment Text
		//cycle=new CycleFormObject(driver);
		value=data.getData("Enter Comments text");
		cycle.CommentText().sendKeys(value.get(1));

		//Submit Form
		//cycle=new CycleFormObject(driver);
		Thread.sleep(2000);
		cycle.SubmitForm();


		///////////////////////////////////////

		//Enter with clarifier
		//cycle=new CycleFormObject(driver);
		cycle.Logout().click();
		value=data.getData("LoginApplication");
		//metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().clear();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Select My task
		//cycle=new CycleFormObject(driver);
		cycle.SelectMyTask();
		//Clarify the task
		//cycle=new CycleFormObject(driver);
		value=data.getData("Select Action Drop Down");
		cycle.ActionDropDown(value.get(1));

		//Enter Comments
		//cycle=new CycleFormObject(driver);
		value=data.getData("Enter Comments text");
		cycle.CommentText().sendKeys(value.get(1));

		//Submit form
		//cycle=new CycleFormObject(driver);
		Thread.sleep(2000);
		cycle.SubmitForm();

		//Login with Approver

		//cycle=new CycleFormObject(driver);
		cycle.Logout().click();
		value=data.getData("Select Owner");
		//metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().clear();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Select My task
		//cycle=new CycleFormObject(driver);
		cycle.SelectMyTask();

		//Clarify the task
		//cycle=new CycleFormObject(driver);
		value=data.getData("Select Action Drop Down");
		cycle.ActionDropDown(value.get(3));

		//Enter comments
		//cycle=new CycleFormObject(driver);
		value=data.getData("Enter Comments text");
		cycle.CommentText().sendKeys(value.get(1));

		//Submit form
		//cycle=new CycleFormObject(driver);
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
