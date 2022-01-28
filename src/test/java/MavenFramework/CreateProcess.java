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
import pageObjects.ProcessFormObject;
import pageObjects.metricLoginUI;

public class CreateProcess extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	ProcessFormObject process=null;
	ExcelUtils data = new ExcelUtils();

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
	public void EnterProcessName() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		process=new ProcessFormObject(driver);
		process.OpenProcessForm().click();
		ArrayList<String>value =data.getData("EnterProcessName");
		process.ProcessNameField().sendKeys(value.get(1));
	}

	@Test(priority=3)
	public void EnterDescriptionData() throws InterruptedException, IOException
	{
		ArrayList<String>value =data.getData("Enter Description RTF Data");
		process=new ProcessFormObject(driver);
		process.RTF(value.get(1));
	}

	@Test(priority=4)
	public void SelectCycleName() throws InterruptedException, IOException
	{
		process=new ProcessFormObject(driver);
		ArrayList<String>value =data.getData("EnterCycleName");
		process.CycleNameSLOV(value.get(1));

	}

	@Test(priority=5)
	public void SelectOwnerOrg() throws InterruptedException, IOException
	{
		process=new ProcessFormObject(driver);
		ArrayList<String>value =data.getData("Select Owner Organizations");
		process.OwnerOrganizationsSLOV(value.get(1));
	}

	@Test(priority=6)
	public void SelectOwner() throws InterruptedException, IOException
	{
		process=new ProcessFormObject(driver);
		ArrayList<String>value =data.getData("Select Owner in process form");
		process.Owners(value.get(1));
	}

//	@Test(priority=7)
//	public void SelectL1Approver() throws InterruptedException, IOException
//	{
//		process=new ProcessFormObject(driver);
//		ArrayList<String>value =data.getData("L1 Approver");
//		process.Level1Approver(value.get(1));
//	}


	@Test(priority=8)
	public void SelectRestricdropDown() throws IOException
	{
		process=new ProcessFormObject(driver);
		ArrayList<String>value =data.getData("Select Restriction Drop Down in process form");
		process.RestricDropDown(value.get(1));
	}

	@Test(priority=9)
	public void SelectActionDropDown() throws IOException
	{
		process=new ProcessFormObject(driver);
		ArrayList<String>value =data.getData("Select Action Drop Down in process form");
		process.ActionDropDown(value.get(1));
	}

	@Test(priority=10)
	public void SubmitForm() throws IOException, InterruptedException
	{
		process=new ProcessFormObject(driver);
		process.SubmitForm();
	}

	@Test(priority=11)
	public void EnterWithOwner() throws IOException, InterruptedException
	{
		process=new ProcessFormObject(driver);
		process.Logout().click();
		ArrayList<String>value =data.getData("L1 Approver");
		metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().clear();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		process.SelectMyTask();
		value =data.getData("Select Action Drop Down in process form");
		process.ActionDropDown(value.get(2));

	}

	@Test(priority=12)
	public void SubmitForm2() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		process=new ProcessFormObject(driver);
		process.SubmitForm();
	}


	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}
